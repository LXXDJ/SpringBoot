package com.ohgiraffers.home.menu.model.dao;

import com.ohgiraffers.home.menu.model.dto.CategoryDTO;
import com.ohgiraffers.home.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> findMenuList();

    List<CategoryDTO> findCategoryList();

    void registMenu(MenuDTO menu);
}
