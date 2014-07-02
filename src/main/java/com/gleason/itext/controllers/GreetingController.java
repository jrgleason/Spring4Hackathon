package com.gleason.itext.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting/**")
public class GreetingController {
    @RequestMapping("/")
    public String test(){
      System.out.println("Test");
      return "Test";
    }
}
