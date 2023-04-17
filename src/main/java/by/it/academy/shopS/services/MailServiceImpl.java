package by.it.academy.shopS.services;

import by.it.academy.shopS.configs.MailProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailProperties mailProperties;

    @Override
    public void sendMail() {
        String email = mailProperties.getEmail();
        log.info("Send email");
    }
}
