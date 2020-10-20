package com.furniture.form;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author : jia.wang
 * @date : 2020-10-19
 * @description :
 */
@Data
@ApiModel(value = "访客表单")
public class GuestForm {
    /**
     *
     */
    @ApiModelProperty(value = "手机号")
    @NotBlank(message="手机号不能为空")
    private String mobile;

    @ApiModelProperty(value = "微信号")
    @NotBlank(message="微信号不能为空")
    private String wechat;

    private String name;
    /**
     *
     */
    @ApiModelProperty(value = "楼盘名称")
    @NotBlank(message="楼盘名称不能为空")
    private String buildingsName;

    @ApiModelProperty(value = "送货地址")
    @NotBlank(message="送货地址不能为空")
    private String deliveryAddress;

    @ApiModelProperty(value = "航班号")
    @NotBlank(message="航班号不能为空")
    private String flightNo;

    @ApiModelProperty(value = "到达地址")
    @NotBlank(message="到达地址不能为空")
    private String arriveAddress;

    @ApiModelProperty(value = "到达时间")
    @NotBlank(message="到达时间不能为空")
    private Date arriveTime;

    @ApiModelProperty(value = "同行人数")
    @NotBlank(message="同行人数不能为空")
    private Integer arriveNum;


}
