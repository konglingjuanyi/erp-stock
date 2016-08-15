package com.jiji.erp.stock.model;

import java.util.Date;

import com.jiji.xmen.cable.commons.base.BaseObject;
/**
 * 序列号实体对象
 * @author		bin.yu
 * @create		2016-08-10 17:40:45
 */
public abstract class BaseSerialNumberDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * id
	 */
	protected Long id;

	/**
	 * app类型
	 */
	protected String appType;

	/**
	 * 序列时间
	 */
	protected Date serialDate;

	/**
	 * 数量
	 */
	protected Integer number;

	/**
	 * 取得 id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 取得 app类型
	 */
	public String getAppType() {
		return appType;
	}

	/**
	 * 设置 app类型
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}

	/**
	 * 取得 序列时间
	 */
	public Date getSerialDate() {
		return serialDate;
	}

	/**
	 * 设置 序列时间
	 */
	public void setSerialDate(Date serialDate) {
		this.serialDate = serialDate;
	}

	/**
	 * 取得 数量
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * 设置 数量
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

}