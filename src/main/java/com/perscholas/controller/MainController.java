package com.perscholas.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class MainController {
    // *** Because of what's specified in SecurityConfiguration,
    // this is the MAIN page when a user goes to http://localhost:8080
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/default")
    public String defaultAfterLogin(){
        UserDetails userPrinciple= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userPrinciple.getAuthorities();
        System.out.println(authorities);
        if(authorities.contains("ROLE_ADMIN")){
            return "redirect:/salesRep";
        }
        return "redirect:/car";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }
}
