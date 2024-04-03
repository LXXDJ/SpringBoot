package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingTestController {

    @RequestMapping("/menu/regist")
    public String registMenuGET(Model model){
        model.addAttribute("message", "방식의 신규 메뉴 등록용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping(value="/menu/modify", method = RequestMethod.GET)
    public String modifyMenuGET(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 수정용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String deleteMenuGET(Model model){
        model.addAttribute("message", "GET 방식의 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }

//    @RequestMapping("/menu/regist")
//    public String registMenuPOST(Model model){
//        model.addAttribute("message", "POST 방식의 신규 메뉴 등록용 핸들러 메소드 호출");
//        return "mappingResult";
//    }

    @RequestMapping(value = "/menu/modify", method = RequestMethod.POST)
    public String modifyMenuPOST(Model model){
        model.addAttribute("message", "POST 방식의 신규 메뉴 수정용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @PostMapping("/menu/delete")
    public String deleteMenuPOST(Model model){
        model.addAttribute("message", "POST 방식의 신규 메뉴 삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }
}
