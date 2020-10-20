package com.furniture.modules.receip.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furniture.common.utils.PageUtils;
import com.furniture.modules.job.entity.ScheduleJobEntity;
import com.furniture.modules.receip.entity.ReceipDriverEntity;

import java.util.Map;

/**
 * 
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-15 23:19:10
 */
public interface ReceipDriverService extends IService<ReceipDriverEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     *
     * @param receipDriverEntity
     */
    void saveReceipDriver(ReceipDriverEntity receipDriverEntity);
    }

