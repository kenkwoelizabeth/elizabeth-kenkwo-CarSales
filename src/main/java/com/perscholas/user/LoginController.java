package com.perscholas.user;


import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login() {
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
