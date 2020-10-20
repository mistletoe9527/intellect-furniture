package com.furniture.modules.receip.controller;

import java.util.Arrays;
import java.util.Map;

import com.furniture.common.validator.ValidatorUtils;
import com.furniture.modules.receip.entity.ReceipDriverEntity;
import com.furniture.modules.receip.service.ReceipDriverService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.R;



/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-15 23:19:10
 */
@RestController
@RequestMapping("receip/receipdriver")
public class ReceipDriverController {
    @Autowired
    private ReceipDriverService receipDriverService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("receip:receipdriver:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = receipDriverService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("receip:receipdriver:info")
    public R info(@PathVariable("id") Long id){
        ReceipDriverEntity receipDriver = receipDriverService.getById(id);

        return R.ok().put("receipDriver", receipDriver);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("receip:receipdriver:save")
    public R save(@RequestBody ReceipDriverEntity receipDriver){
        receipDriverService.save(receipDriver);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("receip:receipdriver:update")
    public R update(@RequestBody ReceipDriverEntity receipDriver){
        ValidatorUtils.validateEntity(receipDriver);
        receipDriverService.updateById(receipDriver);
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("receip:receipdriver:delete")
    public R delete(@RequestBody Long[] ids){
        receipDriverService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
