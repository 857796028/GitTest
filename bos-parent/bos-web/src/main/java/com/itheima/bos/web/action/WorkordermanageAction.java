package com.itheima.bos.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Workbill;
import com.itheima.bos.domain.Workordermanage;
import com.itheima.bos.service.IWorkordermanageService;
import com.itheima.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class WorkordermanageAction extends BaseAction<Workordermanage>{

	
	@Autowired
    private IWorkordermanageService workordermanageService;

    public String add() throws Exception { 
    	String f = "1";
	   try {  //加入try  catch 是为了防止主键冲突  因为是手工录入
		workordermanageService.save(model);
	} catch (Exception e) {
		
		e.printStackTrace();
		f = "0";
	}
	ServletActionContext.getResponse().setContentType("text/html;charset = UTF-8");//这是普通的字符串 
	ServletActionContext.getResponse().getWriter().write(f);  //跑异常
	return NONE;
	
    }
	
	
}
