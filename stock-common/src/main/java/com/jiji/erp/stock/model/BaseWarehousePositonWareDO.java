package com.jiji.erp.stock.model;

import java.math.BigDecimal;
import java.util.Date;

import com.jiji.xmen.cable.commons.base.BaseObject;
/**
 * 仓库位置商品实体对象
 * @author		bin.yu
 * @create		2016-08-10 15:48:59
 */
public abstract class BaseWarehousePositonWareDO extends  BaseObject  implements java.io.Serializable {
	/**
	 * id
	 */
	protected Long id;

	/**
	 * 仓库位置id
	 */
	protected Long warehousePositionId;

	/**
	 * 仓库位置名称
	 */
	protected String warehousePositionName;

	/**
	 * 商品id
	 */
	protected Integer productId;

	/**
	 * 商品名称
	 */
	protected String productName;

	/**
	 * 商品数量
	 */
	protected Integer productCount;

	/**
	 * 仓库id
	 */
	protected Long warehouseId;

	/**
	 * 仓库名称
	 */
	protected String warehouseName;

	/**
	 * 排序
	 */
	protected Integer sort;

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
	 * 取得 仓库位置id
	 */
	public Long getWarehousePositionId() {
		return warehousePositionId;
	}

	/**
	 * 设置 仓库位置id
	 */
	public void setWarehousePositionId(Long warehousePositionId) {
		this.warehousePositionId = warehousePositionId;
	}

	/**
	 * 取得 仓库位置名称
	 */
	public String getWarehousePositionName() {
		return warehousePositionName;
	}

	/**
	 * 设置 仓库位置名称
	 */
	public void setWarehousePositionName(String warehousePositionName) {
		this.warehousePositionName = warehousePositionName;
	}

	/**
	 * 取得 商品id
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * 设置 商品id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * 取得 商品名称
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置 商品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 取得 商品数量
	 */
	public Integer getProductCount() {
		return productCount;
	}

	/**
	 * 设置 商品数量
	 */
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
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

}