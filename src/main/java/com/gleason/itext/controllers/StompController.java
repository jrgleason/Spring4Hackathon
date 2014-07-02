package com.gleason.itext.controllers;

import com.gleason.itext.model.AlertMessage;
import com.gleason.itext.model.Greeting;
import com.gleason.itext.model.HelloMessage;
import com.google.gson.Gson;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: jgleason
 * Date: 6/30/14
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class StompController {
    @MessageMapping("/hello")
    @SendTo("/topic/greet")
    public Greeting greet(HelloMessage message) throws Exception{
        System.out.println("Inside the method "+message.getName());
        Thread.sleep(3000);
        return new Greeting("Hello, "+message.getName()+"!");
    }
    @MessageMapping("/alert")
    @SendTo("/topic/alert")
    public Greeting alert(AlertMessage message) throws Exception{
        Gson gson = new Gson();
        return new Greeting(gson.toJson(message, AlertMessage.class));
    }
}
