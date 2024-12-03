package com.seq.login.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {


    @GetMapping("/mypage")
    public String myPage(Authentication auth) {
        System.out.println(auth);
        System.out.println(auth.getName()); //아이디출력가능
        System.out.println(auth.isAuthenticated()); //로그인여부 검사가능
        System.out.println(auth.getAuthorities().contains(new SimpleGrantedAuthority("일반")));
        return "mypage.html";
    }
}
