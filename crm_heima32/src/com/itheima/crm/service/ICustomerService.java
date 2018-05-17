package com.itheima.crm.service;

import java.util.List;

import javax.jws.WebService;

import com.itheima.crm.domain.Customer;
@WebService
public interface ICustomerService {
	/**
	 * 查询所有用户的方法
	 * @return
	 */
    public List<Customer> findAll();
    //查询未关联到定区的客户
    public List<Customer> findListNotAssociation();
    //查询已经关联到指定定区的客户
    public List<Customer> findListHasAssociation(String decidedzoneId);
    //在t_customer中customer的id为int类型的 于是需要Integer[]数组去接收
    public void assigncustomerstodecidedzone(String decidedzoneId,Integer[] customerIds);
    //根据手机号查询已经存在的客户
    public Customer findCustomerByTelephone(String telephone);
    //根据客户的地址,查询定区的id
    public String findDecidedzoneByAddress(String address);
}
