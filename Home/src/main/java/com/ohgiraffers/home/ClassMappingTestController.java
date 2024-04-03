package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order/*")
public class ClassMappingTestController {

    @GetMapping("/regist")
    public String registOrder(Model model){
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출");
        return "mappingResult";
    }

//    @PostMapping(value = {"modify", "delete"})
    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)
    public String ModifyAndDelete(Model model){
        model.addAttribute("message", "POST 방식의 주문 수정&삭제용 핸들러 메소드 호출");
        return "mappingResult";
    }

//    @RequestMapping(value = {"regist", "modify"})
//    public String RegistAndModify(Model model){
//        model.addAttribute("message", "GET&POST 방식의 주문 등록&수정용 핸들러 메소드 호출");
//        return "mappingResult";
//    }

    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable int orderNo){
        model.addAttribute("message", "GET 방식의 " + orderNo + "번 주문 상세내용 조회용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping
    public String otherRequest(Model model){
        model.addAttribute("message", "order 하위의 준비되지 않은 요청이 왔을 때 호출");
        return "mappingResult";
    }
}
