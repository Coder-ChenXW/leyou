package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 16:02
 * @Description: 分类控制器
 **/

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * @description: 商品分类查询
     * @author: ChenXW
     * @date: 2024/4/16 16:05
     */
    @GetMapping("/category/of/parent")
    public ResponseEntity<List<Category>> findCategoriesByPid(@RequestParam("pid") Long pid){
        List<Category> categories = categoryService.findCategoriesByPid(pid);
        return ResponseEntity.ok(categories);
    }
}
