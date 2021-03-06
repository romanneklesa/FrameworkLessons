/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frameworks.lessons.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author papus
 */
@Controller 
public class LoginController {

    @GetMapping(value = "/success")
    public String successLogin(Model model, HttpServletRequest request) {
        model.addAttribute("userName", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("WasWrongAuth", "false");
        if (request.isUserInRole("ADMIN")) return "admin";
        else return "user";
    }

    @GetMapping(value = "/error")
    public String wrongLogin(Model model) {
        model.addAttribute("WasWrongAuth", "true");
        return "login";
    }
 
}
