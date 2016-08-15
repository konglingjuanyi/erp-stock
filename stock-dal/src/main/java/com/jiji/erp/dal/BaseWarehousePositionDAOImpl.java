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

import com.jiji.erp.stock.model.WarehousePositionDO;
import com.jiji.xmen.cable.commons.mybatis.MybatisBaseDAOImpl;
import com.jiji.xmen.cable.commons.pagination.Page;

/**
 * 仓库位置访问接口抽象实现
 * @author		bin.yu
 * @create		2016-08-10 15:48:59
 */
public abstract class BaseWarehousePositionDAOImpl implements WarehousePositionDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Autowired @Qualifier("stockMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public Long insert(WarehousePositionDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseWarehousePositionDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseWarehousePositionDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<WarehousePositionDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseWarehousePositionDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseWarehousePositionDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(WarehousePositionDO eo) {
		int update = mybatisTemplete.update("BaseWarehousePositionDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(WarehousePositionDO oldObj, WarehousePositionDO newObj) {
        Map<String, WarehousePositionDO> paramMap = new HashMap<String, WarehousePositionDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseWarehousePositionDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<WarehousePositionDO> eoList) {
		mybatisTemplete.updateBatch("BaseWarehousePositionDAO.update", eoList);
	}

	@Override
	public int delete(WarehousePositionDO eo) {
		int delete = mybatisTemplete.delete("BaseWarehousePositionDAO.delete", eo);
		
		return delete;
	}

	@Override
	public WarehousePositionDO select(Long id) {
		return select(id,false);
	}
	
	@Override
	public WarehousePositionDO selectAndLock(Long id) {
		return select(id,true);
	}
	
	public WarehousePositionDO select(Long id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (WarehousePositionDO) mybatisTemplete.queryForObject("BaseWarehousePositionDAO.select", paramMap);
	}
	
	
	@Override
	public WarehousePositionDO selectByEO(WarehousePositionDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (WarehousePositionDO) mybatisTemplete.queryForObject("BaseWarehousePositionDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(WarehousePositionDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseWarehousePositionDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WarehousePositionDO> selectListByEO(WarehousePositionDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseWarehousePositionDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<WarehousePositionDO> selectListByIdList(List<Long> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseWarehousePositionDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WarehousePositionDO> selectListByEO(WarehousePositionDO eo,int pageNO,int pageSize) {
		Page<WarehousePositionDO> page = new Page<WarehousePositionDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<WarehousePositionDO> queryForPage(WarehousePositionDO eo, Page<WarehousePositionDO> page){
    	return mybatisTemplete.queryForPage("BaseWarehousePositionDAO.selectEOByEO", eo, page);
    }
}
