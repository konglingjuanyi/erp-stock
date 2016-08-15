package com.jiji.erp.stock.model;

import java.math.BigDecimal;
import java.util.Date;

import com.jiji.xmen.cable.commons.base.BaseObject;
/**
 * 仓库实体对象
 * @author		bin.yu
 * @create		2016-08-09 15:37:20
 */
public abstract class BaseWarehouseDO extends  BaseObject  implements java.io.Serializable {
 	
	private static final long serialVersionUID = 976083871651366280L;

	/**
	 * id
	 */
	protected Long id;

	/**
	 * 编号
	 */
	protected String code;

	/**
	 * 名称
	 */
	protected String name;

	/**
	 * 区域id
	 */
	protected Long areaId;

	/**
	 * 区域名称
	 */
	protected String areaName;

	/**
	 * 存货总值
	 */
	protected BigDecimal totalCostInventort;

	/**
	 * 排序
	 */
	protected Integer sort;

	/**
	 * 状态 1 草稿 2 审核 3删除
	 */
	protected String status;

	/**
	 * 创建者
	 */
	protected Long createBy;

	/**
	 * 创建日期
	 */
	protected Date createTime;

	/**
	 * 更新者
	 */
	protected Long updateBy;

	/**
	 * 更新日期
	 */
	protected Date updateTime;

	/**
	 * 备注
	 */
	protected String remark;

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
	 * 取得 编号
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置 编号
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 取得 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得 区域id
	 */
	public Long getAreaId() {
		return areaId;
	}

	/**
	 * 设置 区域id
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	/**
	 * 取得 区域名称
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置 区域名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 取得 存货总值
	 */
	public BigDecimal getTotalCostInventort() {
		return totalCostInventort;
	}

	/**
	 * 设置 存货总值
	 */
	public void setTotalCostInventort(BigDecimal totalCostInventort) {
		this.totalCostInventort = totalCostInventort;
	}

	/**
	 * 取得 排序
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置 排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 取得 状态 1 草稿 2 审核 3删除
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置 状态 1 草稿 2 审核 3删除
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 取得 创建者
	 */
	public Long getCreateBy() {
		return createBy;
	}

	/**
	 * 设置 创建者
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	/**
	 * 取得 创建日期
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置 创建日期
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 取得 更新者
	 */
	public Long getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置 更新者
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 取得 更新日期
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置 更新日期
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 取得 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}