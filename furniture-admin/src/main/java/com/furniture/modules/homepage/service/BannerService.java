package com.furniture.modules.homepage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.furniture.common.utils.PageUtils;
import com.furniture.modules.homepage.entity.BannerEntity;

import java.util.Map;

/**
 * 
 *
 * @author liuqing
 * @email sunlightcs@gmail.com
 * @date 2020-10-21 13:41:42
 */
public interface BannerService extends IService<BannerEntity> {

    PageUtils queryPage(Map<String, Object> params);

}

