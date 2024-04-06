package com.ohgiraffers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
    @RequestMapping(value = {"/", "main"})
    public String defaultLocation(){return "main";}
}
