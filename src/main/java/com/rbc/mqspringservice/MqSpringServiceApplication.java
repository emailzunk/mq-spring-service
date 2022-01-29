package com.rbc.mqspringservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@RestController
@EnableJms

public class MqSpringServiceApplication {

	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("send") //http://localhost:8080/send
	String send(){
		try{
			jmsTemplate.convertAndSend("DEV.QUEUE.1", "Ramesh Babu        Chandrasekaran       M20010101 E0000000001PY6");
			return "OK";
		}catch(JmsException ex){
			ex.printStackTrace();
			return "FAIL";
		}
	}

	@GetMapping("recv") //http://localhost:8080/recv
	String recv(){
		try{
			return jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString();
		}catch(JmsException ex){
			ex.printStackTrace();
			return "FAIL";
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(MqSpringServiceApplication.class, args);
	}

}
