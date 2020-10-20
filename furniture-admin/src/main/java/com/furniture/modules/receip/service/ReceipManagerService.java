package com.furniture.modules.receip.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furniture.common.utils.PageUtils;
import com.furniture.modules.receip.entity.ReceipDriverEntity;
import com.furniture.modules.receip.entity.ReceipManagerEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuqing
 * @email sunlightcs@gmail.com
 * @date 2020-10-16 14:56:49
 */
public interface ReceipManagerService extends IService<ReceipManagerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveReceipManager(ReceipManagerEntity receipManagerEntity);

}

