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
        System.out.println(str.charAt(0));    // 일부러 에러 발생시킴
        return "/";
    }
    @ExceptionHandler(NullPointerException.class)   // nullPointerException메소드에 발생한 에러를 받아서
    public String nullPointerExceptionHandler(NullPointerException exception){
        System.out.println("message : " + exception.getMessage());
        System.out.println("controller(지역) 레벨의 exception 처리");
        return "error/nullPointer";                 // error 폴더내 nullPointer 파일을 뷰로 지정해 처리
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
        System.out.println("controller(지역) 레벨의 exception 처리");
        return "error/memberRegist";
    }

}
