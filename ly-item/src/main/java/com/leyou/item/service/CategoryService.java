package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ChenXW
 * @Date:2024/4/16 16:01
 * @Description: 分类service
 **/
public interface CategoryService {

    public List<Category> findCategoriesByPid(Long pid);

}
