package com.furniture.modules.receip.controller;

import java.util.Arrays;
import java.util.Map;

import com.furniture.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.modules.receip.entity.ReceipManagerEntity;
import com.furniture.modules.receip.service.ReceipManagerService;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.R;



/**
 * 
 *
 * @author liuqing
 * @email sunlightcs@gmail.com
 * @date 2020-10-16 14:56:49
 */
@RestController
@RequestMapping("receip/receipmanager")
public class ReceipManagerController {
    @Autowired
    private ReceipManagerService receipManagerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("receip:receipmanager:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = receipManagerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("receip:receipmanager:info")
    public R info(@PathVariable("id") Long id){
        ReceipManagerEntity receipManager = receipManagerService.getById(id);

        return R.ok().put("receipManager", receipManager);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("receip:receipmanager:save")
    public R save(@RequestBody ReceipManagerEntity receipManager){
        receipManagerService.saveReceipManager(receipManager);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("receip:receipmanager:update")
    public R update(@RequestBody ReceipManagerEntity receipManager){
        ValidatorUtils.validateEntity(receipManager);
        receipManagerService.updateById(receipManager);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("receip:receipmanager:delete")
    public R delete(@RequestBody Long[] ids){
        receipManagerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
