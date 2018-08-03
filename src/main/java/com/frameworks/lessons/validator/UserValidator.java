package com.frameworks.lessons.validator;

import com.frameworks.lessons.entity.User;
import com.frameworks.lessons.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service("userValidator")
@Transactional
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "is already in use");
        if (userService.findByName(user.getName()) != null) {
            errors.rejectValue("name", "Duplicate.userForm.name");
        }
    }
}
