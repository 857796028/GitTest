<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>combobox</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.ocupload-1.1.2.js"></script>
<script type="text/javascript">
$(function(){
	//页面加载完成后 加载方法  文件上传了  而且页面也没有刷新
	//页面加载完成后,调用插件的upload方法,动态的修改了HTML页面元素
	$("#mybutton").upload({
		action:'xxx.action',
		name:"myFile"
		
	});
	
});

</script>


</head>
	 <body>
	     <!-- 传统的下拉选 -->
        <!--   <select class="easyui-combobox">
             <option value="111">小黑</option>
             <option>小红</option>
             <option>小白</option>
          </select> -->
          <input data-options="url:'${pageContext.request.contextPath }/json/combobox_data.json',
          valueField:'id',
          textField:'name',
          editable:false"   
          class="easyui-combobox" >
          <!-- 返回的json里面必须有id和name的字段  id字段的值 value处的值,name是展示看到的是<>..<>中间的值-->
          
	</body>

</html>