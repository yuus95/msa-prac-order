package dev.prac.order.infrastructure.notification;

import dev.prac.order.domain.notification.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationExecutor implements NotificationService {
    @Override
    public void sendEmail(String email, String title, String description) {
        log.info("sendEmail");
    }

    @Override
    public void sendKakao(String phoneNo, String description) {
        log.info("sendKaKao");
    }

    @Override
    public void sendSms(String phoneNo, String description) {
        log.info("sendSms");
    }
}
