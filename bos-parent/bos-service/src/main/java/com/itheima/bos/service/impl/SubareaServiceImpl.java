package com.itheima.bos.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.domain.Decidedzoom;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.ISubareaService;
import com.itheima.bos.utils.PageBean;


@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
    @Autowired
	private ISubareaDao subareaDao;
	
	@Override
	public void save(Subarea model) {
	    subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		// TODO Auto-generated method stub
		return subareaDao.findAll();
	}

	@Override
	public List<Subarea> findListNotAssociation() {
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件  哪些是未添加到定区的尼?从java对象考虑
		//分区对象里面  分区对象中decidedzone 的属性是null的 就是没有关联的
		//SQL select * from bc_subarea where decidedzoom_id is null;
		dc.add(Restrictions.isNull("decidedzoom")); 
		List<Subarea> list = subareaDao.findByCriteria(dc);
		return list;
	}
   /**
    * 根据定区id查询关联的分区
    */
	
	
	@Override
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件
		detachedCriteria.add(Restrictions.eq("decidedzoom.id", decidedzoneId));
		return  subareaDao.findByCriteria(detachedCriteria);
		
	}

}