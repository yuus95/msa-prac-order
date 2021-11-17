package dev.prac.order.infrastructure.partner;

import dev.prac.order.domain.partner.Partner;
import dev.prac.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(String partnerToken) {
        partnerRepository.findByPartnerToken(partnerToken).orElseThrow(() -> new RuntimeException());
        return null;
    }
}
