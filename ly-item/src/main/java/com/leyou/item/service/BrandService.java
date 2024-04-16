package com.leyou.item.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 品牌Service
 */
@Service
@Transactional
public interface BrandService {


    PageResult<Brand> brandPageQuery(Integer page, Integer rows, String key, String sortBy, Boolean desc);

    void saveBrand(Brand brand, List<Long> cids);

}
