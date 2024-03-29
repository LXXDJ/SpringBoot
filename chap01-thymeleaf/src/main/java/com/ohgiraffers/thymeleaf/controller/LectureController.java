package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("lecture")  // 여기에 상위 폴더를 적어줌으로써
public class LectureController {

//    @GetMapping("/lecture/expression")
    @GetMapping("/expression")  // 이렇게 하위 폴더만 작성해도 됨
    public ModelAndView expression(ModelAndView mv){
        mv.addObject("member", new MemberDTO("판다", 20, '여', "서울시 종로구"));
        mv.addObject("hello", "<h3>hello Thymeleaf</h3>");

//        mv.setViewName("resources/templates/lecture/expression.html");
        mv.setViewName("/lecture/expression");  // 위 경로를 이렇게 적음
        return mv;
    }

    @GetMapping("/conditional")
    public ModelAndView conditional(ModelAndView mv){
        mv.addObject("num", 328);
        mv.addObject("str", "바나나");

        mv.setViewName("/lecture/conditional");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("판다", 20, '여', "서울시 종로구 8강"));
        memberList.add(new MemberDTO("다람쥐", 900, '무', "서울시 종로구 10강"));
        memberList.add(new MemberDTO("양", 300, '여', "서울시 종로구 15강"));
        memberList.add(new MemberDTO("뱀", 100, '남', "서울시 종로구 1강"));

        mv.addObject("memberList", memberList);

        return mv;
    }

    @GetMapping("etc")
    public ModelAndView etc(ModelAndView mv){
        SelectCriteria selectCriteria = new SelectCriteria(1, 10, 7);
        mv.addObject(selectCriteria);       // 키와 값을 따로 입력해주지 않고 이렇게만 입력해주어도 ("selectCriteria",selectCriteria)이렇게 입력한 것처럼 된다.

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
