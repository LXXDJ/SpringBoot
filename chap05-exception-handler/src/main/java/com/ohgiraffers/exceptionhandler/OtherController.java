package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @GetMapping("other-controller-null")
    public String othernullPointerExceptionTest(){
        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }

    @GetMapping("other-controller-user")
    public String otheruserExceptionTest() throws MemberRegistException {
        boolean check = true;
        if(check) throw new MemberRegistException("회원가입 불가");

        return "/";
    }

    /* ArrayIndexOutOfBoundsException 발생 */
    @GetMapping("other-controller-array")
    public String otherArrayExceptionTest(){
        double[] array = new double[0];
        System.out.println(array[0]);

        return "/";
    }
}
