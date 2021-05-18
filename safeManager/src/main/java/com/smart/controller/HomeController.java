package com.smart.controller;

import com.smart.dao.UserRepository;
import com.smart.entities.User;
import com.smart.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model){

        model.addAttribute("title","SafeManager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){

        model.addAttribute("title","About");
        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model){

        model.addAttribute("title","Signup");
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user,
                               @RequestParam(value = "agreement",
        defaultValue = "false")
        boolean agreement,
        Model model, HttpSession session)

    {
        try {
            if (!agreement){

                System.out.println("You need to agree to the terms and conditions!");
                throw new Exception("You need to agree to the terms and conditions!");
            }

            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("default.png");

            System.out.println("Agreement" + agreement);
            System.out.println("User" + user);

            User result = this.userRepository.save(user);

            model.addAttribute("user",new User());

            session.setAttribute("message", new Message("Successfully registered!", "alert-success"));
            return "signup";

        } catch (Exception e){

            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message",new Message("Something Went wrong"+ e.getMessage(),"alert-danger!"));
            return "Signup";
        }
    }

}
