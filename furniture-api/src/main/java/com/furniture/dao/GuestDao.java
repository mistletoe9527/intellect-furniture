package com.furniture.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.furniture.entity.GuestEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : jia.wang
 * @date : 2020-10-19
 * @description :
 */
@Mapper
public interface GuestDao extends BaseMapper<GuestEntity> {

}
