/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.furniture.io
 *
 * 版权所有，侵权必究！
 */

package com.furniture.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.Query;
import com.furniture.modules.oss.dao.SysOssDao;
import com.furniture.modules.oss.entity.SysOssEntity;
import com.furniture.modules.oss.service.SysOssService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<SysOssEntity> page = this.page(
			new Query<SysOssEntity>().getPage(params)
		);

		return new PageUtils(page);
	}
	
}
