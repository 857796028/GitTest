package com.itheima.bos.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IRegionDao;
import com.itheima.bos.domain.Region;
import com.itheima.bos.service.IRegionService;
import com.itheima.bos.utils.PageBean;

@Service
@Transactional
public class RegionServiceImpl implements IRegionService {
	@Autowired
	private IRegionDao regionDao;

	/**
	 * 区域数据的批量保存
	 */
	public void saveBatch(List<Region> regionlist) {
	  for (Region region : regionlist) {
		regionDao.saveOrUpdate(region);
	  }
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
		
	}

	/**
	 * 查询所有区域
	 */
	@Override
	public List<Region> findAll() {
	
		return regionDao.findAll();
	}

	@Override
	public List<Region> findListByQ(String q) {
		
		return regionDao.findListByQ(q);
	}

}
