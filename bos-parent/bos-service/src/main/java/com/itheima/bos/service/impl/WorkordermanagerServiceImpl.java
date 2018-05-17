package com.itheima.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IWorkordermanagerDao;
import com.itheima.bos.domain.Workbill;
import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkordermanageService;
@Transactional
@Service
public class WorkordermanagerServiceImpl implements IWorkordermanageService{
   @Autowired
	private IWorkordermanagerDao workordermanagerDao;
	public void save(Workordermanage model) {
		workordermanagerDao.save(model);
		
		
	}

}
