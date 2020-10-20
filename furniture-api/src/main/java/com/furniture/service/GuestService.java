package com.furniture.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furniture.common.utils.PageUtils;
import com.furniture.entity.GuestEntity;
import com.furniture.form.GuestForm;

import java.util.Map;

/**
 * 
 *
 * @author liuqing
 * @email sunlightcs@gmail.com
 * @date 2020-10-19 13:39:18
 */
public interface GuestService extends IService<GuestEntity> {

    /**
     * 保存访客信息
     */
    void saveGuestInfo(GuestForm form);

    void updateGuestInfo(GuestForm form);

}

