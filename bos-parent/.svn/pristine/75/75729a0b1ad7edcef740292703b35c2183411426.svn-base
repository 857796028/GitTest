<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>messager对象的使用</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<!--写纯js代码  -->
<script type="text/javascript">
   $(function(){  //页面加载函数
	     //alert方法 ---提示框
	     //alert(1111); window中的方法
         //$.messager.alert("标题","内容","warning"); //图标位置info error warning 是图标!
         //confirm方法--确认框
        /*  $.messager.confirm("提示信息","你确定要删除当前记录吗?",function(r){
        	 alert(r);
         }); */
         
         //show方法--欢迎框 例如登陆成功后左下角的欢迎提示
         $.messager.show({
        	    title:'欢迎消息',
        		msg:'欢迎[admin]登陆',
        		timeout:3000,
        		showType:'slide'
        	 
         });
   });
</script>

</head>

</html>