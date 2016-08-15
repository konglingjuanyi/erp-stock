/**
 * 
 */
package com.jiji.erp.dal;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jiji.erp.stock.model.SerialNumberDO;
import com.jiji.erp.util.DateUtil;
import com.jiji.erp.util.NumberUtil;

/**
 * 序列号访问接口默认实现
 * @author		bin.yu 
 * @create		2016-08-10 17:40:45
 */
@Repository("serialNumberDAO")
public class SerialNumberDAOImpl extends BaseSerialNumberDAOImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(SerialNumberDAOImpl.class);
	
	@Override
	public String getSerialNumberByDate(String prefix, String appType)throws Exception {
		
		if (StringUtils.isBlank(prefix)) {
		       logger.error("prefix is empty");
		       throw new Exception("prefix is empty");
		     }
		     if (StringUtils.isBlank(appType)) {
		       logger.error("appType is empty");
		       throw new Exception("appType is empty");
		     }
		     logger.info("prefix:" + prefix + ";appType:" + appType);
		 
		     StringBuffer resultSerialNumber = new StringBuffer(prefix);
		 
		     Calendar calendar = Calendar.getInstance();
		 
		     Date nowDate = calendar.getTime();
		     String nowDateStr = DateUtil.date2Str(nowDate, "yyyyMMdd");
		     nowDate = DateUtil.str2Date(nowDateStr, "yyyyMMdd");
		     int number = 0;
		 
		     SerialNumberDO objParam=new SerialNumberDO();
		     objParam.setAppType(appType);
		     SerialNumberDO serialNumber = this.selectByEO(objParam);
		     if (serialNumber == null) {
		       logger.info("serialNumber is null");
		       number = 1;
		 
		       serialNumber = new SerialNumberDO();
		     
		       serialNumber.setAppType(appType);
		       serialNumber.setSerialDate(nowDate);
		       serialNumber.setNumber(Integer.valueOf(number));
		 
		       logger.info("insert a serialNumber");
		       this.insert(serialNumber);
		       logger.info("insert a serialNumber successd");
		     } else {
		       logger.info("serialNumber is exist");
		       if (nowDate.after(serialNumber.getSerialDate())) {
		         logger.info("nowDate is later than serialDate,so update nowDate to serialDate,and reset number");
		         serialNumber.setSerialDate(nowDate);
		         number = 1;
		       } else {
		         logger.info("nowDate is not later than serialDate,so number plus one");
		         number = serialNumber.getNumber().intValue() + 1;
		       }
		       serialNumber.setNumber(Integer.valueOf(number));
		 
		       logger.info("update a serialNumber");
		       this.update(serialNumber);
		       logger.info("update a serialNumber successd");
		     }
		 
		     resultSerialNumber.append(nowDateStr);
		     String numberStr = NumberUtil.formatNumber(number, 4);
		     resultSerialNumber.append(numberStr);
		     logger.info("resultSerialNumber:" + resultSerialNumber);
		     return resultSerialNumber.toString();
	}
   
	
	
}
