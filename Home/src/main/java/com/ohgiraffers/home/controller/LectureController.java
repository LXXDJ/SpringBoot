package com.ohgiraffers.home.controller;

import com.ohgiraffers.home.model.dto.MemberDTO;
import com.ohgiraffers.home.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("lecture")
public class LectureController {

    @GetMapping("/expression")
    public ModelAndView expression(ModelAndView mv){
        mv.addObject("member", new MemberDTO("판다", 20, '여', "서울시 종로구"));
        mv.addObject("hello", "<h3>hello thymeleaf</h3>");

        mv.setViewName("/lecture/expression");
        return mv;
    }

    // GetMapping 주소와 html 파일명이 다르면 setViewName으로 지정해주어야 한다. (같을 경우 생략가능)
    @GetMapping("/conditional") // index.html 버튼 주소와 매핑
    public ModelAndView conditional(ModelAndView mv){
        mv.addObject("num", 328);
        mv.addObject("str", "바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("판다", 20, '여', "서울시 종로구 8강"));
        memberList.add(new MemberDTO("다람쥐", 900, '무', "서울시 종로구 10강"));
        memberList.add(new MemberDTO("양", 300, '여', "서울시 종로구 15강"));
        memberList.add(new MemberDTO("뱀", 100, '남', "서울시 종로구 1강"));

        mv.addObject("memberList", memberList);

//        mv.setViewName("/lecture/conditional");     // user에게 보여줄 view 이름 설정
        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){
        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 7);
        mv.addObject(selectCriteria);

        mv.setViewName("/lecture/etc");
        return mv;
    }

    @GetMapping("fragment")
    public ModelAndView fragment(ModelAndView mv){
        mv.addObject("test1", "value1");
        mv.addObject("test2", "value2");

        mv.setViewName("/lecture/fragment");
        return mv;
    }
}
