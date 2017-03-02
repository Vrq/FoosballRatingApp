package com.guidewire.foosballrating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameRestController {


    @RequestMapping("/games")
    public String games() {
        return "Tutaj powinny byc zwrocone gry";
    }
}
