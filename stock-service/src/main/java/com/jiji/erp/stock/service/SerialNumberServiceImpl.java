package com.jiji.erp.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiji.erp.dal.SerialNumberDAO;
import com.jiji.erp.dal.SerialNumberDAOImpl;
import com.jiji.erp.stock.api.SerialNumberService;

@Service("serialNumberService")
public class SerialNumberServiceImpl implements SerialNumberService{
	
	private static final Logger logger = LoggerFactory.getLogger(SerialNumberDAOImpl.class);
	@Autowired
	SerialNumberDAO serialNumberDAO;
	
	public String getSerialNumberByDate(String prefix, String appType)  {
		
		String code="";
		try {
			code = serialNumberDAO.getSerialNumberByDate(prefix, appType);
		} catch (Exception e) {
			logger.info("生成编号：",e);
		}
		return code;
	}
  
}
