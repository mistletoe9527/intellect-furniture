package com.furniture.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : jia.wang
 * @date : 2020-10-19
 * @description :
 */
@Data
@TableName("tb_guest")
public class GuestEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;

    /**
     *
     */
    private String mobile;
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String buildingsName;
    /**
     *
     */
    private String deliveryAddress;
    /**
     *
     */
    private String flightNo;
    /**
     *
     */
    private String arriveAddress;
    /**
     *
     */
    private Date arriveTime;
    /**
     *
     */
    private Integer arriveNum;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date editTime;

    private String wechat;

}
