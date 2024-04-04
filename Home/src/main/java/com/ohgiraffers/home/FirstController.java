package com.ohgiraffers.home;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
public class FirstController {

    @GetMapping("/regist")
    public void regist(){}

    @PostMapping("/registForm")
    public String registMenu(Model model, WebRequest request){
        String name = request.getParameter("menuName");
        int price = Integer.parseInt(request.getParameter("menuPrice"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "(을)를 신규메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";

        model.addAttribute("message", message);

        return "messagePrinter";
    }

    @GetMapping("/modify")
    public void modify(){}

    @PostMapping("/modifyForm")     // 파라미터 한개당 매개변수 한개로 받기
    public String modifyPrice(Model model, @RequestParam("modifyName") String menuName, @RequestParam(defaultValue = "0") int modifyPrice){
        String message = menuName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        model.addAttribute("message", message);
        return "messagePrinter";
    }

    @PostMapping("/modifyAll")      // 파라미터 여러개를 한개의 매개변수로 받기
    public String modifyAll(Model model, @RequestParam Map<String, String> param){
        String modifyMenu2 = param.get("modifyName2");
        int modifyPrice2 = Integer.parseInt(param.get("modifyPrice2"));

        String message = "메뉴 이름을 " + modifyMenu2 + "으로, 가격을 " + modifyPrice2 + "원으로 변경";
        model.addAttribute("message", message);
        return "messagePrinter";
    }

    @GetMapping("/search")
    public void search(){}

    // @ModelAttribute 는 DTO만 받을수 있는건가? 그냥 String, int 형식으로 받는건 안되나?
    @PostMapping("/searchForm")
    public String searchMenu(@ModelAttribute MenuDTO menuDTO){
        return "searchResult";
    }

    @GetMapping("login")
    public void login(){}

    @PostMapping("loginForm1")
    public String sessionTest1(HttpSession session, @RequestParam String id, @RequestParam String pw){
        session.setAttribute("id", id);
        session.setAttribute("pw", pw);
        return "loginResult";
    }

    @GetMapping("logout1")
    public String logoutTest1(HttpSession session){
        session.invalidate();
        return "loginResult";
    }
}
