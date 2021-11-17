package dev.prac.order.interfaces.partner;

import dev.prac.order.application.partner.PartnerFacade;
import dev.prac.order.common.response.CommonResponse;
import dev.prac.order.domain.partner.Partner;
import dev.prac.order.domain.partner.PartnerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApicontroller {
    private final PartnerFacade partnerFacade;


    @PostMapping()
    public CommonResponse registerPartner(PartnerDto.RegisterRequest request) {
        //1. 외부에ㅐ서 전달된 파라미터(dto) -> Command, Criteria convert로직
        //2. facade 호출 -> partnerInfo노출
        //3. PartnerInfo -> CommonResponse convert And return

        //request -> command로 만드는 로직
        var command = request.toCommand();
        var partnerInfo = partnerFacade.registerPartner(command);
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }
}
