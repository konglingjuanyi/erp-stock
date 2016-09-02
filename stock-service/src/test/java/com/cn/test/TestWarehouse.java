package com.cn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiji.erp.dal.SerialNumberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(@ContextConfiguration({ "classpath*:applicationContext-service.xml" }))
public class TestWarehouse {
    @Autowired
    SerialNumberDAO serialNumberDAO;
    
	@Test
	public void testInsert()throws Exception{
		
		 System.out.println("==test=="+serialNumberDAO.getSerialNumberByDate("DH","warehouse"));
		 
	}
	 
}
