package com.itheima.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.web.action.base.BaseAction;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;

/**
 * 业务通知单管理
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
   //注入crm客户端代理对象
	@Autowired
	private ICustomerService customerService;
	/**
	 * 远程调用crm服务,根据手机号查询客户信息
	 */
	public String findCustomerByTelephone(){
		String telephone = model.getTelephone();
		Customer customer = customerService.findCustomerByTelephone(telephone);
		this.java2json(customer, new String[]{});//不管对象是不是空,都可以转json 
		return NONE;
	}
	/**
	 * 保存一个业务通知单,并尝试自动分单
	 */
	@Autowired
	private INoticebillService noticebillService;
	public String add(){
		noticebillService.save(model);
		return "noticebill_add";
	}
}
