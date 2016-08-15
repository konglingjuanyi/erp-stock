/**
 * 
 */
package com.jiji.erp.dal;

import com.jiji.erp.stock.model.SerialNumberDO;
import com.jiji.xmen.cable.commons.base.BaseDAO2;

/**
 * 序列号访问接口
 * @author		bin.yu
 * @create		2016-08-10 17:40:45
 */
public interface SerialNumberDAO extends BaseDAO2<SerialNumberDO, Long> {
    /**
     * 
     * <p>
     * Description:生成编号<br />
     * </p>
     * @author zs
     * @version 0.1 2016年8月10日
     * @param prefix
     * @param appType
     * @return
     * String
     */
	public String getSerialNumberByDate(String prefix, String appType) throws Exception;
}
