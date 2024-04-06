package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class otherController {

    @GetMapping("other-controller-null")
    public String otherNullPointerException(){
        String str = null;
        System.out.println(str.charAt(0));
        return "/";
    }

    @GetMapping("other-controller-user")
    public String otherUserException() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("전역 회원가입 불가");
        return "/";
    }

    @GetMapping("other-controller-array")
    public String arrayException(){
        double[] arr = new double[0];
        System.out.println(arr[0]);
        return "/";
    }
}
