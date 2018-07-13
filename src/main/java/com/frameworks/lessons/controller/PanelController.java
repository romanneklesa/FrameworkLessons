package com.frameworks.lessons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/panel")
public class PanelController {

    @GetMapping(value = {"", "/", "/index"})
    private String index() {
        return "panel/index";
    }

}
