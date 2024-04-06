package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerException(){
        String str = null;
        System.out.println(str.charAt(0));
        return "/";
    }
    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception, Model model){
        model.addAttribute("exception", exception);
        return "error/nullPointer";
    }

    @GetMapping("controller-user")
    public String userException() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("회원가입 불가");
        return "/";
    }
    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model){
        model.addAttribute("exception", exception);
        return "error/memberRegist";
    }
}
