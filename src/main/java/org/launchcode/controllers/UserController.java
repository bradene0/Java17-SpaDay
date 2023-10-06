package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile() {
        //logic for handling user profile page
        return "user/profile"; //the name of a view template
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser() {
        // handling user edit page
        return "user/edit"; //ame of a view template
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayAddUserForm() {
        //Renders the form for adding a user
        return "user/add"; //NAame of iew template for the add user form
    }

    @RequestMapping(value = "./add.html", method = RequestMethod.POST)
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // Form submission handling code
        if (user.getPassword() != null && user.getPassword().equals(verify)) {
            // Passwords match, add the username to the model
            model.addAttribute("username", user.getUsername());
            // Add the email to the model
            model.addAttribute("email", user.getEmail());
            // Redirect to the index.html page
            return "redirect:/index.html";
        } else {
            // Passwords don't match, render the form again with an error message
            model.addAttribute("error", "Passwords do not match");
            return "user/add"; // Name of view template for the add user form
        }
    }
}
