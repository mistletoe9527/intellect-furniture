package com.furniture.modules.homepage.service.impl;

import com.furniture.common.annotation.DataFilter;
import com.furniture.common.utils.Constant;
import com.furniture.modules.sys.entity.SysDeptEntity;
import com.furniture.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furniture.common.utils.PageUtils;
import com.furniture.common.utils.Query;

import com.furniture.modules.homepage.dao.BannerDao;
import com.furniture.modules.homepage.entity.BannerEntity;
import com.furniture.modules.homepage.service.BannerService;


@Service("bannerService")
public class BannerServiceImpl extends ServiceImpl<BannerDao, BannerEntity> implements BannerService {

    @Override
    @DataFilter(subDept = true, user = false)
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BannerEntity> page = this.page(
                new Query<BannerEntity>().getPage(params,"sort",false),
                new QueryWrapper<BannerEntity>().eq("type",params.get("type")));
        return new PageUtils(page);
    }
}
