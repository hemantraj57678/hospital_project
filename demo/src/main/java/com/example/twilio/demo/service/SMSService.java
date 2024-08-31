package com.example.twilio.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromNumber;

    public String sendSMS(String toNumber, String messageContent) {
        try {
            Twilio.init(accountSid, authToken);
            Message message = Message.creator(
                    new PhoneNumber(toNumber),
                    new PhoneNumber(fromNumber),
                    messageContent
            ).create();

            log.info("SMS sent successfully to " + toNumber);
            return "Message sent successfully";
        } catch (Exception e) {
            log.error("Failed to send SMS: " + e.getMessage());
            return "Failed to send message";
        }
    }
}
