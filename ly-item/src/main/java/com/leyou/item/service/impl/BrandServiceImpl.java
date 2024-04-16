package com.leyou.item.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leyou.common.exception.pojo.ExceptionEnum;
import com.leyou.common.exception.pojo.LyException;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 18:50
 * @Description:
 **/
@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> brandPageQuery(Integer page, Integer rows, String key, String sortBy, Boolean desc) {
        IPage<Brand> iPage = new Page<>(page,rows);

        QueryWrapper<Brand> queryWrapper = Wrappers.query(); //待会自己往QueryWrapper存入条件

        //处理key
        if(StringUtils.isNotEmpty(key)){
            queryWrapper
                    .like("name",key)
                    .or()
                    .eq("letter",key.toUpperCase());
        }

        //处理排序
        if (StringUtils.isNotEmpty(sortBy)) {
            if(desc){
                queryWrapper.orderByDesc(sortBy);
            }else{
                queryWrapper.orderByAsc(sortBy);
            }
        }


        iPage = brandMapper.selectPage(iPage,queryWrapper);

        PageResult<Brand> pageResult = new PageResult<>(iPage.getTotal(),iPage.getPages(),iPage.getRecords());

        return pageResult;
    }

    @Override
    public void saveBrand(Brand brand, List<Long> cids) {
        try {
            brandMapper.insert(brand);

            brandMapper.saveCategoryAndBrand(brand.getId(),cids);
        } catch (Exception e) {
            e.printStackTrace();
            throw new LyException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }
}
