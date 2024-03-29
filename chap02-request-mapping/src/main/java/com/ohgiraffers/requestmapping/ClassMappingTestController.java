package com.ohgiraffers.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller                     // @Controller에서만 @RequestMapping 가능
@RequestMapping("/order/*") // Class 레벨 매핑을 하여 경로의 공통부분을 여기에 적어주면
public class ClassMappingTestController {

    @GetMapping("/regist")  // 여기에는 공통부분의 뒷 경로만 적어주면 된다.
    public String registOrder(Model model){
        model.addAttribute("message", "GET 방식의 주문 등록용 핸들러 메소드 호출");
        return "mappingResult";
    }

    @RequestMapping(value = {"modify", "delete"}, method = RequestMethod.POST)  // 여러개를 한번에 매핑
    public String modifyAndDelete(Model model){
        model.addAttribute("message", "POST 방식의 주문 수정, 삭제용 공통 핸들러 메소드 호출");
        return "mappingResult";
    }
    
    /* @PathVariable을 이용해 요청 path로부터 변수를 받아올수 있다.
    *  path variable로 전달되는 {변수명} 값은 반드시 매개변수명과 동일해야 한다.
    *  만약 동일하지 않다면 @PathVariable("이름")을 설정해주어야 한다. */
    @GetMapping("/detail/{orderNo}")
    public String selectOrderDetail(Model model, @PathVariable int orderNo){    // orderNo은 int형으로 지정해줬다.
        /* parsing 불가능한 @PathVariable이 전달되면 400번 에러 발생, @PathVariable이 없으면 404번 에러 발생 */
        model.addAttribute("message", "GET 방식의 " + orderNo + "번 주문 상세내용 조회용 핸들러 메소드 호출");
        return "mappingResult";
    }
    
    @RequestMapping
    public String otherRequest(Model model){
        model.addAttribute("message", "order 하위의 준비되지 않은 요청이 왔을 때 호출");
        return "mappingResult";
    }
}
