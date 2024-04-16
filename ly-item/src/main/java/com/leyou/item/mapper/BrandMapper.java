package com.leyou.item.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper extends BaseMapper<Brand> {
    void saveCategoryAndBrand(@Param("bid") Long id, @Param("cids") List<Long> cids);
}