package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class BaseController {

    @GetMapping(value = {"/", "/index"})
    private ModelAndView index(ModelAndView view) {
        view.addObject("title", "Index page");
        view.setViewName("index");
        return view;
    }

    @GetMapping(value = "/login")
    private ModelAndView login(ModelAndView view) {
        User user = new User();
        view.getModelMap().addAttribute(user);
        view.addObject("title", "Login page");
        view.setViewName("login");
        return view;
    }

}
