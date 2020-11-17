package com.funix.lab04.asm21.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/party-address")
public class PartyAddressController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("party-address");
    }
}
