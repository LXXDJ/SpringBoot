package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"id", "pw"})
public class SecondController {

    @PostMapping("loginForm2")
    public String sessionTest2(Model model, @RequestParam String id, @RequestParam String pw){
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "loginResult";
    }

    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "loginResult";
    }
}
