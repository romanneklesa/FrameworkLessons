package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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

    /*@RequestMapping(method = RequestMethod.POST, value="/signup" )
    public String onSubmit(@ModelAttribute("user") User user ) {
        return  userService.add(user);
    }*/

//    @RequestMapping(value = "/profile", method = RequestMethod.GET)
//    public @ResponseBody String processAJAXRequest(@ModelAttribute("user") User user)  {
//        String response = "";
//        // Process the request
//        // Prepare the response string
//        return response;
//    }


}