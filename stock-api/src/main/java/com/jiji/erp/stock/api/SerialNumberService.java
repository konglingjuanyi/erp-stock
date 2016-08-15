package com.jiji.erp.stock.api;

public interface SerialNumberService {
	/**
	 * 
	 * <p>
	 * Description:生成编号=业务+日期+流水线<br />
	 * </p>
	 * @author zs
	 * @version 0.1 2016年8月10日
	 * @param prefix 
	 * @param appType
	 * @return
	 * String
	 */
	public String getSerialNumberByDate(String prefix, String appType);
}
