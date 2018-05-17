package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IStaffService;
import com.itheima.bos.utils.PageBean;
import com.itheima.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 取派员管理
 * @author Administrator
 *
 */

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
    @Autowired
	private IStaffService staffService;
    
    /**
     * 添加取派员的方法
     * 
     * 
     */
    public String add(){
    	staffService.save(model);
    	return LIST;  //在BaseAction添加常量
    }
    
    /**
     * 分页查询方法
     */ 
  
     public String pageQuery() throws IOException{  //currentPage 和rows 及Detached在action封装好 total和rows在dao来处理
    	// PageBean pageBean = new PageBean();
    	 //pageBean.setCurrentPage(page);
    	 //pageBean.setPageSize(rows);
    	 //创建离线条件查询对象
    	 
    	// pageBean.setDetachedCriteria(detachedCriteria);  //totoal 和rows 交给dao来处理
    	 
    	 staffService.pageQuery(pageBean);
    	 //将PageBean对象转为json 通过输出流写回页面
    	      //JSONObject ---将单一对象转为json
    	      //JSONArray ---将数组或者集合对象转为json
    	     // 指定哪些json不需要转
    	     /*JsonConfig jsonConfig = new JsonConfig();
    	     jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
    	     String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
    
    	    ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");//指定往回写的数据为json格式
    	    ServletActionContext.getResponse().getWriter().println(json);
    	    System.out.println("JSON的格式为:"+json);*/
    	 
    	 this.java2json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzooms"});
    	return NONE; //页面发送的是ajax请求,不需要返回数据  使用输出流往回写数据即可
     }
     
	
    
    
     //简单的测试方法
     public static void main(String[] args) {
		 
		  // pageBean.setCurrentPage(page);
		   //pageBean.setPageSize(rows);
		 //  String json = JSONObject.fromObject(pageBean).toString();
		  // System.out.println(json); //{"currentPage":2,"detachedCriteria":null,"pageSize":30,"rows":[],"total":0}
	}
     
     //属性驱动,接收页面提交的ids参数
    private String ids;
    /**
     * 取派员的批量删除 1.接收参数 2.返回LIST页面   跳到一个新的页面
     */
    public String deleteBatch(){
    	staffService.deleteBatch(ids);
    	
    	return LIST; //希望重新刷页面,则需要返回list
    }
    /**
     * 修改取派员信息
     */
    public String edit(){//页面提交的参数全部可以封装给model 
    	//staffService.update(model); 程序不会报错,但是逻辑会出错,因为model对象就是staff对象还有其它一些属性,没有初始化,会更新成null
    	//private String standard;  数据会出错,不能直接更新model
    	//private Set decidedzooms = new HashSet(0);
    	//应该1.首先查询数据库,根据id查询原始数据 2.再用现在的数据去覆盖 
      Staff staff =	staffService.findById(model.getId()); //此时的staff是原始数据
      
      //用页面提交的数据进行覆盖
      staff.setName(model.getName());
      staff.setTelephone(model.getTelephone());
      staff.setHaspda(model.getHaspda());
      staff.setStandard(model.getStandard());
      staff.setStation(model.getStation());
      staffService.update(staff);
    	
    	
    	return LIST;
    }
    
     /**
      * 查询所有未删除的取派员,返回json数据
      * 
      */
    public String listajax(){
    List<Staff> list =	staffService.findListNotDelete();
    	this.java2json(list,new String[]{"decidedzooms"});//排除哪些字段，得看页面只需要哪些字段，页面只需要id 和name  其它都是多余
    	return NONE;
    }





	public String getIds() {
		return ids;
	}




	public void setIds(String ids) {
		this.ids = ids;
	} 
  
	
	
}
