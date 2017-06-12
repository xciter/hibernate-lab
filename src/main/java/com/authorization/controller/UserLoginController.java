package com.authorization.controller;

import com.authorization.entities.User;
import com.authorization.service.UserService;
import com.authorization.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserLoginController {

    private UserService userService;

    public UserLoginController() {
        userService = new UserServiceImpl();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("newUser")User user){
        ModelAndView modelView = null;
        if (userService.isUserExist(user)) {
            userService.getUserInfo(user);
            modelView = new ModelAndView("userInfo");
            modelView.addObject("user", user);
            modelView.addObject("command", user);

            return modelView;
        }
        else {
            modelView = new ModelAndView("login", "command", new User());
            modelView.addObject("message", "Invalid username");
            return modelView;
        }

    }
}
