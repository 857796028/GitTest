package com.itheima.crm.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.domain.Customer;
@Transactional
//@Service
public class CustomerService implements ICustomerService {
   private JdbcTemplate jdbcTemplate;
   
   
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}



	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		String sql = "SELECT * FROM t_customer";
	List<Customer> list =	jdbcTemplate.query(sql, new RowMapper<Customer>(){

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id  = rs.getInt("id");  //根据字段名称,从结果集中获取对应的值
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			  }
			
		});
		
		return list;
		  

     }



	@Override //查询未关联到定区的客户 哪些是未关联的
	//在t_customer表中,decidedzone_id的字段字为空,表示未关联
	//SQL SELECT * FROM t_customer WHERE decidedzone_id is null;
	public List<Customer> findListNotAssociation() {
		String sql = "SELECT * FROM t_customer WHERE decidedzone_id IS NULL";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>(){

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
			
			
		});
		
		
		return list;
	}


//查询已经关联到定区的客户
	@Override
	public List<Customer> findListHasAssociation(String decidedzoneId) {
		String sql = "SELECT * FROM t_customer WHERE decidedzone_id   =  ? ";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>(){

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
			
			
		},decidedzoneId);
		
		
		return list;
  }



	@Override//定区关联客户的方法
	public void assigncustomerstodecidedzone(String decidedzoneId, Integer[] customerIds) {
		String sql = "update t_customer set decidedzone_id = null where decidedzone_id = ?";
		this.jdbcTemplate.update(sql, decidedzoneId);// 第一个update 清理掉选中的id
		sql = "update t_customer set decidedzone_id = ? where id = ?";
		for (Integer id : customerIds) {
			jdbcTemplate.update(sql, decidedzoneId, id);
		}

	}


//根据电话查询客户Customer
	@Override
	public Customer findCustomerByTelephone(String telephone) {
		String  sql = "select * from  t_customer where  telephone =  ? ";
	List<Customer> list  =	    this.jdbcTemplate.query(sql, new RowMapper<Customer>(){ 
		    //此时传进去的参数是telephone  返回的只是一个客户
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				String telephone = rs.getString("telephone");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
			
			
		},telephone);
		//如果查询出来了 则返回list.size(0)返回第一个
	    //如果没有查出来 则返回null
		if(list != null && list.size()>0){
		return list.get(0);
		}
		return null;
	}


//根据地址查询定区的id 然后再由定区分配取派员
	@Override
	public String findDecidedzoneByAddress(String address) {
		String sql = "SELECT decidedzone_id FROM t_customer WHERE address =  ?  ";
        String decidedzone_id = this.jdbcTemplate.queryForObject(sql, String.class,address);
		return decidedzone_id;
	}
}