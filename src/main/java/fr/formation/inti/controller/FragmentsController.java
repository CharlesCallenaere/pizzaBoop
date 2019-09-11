package fr.formation.inti.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class FragmentsController {

    @GetMapping("/fragments")
    public String getHome() {
        return "fragment/header.html";
    }
}
