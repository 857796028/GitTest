package com.itheima.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.INoticebillDao;
import com.itheima.bos.dao.IWorkbillDao;
import com.itheima.bos.domain.Decidedzoom;
import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.domain.User;
import com.itheima.bos.domain.Workbill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.crm.ICustomerService;
@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {
    @Autowired
	private INoticebillDao noticebillDao;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IDecidedzoneDao decidedzoneDao;
    @Autowired
    private IWorkbillDao workbillDao;
    /**
     * 保存业务通知单, 还需要自动匹配一个取派员
     * 这里没有业务通知单的id  需要把Noticebill.hbm.xml中的主键策略改为uuid
     */
   
	public void save(Noticebill model) {
		//获取登陆用户
		User user = BOSUtils.getLoginUser();
		model.setUser(user);
		noticebillDao.save(model);
		
		//获取客户的取件地址 远程调用crm服务,根据取件地址查询定区id
        String pickaddress = model.getPickaddress();
        String decidedzone_Id = customerService.findDecidedzoneByAddress(pickaddress);
        if(decidedzone_Id != null){//查询到了定区id 可以完成自动分单
        	Decidedzoom decidedzone = decidedzoneDao.findById(decidedzone_Id);
        	Staff staff = decidedzone.getStaff();
        	model.setStaff(staff);  //业务能和单关联取派员对象
        	model.setOrdertype(Noticebill.ORDERTYPE_AUTO); //设置分单类型为自动分单
        	 //为取派员产生一个工单 workedbill
        	   Workbill workbill = new Workbill();                          
        	   workbill.setAttachbilltimes(0);//追单次数为0
        	   workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//date是年月日   这个可以精确到时分秒
        	   workbill.setNoticebill(model);//工单关联页面通知单
        	   workbill.setPickstate(workbill.PICKSTATE_NO);//设置取件状态为未取单
        	   workbill.setRemark(model.getRemark()); //设置备注信息
        	   workbill.setStaff(staff);//工单关联取派员
        	   workbill.setType(workbill.TYPE_1);  //设置工单类型
        	   workbillDao.save(workbill);
        	   
        	   //调用短信平台  发送短信
        	   
        	   
        	   
        }else{//不能自动分单
        	
        	model.setOrdertype(Noticebill.ORDERTYPE_MAN);
        	
        }
	}

}
