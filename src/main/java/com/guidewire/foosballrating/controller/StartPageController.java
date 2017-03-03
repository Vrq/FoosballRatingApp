package com.guidewire.foosballrating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartPageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String submit() {
        return "submit.html";
    }
}
