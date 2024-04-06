package com.ohgiraffers.home;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NullPointerException.class)
//    public String nullPointerExceptionHandler(NullPointerException exception, Model model){
//        model.addAttribute("exception", exception);
//        return "error/nullPointer";
//    }
//
//    @ExceptionHandler(MemberRegistException.class)
//    public String userExceptionHandler(MemberRegistException exception, Model model){
//        model.addAttribute("exception", exception);
//        return "error/memberRegist";
//    }

    @ExceptionHandler(Exception.class)
    public String defaultException(Exception exception, Model model){
        model.addAttribute("exception", exception);
        return "error/default";
    }
}
