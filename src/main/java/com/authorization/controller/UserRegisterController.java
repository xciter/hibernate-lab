package com.authorization.controller;

import com.authorization.entities.User;
import com.authorization.service.UserService;
import com.authorization.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserRegisterController {

    private UserService userService;

    public UserRegisterController() {
        userService = new UserServiceImpl();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("register", "command", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("newUser")User newUser, ModelMap model){

        if (userService.isUserValid(newUser)) {
            userService.createUser(newUser);
            model.addAttribute("userName", newUser.getUserInfo().getName());
            model.addAttribute("password", newUser.getPassword());
            model.addAttribute("email", newUser.getUserInfo().getEmail());
            model.addAttribute("firstName", newUser.getUserInfo().getFirstName());
            model.addAttribute("secondName", newUser.getUserInfo().getSecondName());

            return "userInfo";
        }
        else {
            return "register";
        }

    }

}
