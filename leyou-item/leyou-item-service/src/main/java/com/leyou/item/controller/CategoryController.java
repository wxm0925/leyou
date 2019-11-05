package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

/**
 * @author ：wen_xm
 * @date ：Created in 2019/11/5 10:25
 * @description：商品类别controller
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    
    /**
     *@描述 根据类别的父id查询子节点
     *@参数 
     *@返回值 
     *@创建人 wen_xm
     *@创建时间 10:26
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam( name = "pid",required = true,defaultValue = "0") Long pid){
        if(pid == null || pid < 0){
           return ResponseEntity.badRequest().build();
        }
        List<Category> categories = categoryService.queryCategoryByPId(pid);
        if (CollectionUtils.isEmpty(categories)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }
}
