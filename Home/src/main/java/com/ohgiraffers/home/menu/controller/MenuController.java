package com.ohgiraffers.home.menu.controller;

import com.ohgiraffers.home.menu.model.dto.CategoryDTO;
import com.ohgiraffers.home.menu.model.dto.MenuDTO;
import com.ohgiraffers.home.menu.model.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    private final MessageSource messageSource;
    private final MenuService menuService;

    public MenuController(MenuService menuService, MessageSource messageSource){
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("/list")
    public String findMenuList(Model model){
        List<MenuDTO> menuList = menuService.findMenuList();
        model.addAttribute("menuList", menuList);
        return "menu/list";
    }

    @GetMapping("/regist")
    public void registPage(){}

    @GetMapping("/category")
    public @ResponseBody List<CategoryDTO> findCategoryList(){
        return menuService.findCategoryList();
    }

    @PostMapping("/registForm")
    public String registMenu(@ModelAttribute MenuDTO menu, RedirectAttributes rttr, Locale locale){
        logger.trace("menu: {}", menu);
        logger.debug("menu: {}", menu);
        logger.info("menu: {}", menu);
        logger.warn("menu: {}", menu);
        logger.error("menu: {}", menu);

        menuService.registMenu(menu);
        rttr.addFlashAttribute("successMessage", "신규메뉴 등록 성공");
        return "redirect:/menu/list";
    }
}
