package com.furniture.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.furniture.dao.GuestDao;
import com.furniture.entity.GuestEntity;
import com.furniture.form.GuestForm;
import com.furniture.service.GuestService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.furniture.common.utils.PageUtils;


@Service("guestService")
public class GuestServiceImpl extends ServiceImpl<GuestDao, GuestEntity> implements GuestService {


    /**
     * 保存访客信息
     *
     * @param form
     */
    @Override
    public void saveGuestInfo(GuestForm form) {
        GuestEntity entity = new GuestEntity();
        transferGuestForm(entity,form);
        save(entity);
    }

    @Override
    public void updateGuestInfo(GuestForm form) {
        GuestEntity entity = new GuestEntity();
        transferGuestForm(entity,form);
        updateById(entity);
    }


    public void transferGuestForm(GuestEntity entity,GuestForm form){
        entity.setMobile(form.getMobile());
        entity.setName(form.getName());
        entity.setArriveAddress(form.getArriveAddress());
        entity.setArriveNum(form.getArriveNum());
        entity.setBuildingsName(form.getBuildingsName());
        entity.setFlightNo(form.getFlightNo());
        entity.setDeliveryAddress(form.getDeliveryAddress());
        entity.setArriveTime(form.getArriveTime());
        entity.setWechat(form.getWechat());
    }
}
