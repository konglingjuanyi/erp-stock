/**
 * 
 */
package com.jiji.erp.dal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.OptimisticLockingFailureException;

import com.jiji.erp.stock.model.SerialNumberDO;
import com.jiji.xmen.cable.commons.mybatis.MybatisBaseDAOImpl;
import com.jiji.xmen.cable.commons.pagination.Page;

/**
 * 序列号访问接口抽象实现
 * @author		bin.yu
 * @create		2016-08-10 17:40:45
 */
public abstract class BaseSerialNumberDAOImpl implements SerialNumberDAO {

	/**
	 * IBatis模板在spring配置文件中的beanId
	 */
	@Resource(name="stockMybatisTemplate")
	protected MybatisBaseDAOImpl mybatisTemplete;

	@Override
	public Long insert(SerialNumberDO eo) {
		if(eo.getId()!=null){
			mybatisTemplete.insert("BaseSerialNumberDAO.insertHasId", eo);
		}else{
			mybatisTemplete.insert("BaseSerialNumberDAO.insert", eo);
		}

        return eo.getId();
	}

	@Override
	public void batchInsert(List<SerialNumberDO> eoList, boolean generateKey) {
		if(generateKey){
			mybatisTemplete.insert("BaseSerialNumberDAO.batchInsert", eoList);
			
		}else{
			mybatisTemplete.insert("BaseSerialNumberDAO.batchInsertHasId", eoList);
			
		}
	}

	@Override
	public int update(SerialNumberDO eo) {
		int update = mybatisTemplete.update("BaseSerialNumberDAO.update", eo);
		
		if (update == 0) {
			throw new OptimisticLockingFailureException("更新纪录[" + eo + "]时发生乐观锁并发异常");
		}
		
		
		return update;
	}
	
	@Override
	public int updateByField(SerialNumberDO oldObj, SerialNumberDO newObj) {
        Map<String, SerialNumberDO> paramMap = new HashMap<String, SerialNumberDO>();
        paramMap.put("condition", oldObj);
        paramMap.put("template", newObj);

		return mybatisTemplete.update("BaseSerialNumberDAO.updateByField", paramMap);
	}
	
	@Override
	public void batchUpdate(List<SerialNumberDO> eoList) {
		mybatisTemplete.updateBatch("BaseSerialNumberDAO.update", eoList);
	}

	@Override
	public int delete(SerialNumberDO eo) {
		int delete = mybatisTemplete.delete("BaseSerialNumberDAO.delete", eo);
		
		return delete;
	}

	@Override
	public SerialNumberDO select(Long id) {
		return select(id,false);
	}
	
	@Override
	public SerialNumberDO selectAndLock(Long id) {
		return select(id,true);
	}
	
	public SerialNumberDO select(Long id, boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("isLock", isLock);
		return (SerialNumberDO) mybatisTemplete.queryForObject("BaseSerialNumberDAO.select", paramMap);
	}
	
	
	@Override
	public SerialNumberDO selectByEO(SerialNumberDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return (SerialNumberDO) mybatisTemplete.queryForObject("BaseSerialNumberDAO.selectEOByEO", paramMap);
	}
	
	@Override
	public int countByEO(SerialNumberDO eo) {
		Integer count = (Integer)mybatisTemplete.queryForObject("BaseSerialNumberDAO.countByEO", eo);
		return count!=null?count:0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SerialNumberDO> selectListByEO(SerialNumberDO eo) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("condition", eo);

		return mybatisTemplete.queryForList("BaseSerialNumberDAO.selectEOByEO", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<SerialNumberDO> selectListByIdList(List<Long> idList,boolean isLock) {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("idList", idList);
		paramMap.put("isLock", isLock);
		return mybatisTemplete.queryForList("BaseSerialNumberDAO.selectListByIdList", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SerialNumberDO> selectListByEO(SerialNumberDO eo,int pageNO,int pageSize) {
		Page<SerialNumberDO> page = new Page<SerialNumberDO>();
		page.setPageNo(pageNO);
		page.setPageSize(pageSize);
		
		page = queryForPage(eo, page);
		
		return page.getResult();
	}
	
    @Override
    public Page<SerialNumberDO> queryForPage(SerialNumberDO eo, Page<SerialNumberDO> page){
    	return mybatisTemplete.queryForPage("BaseSerialNumberDAO.selectEOByEO", eo, page);
    }
}
