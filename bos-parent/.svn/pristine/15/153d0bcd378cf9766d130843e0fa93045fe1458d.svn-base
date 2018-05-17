package com.itheima.bos.web.interceptor;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.itheima.bos.domain.User;
import com.itheima.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义的拦截器 实现用户未登陆自动跳转到登陆页面的功能
 * @author Administrator
 *
 */
public class BOSLoginInterceptor extends MethodFilterInterceptor {
    //拦截方法
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//打印拦截的方法
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String url = namespace+actionName;
		System.out.println("拦截到的方法为:"+url);
		
		
		
		
		//从session中获取用户对象
		//User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser"); 下面是使用工具类
		User user = BOSUtils.getLoginUser();
		if(user == null){
			//没用登陆,跳转到登陆页面
			return "login"; //这个常量是action接口中的
			
			
		}//否则就放行
		return invocation.invoke();
	}

}
