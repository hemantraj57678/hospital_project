package com.example.twilio.demo.controller;

import com.example.twilio.demo.model.SMSSendRequest;
import com.example.twilio.demo.service.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/v1")
@Slf4j
public class SmsController {

    @Autowired
    private SMSService smsService;

    @PostMapping("/processSMS")
    public ResponseEntity<String> processSMS(@RequestBody SMSSendRequest sendRequest) {
        log.info("processSMS started with request: " + sendRequest.toString());
        String response = smsService.sendSMS(sendRequest.getDestinationSMSNumber(), sendRequest.getSendMessages());
        return new ResponseEntity<>(response, response.equals("Message sent successfully") ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
