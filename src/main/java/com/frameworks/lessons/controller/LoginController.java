/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frameworks.lessons.controller;


import com.frameworks.lessons.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author papus
 */
@Controller 
public class LoginController {
    
    
    
    @GetMapping(value = "/success")
    public String successLogin(Model model){
    model.addAttribute("userName",SecurityContextHolder.getContext().getAuthentication().getName());
    model.addAttribute("WasWrongAuth","false");
    return "user";
}
    @GetMapping(value = "/error")
    public String wrongLogin(Model model){
    model.addAttribute("WasWrongAuth","true");
//    model.addAttribute("username",  );
    return "login";
}
 
}
