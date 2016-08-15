package com.jiji.erp.stock.model;

import java.util.Date;

import com.jiji.xmen.cable.commons.base.BaseObject;
/**
 * 仓库位置实体对象
 * @author		bin.yu
 * @create		2016-08-10 15:48:59
 */
public abstract class BaseWarehousePositionDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * id
	 */
	protected Long id;

	/**
	 * 编号
	 */
	protected String code;

	/**
	 * name
	 */
	protected String name;

	/**
	 * 仓库id
	 */
	protected Long warehouseId;

	/**
	 * 仓库名称
	 */
	protected String warehouseName;

	/**
	 * 位
	 */
	protected Integer place;

	/**
	 * 层
	 */
	protected Integer floor;

	/**
	 * 架
	 */
	protected Integer frame;

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
	 * 取得 name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取得 仓库id
	 */
	public Long getWarehouseId() {
		return warehouseId;
	}

	/**
	 * 设置 仓库id
	 */
	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	/**
	 * 取得 仓库名称
	 */
	public String getWarehouseName() {
		return warehouseName;
	}

	/**
	 * 设置 仓库名称
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	/**
	 * 取得 位
	 */
	public Integer getPlace() {
		return place;
	}

	/**
	 * 设置 位
	 */
	public void setPlace(Integer place) {
		this.place = place;
	}

	/**
	 * 取得 层
	 */
	public Integer getFloor() {
		return floor;
	}

	/**
	 * 设置 层
	 */
	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	/**
	 * 取得 架
	 */
	public Integer getFrame() {
		return frame;
	}

	/**
	 * 设置 架
	 */
	public void setFrame(Integer frame) {
		this.frame = frame;
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