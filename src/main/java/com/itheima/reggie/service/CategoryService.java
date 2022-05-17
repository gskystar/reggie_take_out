package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Category;

/**
 * @author agong
 * @date 2022/5/17 9:39
 */
public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
