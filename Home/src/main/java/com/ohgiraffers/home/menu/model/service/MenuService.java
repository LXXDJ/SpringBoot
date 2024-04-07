package com.ohgiraffers.home.menu.model.service;

import com.ohgiraffers.home.menu.model.dao.MenuMapper;
import com.ohgiraffers.home.menu.model.dto.CategoryDTO;
import com.ohgiraffers.home.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {
    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper){this.menuMapper = menuMapper;}

    public List<MenuDTO> findMenuList(){
        return menuMapper.findMenuList();
    }

//    @Transactional(readOnly = true)
    public List<CategoryDTO> findCategoryList() {
        return menuMapper.findCategoryList();
    }

    @Transactional
    public void registMenu(MenuDTO menu) {
        menuMapper.registMenu(menu);
    }
}
