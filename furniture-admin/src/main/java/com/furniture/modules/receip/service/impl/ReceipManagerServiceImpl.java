package com.furniture.modules.receip.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.Query;

import com.furniture.modules.receip.dao.ReceipManagerDao;
import com.furniture.modules.receip.entity.ReceipManagerEntity;
import com.furniture.modules.receip.service.ReceipManagerService;


@Service("receipManagerService")
public class ReceipManagerServiceImpl extends ServiceImpl<ReceipManagerDao, ReceipManagerEntity> implements ReceipManagerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String param = (String)params.get("key");

        IPage<ReceipManagerEntity> page = this.page(
                new Query<ReceipManagerEntity>().getPage(params),
                new QueryWrapper<ReceipManagerEntity>().like(StringUtils.isNotEmpty(param),"name",param).or()
                        .like(StringUtils.isNotEmpty(param),"mobile",param).or()
                        .like(StringUtils.isNotEmpty(param),"wechat",param)

        );

        return new PageUtils(page);
    }

    @Override
    public void saveReceipManager(ReceipManagerEntity receipManagerEntity) {
        receipManagerEntity.setCreateTime(new Date());
        this.save(receipManagerEntity);
    }


}
