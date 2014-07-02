package com.gleason.itext.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oldgroovy/**")
public class GroovyController {
    @RequestMapping("/")
    def index(){
      "Welcome To the dark Side";
    }
}
