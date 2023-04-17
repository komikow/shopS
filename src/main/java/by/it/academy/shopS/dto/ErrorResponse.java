package by.it.academy.shopS.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private final String message;
    private LocalDateTime localDateTime;
    private final String TECHNICAL_SUPPORT_PHONE = "+375 29 000 00 00";

    public ErrorResponse(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }
}
