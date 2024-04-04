package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResolverController {
    @GetMapping("string")
    public String stringReturning(Model model){
        model.addAttribute("forwardMessage", "문자열로 뷰이름 반환");
        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect(){
        return "redirect:/main";
    }

    @GetMapping("string-redirect-attr")
    public String flashAttribute(RedirectAttributes rttr){
        rttr.addFlashAttribute("flashMessage", "리다이렉트 attr 사용하여 redirect");
        return "redirect:/";
    }

    @GetMapping("modelandview")
    public ModelAndView modelandview(ModelAndView mv){
        mv.addObject("forwardMessage", "ModelAndView를 이용한 모델과 뷰 반환");
        mv.setViewName("result");
        return mv;
    }
}
