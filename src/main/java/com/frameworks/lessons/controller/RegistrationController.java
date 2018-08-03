package com.frameworks.lessons.controller;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import com.frameworks.lessons.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@ComponentScan("com.frameworks.lessons.validator")
public class RegistrationController {

    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView newUserPage() {
        ModelAndView mav = new ModelAndView("registration", "user", new User());
        return mav;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@ModelAttribute("user") @Valid User user, Model model, BindingResult result,
                                      final RedirectAttributes redirectAttributes) {

        userValidator.validate(user, result);

        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Login " + user.getName() + " is already in use");
            mav.setViewName("redirect:/registration.html");
            return mav;
        }

        userService.save(user);
        mav.setViewName("redirect:/login.html");

        return mav;
    }
}
