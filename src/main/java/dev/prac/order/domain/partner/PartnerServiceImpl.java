package dev.prac.order.domain.partner;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. command -> initPartner
        // 2. initPartner save to DB
        // 3. Partner -> PartnerInfo AND return

        var initPartner = command.toEntity();
        Partner partner = partnerStore.store(initPartner);
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional(readOnly = true)
    public PartnerInfo getPartnerInfo(String partnerToken) {
        // 1. partnerToken -> Partner
        // Partner -> PartnerInfo ANd Return
        Partner partner = partnerReader.getPartner(partnerToken);
        return new PartnerInfo((partner));
    }

    @Override
    @Transactional
    public PartnerInfo enablePartner(String partnerToken) {
        // 1. partnerToken -> Partner
        // 2. partner.enable()
        Partner partner = partnerReader.getPartner(partnerToken);
        partner.enable();
        return new PartnerInfo(partner);
    }

    @Override
    public PartnerInfo disablePartner(String partnerToken) {
        return null;
    }
}
