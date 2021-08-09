package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {
    g

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){ //principal has all the information on the user logged in
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "secure";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/processregister")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if(result.hasErrors()){
            user.clearPassword();
            model.addAttribute("user", user);
            return "register";
        }
        else{
            model.addAttribute("user", user);
            model.addAttribute("message", "New user account created");
            user.setEnabled(true);
            userRepository.save(user);
            Role role = new Role(user.getUsername(), "ROLE_USER");
            roleRepository.save(role);
        }
        return "index";
        //redirecting allows for the method that the link is linked to too run while directly linking the html the method will not run.
    }

    @RequestMapping("/")
    public String index(Principal principal, Model model){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/login?logout=true"; //redirect is a keyword redirecting to @RequestMapping("/login") while ?logout is changing logout to true
    }
}
