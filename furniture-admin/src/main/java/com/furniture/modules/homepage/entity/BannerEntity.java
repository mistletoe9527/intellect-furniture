package com.furniture.modules.homepage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author liuqing
 * @email sunlightcs@gmail.com
 * @date 2020-10-21 13:41:42
 */
@Data
@TableName("tb_banner")
public class BannerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String picUrl;
	/**
	 * 
	 */
	private String bannerName;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Date editTime;
	/**
	 * 
	 */
	private Integer isDelete;

	/**
	 * 权重
	 */
	private Integer sort;

	/**
	 * 图片类型 1- banner 2-介绍图
	 */
	private Integer type;


}
