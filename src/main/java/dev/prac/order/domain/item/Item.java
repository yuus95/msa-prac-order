package dev.prac.order.domain.item;


import com.google.common.collect.Lists;
import dev.prac.order.common.exception.InvalidParamException;
import dev.prac.order.common.utils.TokenGenerator;
import dev.prac.order.domain.AbstractEntity;
import dev.prac.order.domain.item.optiongroupd.ItemOptionGroup;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.List;


/**
 * 양방향 참조를 이용하여 조건 해결하기.
 */
@Entity
@NoArgsConstructor
@Table(name = "items")
public class Item extends AbstractEntity {
    private static final String PREFIX_ITEM="itm_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemToken;
    private Long partnerId;
    private String itemName;
    private Long itemPrice;

    // Item : ItemOption 1:N
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item",cascade = CascadeType.PERSIST)
    private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();

    @Enumerated(EnumType.STRING)
    private Status status;

    private int ordering;


    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PREPARE("판매준비중"),
        ON_SALES("판매중"),
        END_OF_SALES("판매종료");

        private final String description;
    }

    @Builder
    public Item(Long partnerId, String itemName, Long itemPrice) {
        if (partnerId == null) throw  new InvalidParamException();
        if (StringUtils.isEmpty(itemName)) throw  new InvalidParamException();
        if (itemPrice == null) throw  new InvalidParamException();

        this.itemToken= TokenGenerator.randomCharacterWithPrefix(PREFIX_ITEM);
        this.partnerId = partnerId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.status = Status.PREPARE;
    }

    /**
     *  별도의 상태변화 로직을 따로 만드는것이 좋다 각자 안에서 쓰임새가 다를 수 있기 때문이다.
     */
    public void changePrepare(){
        this.status=Status.PREPARE;
    }
    public void changeOnSales(){
        this.status=Status.ON_SALES;
    }
    public void endOfSales(){
        this.status= Status.END_OF_SALES;
    }
}
