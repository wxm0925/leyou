package com.leyou.item.service;

import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.mapper.SpecifucationMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：wen_xm
 * @date ：Created in 2019/11/8 15:24
 * @description：
 */
@Service
public class SpecificationService {
    @Autowired
    SpecParamMapper specParamMapper;
    public List<SpecParam> getSpecParamByGroupId(Long gid){
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        return specParamMapper.select(specParam);
    }

    @Autowired
    private SpecifucationMapper specifucationMapper;

    public List<SpecGroup> queryGroupsByCid(Long cid){
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return specifucationMapper.select(specGroup);
    }
}
