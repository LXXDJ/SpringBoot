package com.ohgiraffers.handlermethod;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/first/*")
@SessionAttributes({"id", "pwd"})
public class FirstController {

    /* 반환값을 void로 설정하면 요청주소 view(=html)의 이름이 된다. */
    @GetMapping("/regist")  // 경로앞에 슬래쉬(/)를 붙여도, 안붙여도 상관없음
    public void regist(){}

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request){
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = name + "을(를) 신규메뉴 목록의 " + categoryCode + "번 카테고리에 " + price + "원으로 등록하였습니다.";

        model.addAttribute("message", message);

        return "first/messagePrinter";
    }

    @GetMapping("modify")
    public void modify(){}

    /* @RequestParam으로 요청 전달받기
    *  요청 파라미터를 매핑하여 호출 시 값을 넣어주는 어노테이션으로 매개변수 앞에 작성
    *  form의 name 속성값과 매개변수의 이름이 다른 경우 @RequestParam("name")을 설정하면 된다. */
    @PostMapping("modify")
//    public String modifyMenu(Model model, @RequestParam String modifyName, @RequestParam int modifyPrice){
//    public String modifyMenu(Model model, String modifyName, int modifyPrice){  // @RequestParam 생략가능 하지만, 명시적으로 적어줄 것을 권고
    public String modifyMenuPrice(Model model, @RequestParam String modifyName, @RequestParam(defaultValue = "0") int modifyPrice){  //(defaultValue = "0")으로 미입력시 기본값 설정 가능
        String message = modifyName + " 메뉴의 가격을 " + modifyPrice + "원으로 변경하였습니다.";
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    /* 파라미터가 여러개인 경우, Map으로 한번에 처리 가능 (이때, Map의 키는 form의 name 속성값) */
    @PostMapping("modifyAll")
    public String modifyMenu(Model model, @RequestParam Map<String, String> parameters){
        String modifyMenu = parameters.get("modifyName2");
        int modifyPrice= Integer.parseInt(parameters.get("modifyPrice2"));

        String message = "메뉴의 이름을 " + modifyMenu + "으로 , 가격을 " + modifyPrice + "원으로 변경";
        model.addAttribute("message", message);
        return "first/messagePrinter";
    }

    @GetMapping("search")
    public void search(){}

    /* @ModelAttribute 이용하는 방법
    *  DTO 같은 모델을 커맨드 객체를 생성하여 매개변수로 전달해준 뒤, 해당 인스턴스를 model에 담는다.
    *  경우에 따라 폼에서 입력한 값을 다음 화면으로 바로 전달해야 하는 경우 유용하게 사용 가능
    *
    *  @ModelAttribute("모델에 담을 key값") 지정 가능, 미지정시 타입의 앞글자를 소문자로 한 네이밍 규칙을 따른다. */
    @PostMapping("search")
    public String searchMenu(@ModelAttribute MenuDTO menuDTO){
        return "first/searchResult";
    }

    @GetMapping("login")
    public void login(){}

    /* HttpSession을 매개변수로 선언하면 핸들러 메소드 호출 시, 세션 객체를 넣어서 호출 */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id){
        session.setAttribute("id", id);

        return "first/loginResult";
    }

    @PostMapping("login2")
    public String sessionTest2(Model model, @RequestParam String id, @RequestParam String pwd){
        model.addAttribute("id", id);
        model.addAttribute("pwd", pwd);

        return "first/loginResult";
    }

    @GetMapping("logout1")  // 로그아웃1 버튼이 작동되게 하려면 클래스 위에 @SessionAttributes("id") 이 부분 주석처리 해줘야함
    public String logoutTest1(HttpSession session){
        session.invalidate();

        return "first/loginResult";
    }

    /* SessionAttributes로 등록된 값은 session의 상태를 관리하는 SessionStatus의 setComplete() 메소드를 호출해야 사용 만료됨 */
    @GetMapping("logout2")
    public String logoutTest2(SessionStatus sessionStatus){
        sessionStatus.setComplete();

        return "first/loginResult";
    }
}
