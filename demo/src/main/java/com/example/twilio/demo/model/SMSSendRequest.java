package com.example.twilio.demo.model;


import lombok.Data;

@Data
public class SMSSendRequest {

    private  String destinationSMSNumber;
    private  String sendMessages;


}
