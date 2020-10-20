/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.furniture.io
 *
 * 版权所有，侵权必究！
 */

package com.furniture.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.furniture.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	

}
