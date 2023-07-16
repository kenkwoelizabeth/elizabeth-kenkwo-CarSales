package com.perscholas.frontend;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
    @GetMapping("/aboutUs")
    public String aboutUs(Model model) {
        return "frontend/aboutUs";
    }

    @GetMapping("/careers")
    public String career(Model model) {
        return "frontend/careers";
    }

    @GetMapping("/financing")
    public String financing(Model model) {
        return "frontend/financing";
    }

    @GetMapping("/staffs")
    public String ourStaff(Model model) {
        return "frontend/staffs";
    }


    // contact us controller
    @GetMapping("/contactUs")
    public String contactUs(Model model) {
        return "frontend/contactUs";
    }
}

