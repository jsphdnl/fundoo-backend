package com.fr.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(value = "/v1/fr")
public class MainController {

    @RequestMapping(value = "/user")
    public ResponseEntity<String> user(Principal principal) {
        return ResponseEntity.ok(" Welcome to Fundo Rings "+principal);
    }

        @GetMapping(value = "/login")
        public String login(Model model) {

            return "loginPage.html";
        }
    }

