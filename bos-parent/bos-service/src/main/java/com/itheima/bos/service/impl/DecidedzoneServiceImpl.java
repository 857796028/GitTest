package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.ISubareaDao;
import com.itheima.bos.domain.Decidedzoom;
import com.itheima.bos.domain.Subarea;
import com.itheima.bos.service.IDecidedzoneService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional  //事物注解,可以放在接口上,方法上  实现类上,都可以
public class DecidedzoneServiceImpl implements IDecidedzoneService {
     
	@Autowired
	private IDecidedzoneDao decidedDao; //定区的dao
	@Autowired 
	private ISubareaDao subareaDao;      //分区的dao
	@Override
	/**
	 * 添加定区对象的同时,同时关联分区
	 * 定区(一) <--->分区(多)定区和分区的关系是一对多的关系
	 */
	public void save(Decidedzoom model, String[] subareaid) {
		decidedDao.save(model);  
        for (String id : subareaid) {//根据id查分区,然后用分区关联定区
			Subarea subareas = subareaDao.findById(id);//查出来是分区对象
			//model.getSubareas().add(subareas);  //这里是让定区关联分区  一方 也就是1方 已经放弃维护外键了
			subareas.setDecidedzoom(model);
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		decidedDao.pageQuery(pageBean);
		
	}

}
