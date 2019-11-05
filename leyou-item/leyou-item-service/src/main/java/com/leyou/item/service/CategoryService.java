package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：wen_xm
 * @date ：Created in 2019/11/5 10:32
 * @description：
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryByPId(Long pid){
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categories = categoryMapper.select(category);
        return categories;
    }
}
