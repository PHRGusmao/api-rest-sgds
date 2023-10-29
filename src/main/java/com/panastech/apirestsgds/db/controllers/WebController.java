package com.panastech.apirestsgds.db.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "index"; // Isso corresponde ao nome do arquivo HTML que será servido (index.html).
    }
}