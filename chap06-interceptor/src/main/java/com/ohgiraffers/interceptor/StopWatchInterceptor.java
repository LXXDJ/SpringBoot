package com.ohgiraffers.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class StopWatchInterceptor implements HandlerInterceptor {

    private final MenuService menuService;

    // @Autowired 생략
    public StopWatchInterceptor(MenuService menuService){
        this.menuService = menuService;
    }

    /* 전처리 메소드 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler 호출");

        Long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        /* true를 반환하면 컨트롤러 메소드가 호출되고, false를 반환하면 호출 안됨 */
        return true;
    }

    /* 후처리 메소드 */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler 호출함");

        long startTime = request.getDateHeader("startTime");
        long endTime = System.currentTimeMillis();
        modelAndView.addObject("interval", endTime - startTime);
    }

    /* view가 모두 렌더링 된 후에 동작하는 메소드 */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion 호출");
        menuService.method();
    }
}
