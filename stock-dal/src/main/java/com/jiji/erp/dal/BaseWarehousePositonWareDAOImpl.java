/**
 * 
 */
package com.jiji.erp.dal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.jiji.erp.stock.model.WarehousePositonWareDO;
import com.jiji.xmen.cable.commons.mybatis.MybatisBaseDAOImpl;
import com.jiji.xmen.cable.commons.pagination.Page;

/**
 * 仓库位置商品访问接口抽象实现
 * @author		bin.yu
 * @create		2016-08-10 15:48:59
 */
public abstract class BaseWarehousePositonWareDAOImpl implements WarehousePositonWareDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="stockMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public Long insert(WarehousePositonWareDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseWarehousePositonWareDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseWarehousePositonWareDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<WarehousePositonWareDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseWarehousePositonWareDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseWarehousePositonWareDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(WarehousePositonWareDO eo) {
		int update = mybatisTemplete.update("BaseWarehousePositonWareDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(WarehousePositonWareDO oldObj, WarehousePositonWareDO newObj) {
        Map<String, WarehousePositonWareDO> paramMap = new HashMap<String, WarehousePositonWareDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseWarehousePositonWareDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<WarehousePositonWareDO> eoList) {
		mybatisTemplete.updateBatch("BaseWarehousePositonWareDAO.update", eoList);
	}

	@Override
	public int delete(WarehousePositonWareDO eo) {
		int delete = mybatisTemplete.delete("BaseWarehousePositonWareDAO.delete", eo);
		
		return delete;
	}

	@Override
	public WarehousePositonWareDO select(Long id) {
		return select(id,false);
	}
	
	@Override
	public WarehousePositonWareDO selectAndLock(Long id) {
		return select(id,true);
	}
	
	public WarehousePositonWareDO select(Long id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (WarehousePositonWareDO) mybatisTemplete.queryForObject("BaseWarehousePositonWareDAO.select", paramMap);
	}
	
	
	@Override
	public WarehousePositonWareDO selectByEO(WarehousePositonWareDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (WarehousePositonWareDO) mybatisTemplete.queryForObject("BaseWarehousePositonWareDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(WarehousePositonWareDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseWarehousePositonWareDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WarehousePositonWareDO> selectListByEO(WarehousePositonWareDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseWarehousePositonWareDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<WarehousePositonWareDO> selectListByIdList(List<Long> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseWarehousePositonWareDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WarehousePositonWareDO> selectListByEO(WarehousePositonWareDO eo,int pageNO,int pageSize) {
		Page<WarehousePositonWareDO> page = new Page<WarehousePositonWareDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<WarehousePositonWareDO> queryForPage(WarehousePositonWareDO eo, Page<WarehousePositonWareDO> page){
    	return mybatisTemplete.queryForPage("BaseWarehousePositonWareDAO.selectEOByEO", eo, page);
    }
}
