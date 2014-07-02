package com.gleason.itext.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: jgleason
 * Date: 6/30/14
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/views/**")
public class ViewController {
    @RequestMapping("/home")
    public String loadHomePage(Model m) {
        m.addAttribute("name", "CodeTutr");
        System.out.println("Test the view controller");
        return "main";
    }
}
