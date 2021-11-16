package dev.prac.order.interfaces.partner;

import dev.prac.order.application.partner.PartnerFacade;
import dev.prac.order.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApicontroller {
    private final PartnerFacade partnerFacade;


//    public CommonResponse registerPartner(){
//        //1. 외부에ㅐ서 전달된 파라미터(dto) -> Command, Criteria convert로직
//        //2. facade 호출 -> partnerInfo노출
//        //3. PartnerInfo -> CommonResponse convert And return
//        return CommonResponse.success()
//    }
}
