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
public class UserUpdateController {

    private UserService userService;

    public UserUpdateController() {
        userService = new UserServiceImpl();
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("newUser")User userToUpdate){
        ModelAndView modelView = null;
        if (userService.isUserValid(userToUpdate)) {
            userService.updateUser(userToUpdate);
            modelView = new ModelAndView("userInfo");
            modelView.addObject("user", userToUpdate);
            modelView.addObject("command", userToUpdate);
            modelView.addObject("message", "User information updated");
            return modelView;
        }
        else {
            userService.getUserInfo(userToUpdate);
            System.out.println(userToUpdate.getUserInfo().getName());
            modelView = new ModelAndView("userInfo", "command", userToUpdate);
            modelView.addObject("message", "Unable to update");
            return modelView;
        }

    }

}
