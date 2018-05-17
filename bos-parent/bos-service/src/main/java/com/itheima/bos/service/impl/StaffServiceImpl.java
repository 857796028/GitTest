package com.itheima.bos.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IStaffDao;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	
	@Autowired
	private IStaffDao staffDao;
	@Override
	public void save(Staff model) {
		// TODO Auto-generated method stub
	staffDao.save(model);
		

	}
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
		
	}
	@Override
	/**
	 * 取派员的删除 逻辑删除
	 * 将deltag改为1
	 */
	public void deleteBatch(String ids) {
		// TODO Auto-generated method stub  //ids ={1,2,3};
		String[] staffIds = ids.split(",");
		if(StringUtils.isNotBlank(ids)){
			for(String id :staffIds){
				staffDao.executeUpdate("staff.delete", id);
				
			}
			
		}
	}
	/**
	 * 根据id查询staff信息
	 */
	@Override
	public Staff findById(String id) {
	  Staff staff = staffDao.findById(id);
		return staff;
	}
	/**
	 * 根据id修改取派员
	 */
	@Override
	public void update(Staff staff) {
		// TODO Auto-generated method stub
		staffDao.update(staff);
	}
	@Override
	public List<Staff> findListNotDelete() {
		//封装查询条件 ,未删除的标致为deltag = 0 
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		dc.add(Restrictions.eq("deltag", "0"));
		//dc.add(Restrictions.ne("deltag", "1"));//或者 过滤条件为deltag != 1 这两个条件是等价的
		List<Staff> list = staffDao.findByCriteria(dc);
		return list;
	}

}
