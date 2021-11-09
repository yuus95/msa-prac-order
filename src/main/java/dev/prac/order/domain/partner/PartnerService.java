package dev.prac.order.domain.partner;

public interface PartnerService {
    PartnerInfo registerPartner(PartnerCommand command);

    PartnerInfo getPartnerInfo(String partnerToken);

    PartnerInfo enablePartner(String partnerToken);

    PartnerInfo disablePartner(String partnerToken);
}
