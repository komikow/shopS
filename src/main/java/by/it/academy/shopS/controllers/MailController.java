package by.it.academy.shopS.controllers;

import by.it.academy.shopS.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("{id}")
    public ResponseEntity<Void> sendMail(@PathVariable Long id) {
        mailService.sendMail();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
