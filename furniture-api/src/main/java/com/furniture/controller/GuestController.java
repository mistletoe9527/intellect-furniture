package com.furniture.controller;

import com.furniture.common.utils.R;
import com.furniture.common.validator.ValidatorUtils;
import com.furniture.entity.GuestEntity;
import com.furniture.form.GuestForm;
import com.furniture.form.LoginForm;
import com.furniture.service.GuestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : jia.wang
 * @date : 2020-10-19
 * @description :
 */
@RestController
@RequestMapping("/guest")
@Api(tags="访客接口")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping("add")
    @ApiOperation("添加访客信息")
    public R add(@RequestBody GuestForm form) {
        //表单校验
        ValidatorUtils.validateEntity(form);

        guestService.saveGuestInfo(form);
        //访客信息入库
        return R.ok();
    }

    /**
     * 修改访客信息
     */
    @PostMapping("update")
    @ApiOperation("修改访客信息")
    public R update(@RequestBody GuestForm form) {
        //表单校验
        ValidatorUtils.validateEntity(form);

        guestService.updateGuestInfo(form);
        return R.ok();
    }

}
