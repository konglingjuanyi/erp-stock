/**
 * 
 */
package com.jiji.erp.dal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.OptimisticLockingFailureException;

import com.jiji.erp.stock.model.WarehouseDO;
import com.jiji.xmen.cable.commons.mybatis.MybatisBaseDAOImpl;
import com.jiji.xmen.cable.commons.pagination.Page;

/**
 * 仓库访问接口抽象实现
 * @author		bin.yu
 * @create		2016-08-09 15:37:20
 */
public abstract class BaseWarehouseDAOImpl implements WarehouseDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
 
	@Autowired @Qualifier("stockMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public Long insert(WarehouseDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseWarehouseDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseWarehouseDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<WarehouseDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseWarehouseDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseWarehouseDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(WarehouseDO eo) {
		int update = mybatisTemplete.update("BaseWarehouseDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(WarehouseDO oldObj, WarehouseDO newObj) {
        Map<String, WarehouseDO> paramMap = new HashMap<String, WarehouseDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseWarehouseDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<WarehouseDO> eoList) {
		mybatisTemplete.updateBatch("BaseWarehouseDAO.update", eoList);
	}

	@Override
	public int delete(WarehouseDO eo) {
		int delete = mybatisTemplete.delete("BaseWarehouseDAO.delete", eo);
		
		return delete;
	}

	@Override
	public WarehouseDO select(Long id) {
		return select(id,false);
	}
	
	@Override
	public WarehouseDO selectAndLock(Long id) {
		return select(id,true);
	}
	
	public WarehouseDO select(Long id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (WarehouseDO) mybatisTemplete.queryForObject("BaseWarehouseDAO.select", paramMap);
	}
	
	
	@Override
	public WarehouseDO selectByEO(WarehouseDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (WarehouseDO) mybatisTemplete.queryForObject("BaseWarehouseDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(WarehouseDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseWarehouseDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WarehouseDO> selectListByEO(WarehouseDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseWarehouseDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<WarehouseDO> selectListByIdList(List<Long> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseWarehouseDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WarehouseDO> selectListByEO(WarehouseDO eo,int pageNO,int pageSize) {
		Page<WarehouseDO> page = new Page<WarehouseDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<WarehouseDO> queryForPage(WarehouseDO eo, Page<WarehouseDO> page){
    	return mybatisTemplete.queryForPage("BaseWarehouseDAO.selectEOByEO", eo, page);
    }
}
