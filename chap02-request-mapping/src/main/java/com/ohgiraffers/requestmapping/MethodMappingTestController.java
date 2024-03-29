package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* DispatcherServlet은 웹 요청을 받는 즉시 @Controller가 달린 컨트롤러 클래스에 처리를 위임한다.
*  그 과정은 컨트롤러 클래스이 핸들러 메소드에 선언된 다양한 @RequestMapping 설정 내용에 따른다. */
@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")
    public String registMenu(Model model){

        /* Model 객체에 addAttribute 메서드를 이용해 key, value를 추가하면 view에서 사용 가능
        *  view-resolver에서 다룬다. */
        model.addAttribute("message", "신규 메뉴 등록용 핸들러 메소드 호출");

        /* 반환하고자 하는 view의 경로를 포함한 이름 작성 (resources/templates 하위부터 경로 작성) */
        return "mappingResult";
    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.GET)     // get방식의 요청만 받겠다고 지정
    public String modifyMenu(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @GetMapping("/menu/delete")     // get 요청만 처리
    public String getDeleteMenu(Model model){
        model.addAttribute("message", "GET 방식의 삭제용 핸들러 메소드 호출");

        return "mappingResult";
    }

    @PostMapping("/menu/delete")     // post 요청만 처리
    public String postDeleteMenu(Model model){
        model.addAttribute("message", "POST 방식의 삭제용 핸들러 메소드 호출");

        return "mappingResult";
    }
}
