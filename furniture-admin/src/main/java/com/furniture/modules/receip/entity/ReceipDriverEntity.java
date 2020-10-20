package com.furniture.modules.receip.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2020-10-15 23:19:10
 */
@Data
@TableName("tb_receip_driver")
public class ReceipDriverEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String wechat;
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
	private Integer operateId;

	private String sex;

}
