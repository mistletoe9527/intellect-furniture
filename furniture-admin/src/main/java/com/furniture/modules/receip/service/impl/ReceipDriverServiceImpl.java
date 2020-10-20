package com.furniture.modules.receip.service.impl;

import com.furniture.common.utils.Constant;
import com.furniture.modules.job.entity.ScheduleJobEntity;
import com.furniture.modules.job.utils.ScheduleUtils;
import com.furniture.modules.receip.dao.ReceipDriverDao;
import com.furniture.modules.receip.entity.ReceipDriverEntity;
import com.furniture.modules.receip.service.ReceipDriverService;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.Query;
import org.springframework.transaction.annotation.Transactional;


@Service("receipDriverService")
public class ReceipDriverServiceImpl extends ServiceImpl<ReceipDriverDao, ReceipDriverEntity> implements ReceipDriverService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String param = (String)params.get("key");
        IPage<ReceipDriverEntity> page = this.page(
                new Query<ReceipDriverEntity>().getPage(params),
                new QueryWrapper<ReceipDriverEntity>()
                .like(StringUtils.isNotEmpty(param),"name",param).or()
                .like(StringUtils.isNotEmpty(param),"mobile",param).or()
                .like(StringUtils.isNotEmpty(param),"wechat",param)
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveReceipDriver(ReceipDriverEntity receipDriverEntity) {
        receipDriverEntity.setCreateTime(new Date());
        this.save(receipDriverEntity);
    }

}
