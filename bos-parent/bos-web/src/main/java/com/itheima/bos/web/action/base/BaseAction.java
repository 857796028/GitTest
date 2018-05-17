package com.itheima.bos.web.action.base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.bos.domain.Region;
import com.itheima.bos.utils.CurrentTime;
import com.itheima.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 表现层通用实现
 * @author zhaoqx
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	public static final String HOME = "home";  //定义常量
	public static final String LIST = "list"; 
	
	protected PageBean  pageBean  = new PageBean();
	 DetachedCriteria detachedCriteria = null;
	 
	//protected int page; //首先接收页面传送过来的参数 page 和rows 进行封装  然后再封装查询条件
	//protected int rows;
	/**
	 * 将指定java转成json
	 * @param o
	 * @param excludes
	 */
	
	 public void java2json(Object o,String[] excludes){
		 JsonConfig jsonConfig = new JsonConfig();
	     jsonConfig.setExcludes(excludes);
	     String json = JSONObject.fromObject(o,jsonConfig).toString();

	    ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");//指定往回写的数据为json格式
	    try {
			ServletActionContext.getResponse().getWriter().println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    System.out.println("JSON的格式为:"+json);
		 
	 }
	 //重载java2json的方法 上面是将对象转为json 下面是将list转为json
	 public void java2json(List o,String[] excludes){
		 JsonConfig jsonConfig = new JsonConfig();
		 jsonConfig.setExcludes(excludes);
		 String json = JSONArray.fromObject(o,jsonConfig).toString();
		 
		 ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");//指定往回写的数据为json格式
		 try {
			 ServletActionContext.getResponse().getWriter().println(json);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 System.out.println("JSON的格式为:"+json);
		 
	 }
	 
	
	public void setPage(int page) {
		 pageBean.setCurrentPage(page);
		
	}

	public void setRows(int rows) {
		
		 pageBean.setPageSize(rows);
	}

	
	
	//模型对象 将private改为protected  子类可以使用了
	protected T model;
	public T getModel() {
		return model;
	}
	
	//在构造方法中动态获取实体类型，通过反射创建model对象
	public BaseAction() {
		System.out.println("运行时期的类为:"+this.getClass().getName());
		CurrentTime.getTime();
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得BaseAction上声明的泛型数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		detachedCriteria =	DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		
		//通过反射创建对象
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
