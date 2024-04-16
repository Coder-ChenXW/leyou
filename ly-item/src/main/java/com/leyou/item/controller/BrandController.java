package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 18:50
 * @Description:
 **/
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * @description: 分页查询品牌
     * @author: ChenXW
     * @date: 2024/4/16 20:30
     */
    @GetMapping("/brand/page")
    public ResponseEntity<PageResult<Brand>> brandPageQuery(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows,
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "sortBy",required = false) String sortBy,
            @RequestParam(value = "desc",required = false) Boolean desc
    ){
        PageResult<Brand> pageResult = brandService.brandPageQuery(page,rows,key,sortBy,desc);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * @description: 新增品牌
     * @author: ChenXW
     * @date: 2024/4/16 21:27
     */
    @PostMapping("/brand")
    public ResponseEntity<Void> saveBrand(
            Brand brand,
            @RequestParam("cids") List<Long> cids
    ){
        brandService.saveBrand(brand,cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
