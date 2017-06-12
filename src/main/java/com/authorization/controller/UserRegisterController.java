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

import javax.servlet.http.HttpServletRequest;

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
    public ModelAndView registerUser(@ModelAttribute("newUser")User newUser){
        ModelAndView modelView = null;
        if (userService.isUserValid(newUser)) {
            userService.createUser(newUser);
            modelView = new ModelAndView("userInfo");
            modelView.addObject("user", newUser);
            modelView.addObject("command", newUser);

            return modelView;
        }
        else {
            modelView = new ModelAndView("register", "command", new User());
            modelView.addObject("message", "Invalid user info");
            return modelView;
        }

    }

}
