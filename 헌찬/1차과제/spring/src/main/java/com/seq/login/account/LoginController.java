package com.seq.login.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login")
    String register(Model model) {
        model.addAttribute("error", "");
        return "login.html";
    }
}
