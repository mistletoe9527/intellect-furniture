/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.furniture.io
 *
 * 版权所有，侵权必究！
 */

package com.furniture.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.furniture.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
