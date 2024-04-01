package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* @ControllerAdvice가 적용된 클래스의 @ExceptionHandler는 전역적으로 기능한다. */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception){
        System.out.println("message : " + exception.getMessage());
        System.out.println("global(전역) 레벨의 exception 처리");
        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model){
        model.addAttribute("exception", exception);
        System.out.println("global(전역) 레벨의 exception 처리");
        return "error/memberRegist";
    }

    /* 상위 타입의 Exception을 통해 Handler를 작성하면 하위 타입의 모든 Exception을 처리 가능 */
    @ExceptionHandler(Exception.class)
    public String defaultException(Exception exception){

        return "error/default";
    }
}
