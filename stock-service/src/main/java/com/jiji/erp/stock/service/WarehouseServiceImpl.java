package com.jiji.erp.stock.service;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiji.erp.dal.SerialNumberDAO;
import com.jiji.erp.dal.WarehouseDAO;
import com.jiji.erp.dal.WarehousePositionDAO;
import com.jiji.erp.stock.api.WarehouseService;
import com.jiji.erp.stock.model.WarehouseDO;
/**
 * 
 * <p>
 * Description:仓库表业务<br />
 * </p>
 * @title WarehouseServiceImpl.java
 * @package com.jiji.erp.stock 
 * @author zs
 * @version 0.1 2016年8月9日
 */
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {
	
	private static final Logger logger = LoggerFactory.getLogger(WarehouseServiceImpl.class);
	
	@Autowired
    WarehouseDAO warehouseDAO;
	
	@Autowired
	WarehousePositionDAO warehousePositionDAO;
    
	@Autowired
    SerialNumberDAO serialNumberDAO;
	
	public Long insert(WarehouseDO eo) {
		 
		return warehouseDAO.insert(eo);
	}

}
