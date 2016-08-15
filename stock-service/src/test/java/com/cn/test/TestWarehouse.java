package com.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiji.erp.dal.SerialNumberDAO;
import com.jiji.erp.stock.api.WarehouseService;
import com.jiji.erp.stock.model.WarehouseDO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(@ContextConfiguration({ "classpath*:applicationContext-service.xml" }))
public class TestWarehouse {

	@Autowired
	WarehouseService warehouseService;
    @Autowired
    SerialNumberDAO serialNumberDAO;
    
	@Test
	public void testInsert()throws Exception{
		 System.out.println("==test==");
		 for(int i=0;i<10;i++){
			 WarehouseDO warehouseDO=new WarehouseDO();
			 warehouseDO.setAreaId(1l);
			 warehouseDO.setAreaName("daf"+i);
			 warehouseDO.setCode(serialNumberDAO.getSerialNumberByDate("DH","warehouse"));
			 warehouseDO.setName("yubin");
		     warehouseService.insert(warehouseDO);
		 } 
	}
	 
}
