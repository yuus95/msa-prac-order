package dev.prac.order.application.partner;

import dev.prac.order.domain.notification.NotificationService;
import dev.prac.order.domain.partner.PartnerCommand;
import dev.prac.order.domain.partner.PartnerInfo;
import dev.prac.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificationService notificationService;
    public PartnerInfo registerPartner(PartnerCommand command){
        var partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(),"title","description");
        return partnerInfo;

        //1. partnerService register
        //2. email발송

    }
}
