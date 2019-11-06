package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.util.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ：wen_xm
 * @date ：Created in 2019/11/5 13:01
 * @description：
 */
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     *@描述 根据分页调节查询结果集
     *@参数
     *@返回值
     *@创建人 wen_xm
     *@创建时间 13:01
     */
    public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc){
        //初始化example对象
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        // 根据name模糊查询，或者根据首字母查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }

        // 添加分页条件  page:当前页 ， rows：每页大小
        PageHelper.startPage(page, rows);

        // 添加排序条件
        if(StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
        }
        List<Brand> brands = this.brandMapper.selectByExample(example);
        // 包装成pageInfo
        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        // 包装成分页结果集返回
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    public void saveBrand(Brand brand, List<Long> cids) {
        this.brandMapper.insert(brand);

        cids.forEach(cid -> {
            this.brandMapper.insertBrandAndCategory(cid,brand.getId());
        });
    }
}
