package com.rbc.mqspringservice;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class receiveMessage {
    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String msg){
        System.out.println("MSG : " + msg);
        empRecord emprecord = new empRecord();
        emprecord.empMapper(msg);
    }
}
