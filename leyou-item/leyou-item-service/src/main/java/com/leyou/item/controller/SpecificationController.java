package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ：wen_xm
 * @date ：Created in 2019/11/8 14:56
 * @description：规则参数controller
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    /**
     *@描述 查看当前分类下的规格组
     *@参数
     *@返回值
     *@创建人 wen_xm
     *@创建时间 15:20
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsByCid(@PathVariable(name = "cid") Long cid){
        List<SpecGroup> groups = specificationService.queryGroupsByCid(cid);
        if (CollectionUtils.isEmpty(groups)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }
    /**
     *@描述 查看当前规格组下的所有规则参数
     *@参数 group_id
     *@返回值
     *@创建人 wen_xm
     *@创建时间 15:20
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> getSpecParamByGroupId(@RequestParam("gid") Long gid){
        List<SpecParam> listParam = specificationService.getSpecParamByGroupId(gid);
        if (CollectionUtils.isEmpty(listParam)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(listParam);
    }
}
