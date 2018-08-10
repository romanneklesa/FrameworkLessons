package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@ComponentScan("com.frameworks.lessons.validator")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView newUserPage() {
        ModelAndView mav = new ModelAndView("registration", "user", new User());
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@ModelAttribute("user") @Valid User user) {
        //TODO validate all user fields
        ModelAndView mav = new ModelAndView();
        userService.save(user);
        mav.setViewName("redirect:/login.html");
        return mav;
    }

    @RequestMapping(value = "/checkInputs", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String checkInputs(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "email", required = true) String email) {
        System.out.println("name=" + name + " , email=" + email);
        logger.info("check email");

        if (userService.findByEmail(email) != null) {
            return "wrongEmail";
        }
        if (userService.findByName(name) != null) {
            return "wrongName";
        }
        return "success";
    }
}
