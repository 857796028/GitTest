<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>datagrid的使用</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"></script>



</head>
	<body>
      <!--方式1: 将静态的HTML渲染为datagrid样式 -->
      <table class="easyui-datagrid">
         <thead>
            <tr>
               <th data-options="field:'id'">编号</th> <!-- th和td是一样的  但是默认有一个居中 的效果 -->
               <th data-options="field:'name'">姓名</th>
               <th data-options="field:'age'">年龄</th>
            </tr>  
         </thead>
         <tbody>
               <tr>
                 <td>001</td>
                 <td>小明</td>
                 <td>8</td>
               </tr>
               <tr>
                 <td>002</td>
                 <td>小李</td>
                 <td>9</td>
               </tr>
         </tbody>
      
      </table> 
       <!-- 方式2用ajax请求获取数据 -->
      
      <hr>
       <table data-options="url:'${pageContext.request.contextPath }/json/datagrid_data.json'" class="easyui-datagrid">
         <thead>
            <tr>
               <th data-options="field:'id'">编号</th> <!-- th和td是一样的  但是默认有一个居中 的效果 -->
               <th data-options="field:'name'">姓名</th>
               <th data-options="field:'age'">年龄</th>
            </tr>  
         </thead>
         <tbody>
               <tr>
                 <td>001</td>
                 <td>小明</td>
                 <td>8</td>
               </tr>
               <tr>
                 <td>002</td>
                 <td>小李</td>
                 <td>9</td>
               </tr>
         </tbody>
      
      </table>
      <hr>
      <!-- 方式3: 使用easyui提供的API动态的创建datagrid-->
       <table id="mytable">
       </table>
       <script type="text/javascript">
           $(function(){
        	  //页面加载完成后,创建数据表格
        	  $("#mytable").datagrid({
        		//定义标题行所有的字段
        		columns:[[
	        		          {title:'编号',field:'id',checkbox:true},//checkbox可以变成复选框
	        		          {title:'姓名',field:'name'},
	        		          {title:'年龄',field:'age'},
	        		          {title:'地址',field:'address'}
        		          ]],
        		   //指定数据表格发送的ajax请求的地址       
        		  url:'${pageContext.request.contextPath}/json/datagrid_data.json',
        		  rownumbers:true,//可以加行号
        		  singleSelect:true,//只能单选
        		  //定义工具栏[重点的属性]
        		  toolbar:[
        		           {text:'添加',iconCls:'icon-add',
        		        	//为按钮绑定单击事件
        		        	handler:function(){
        		        		alert("SS");
        		        		
        		        	}
        		           },
        		           {text:'删除',iconCls:'icon-remove'},
        		           {text:'修改',iconCls:'icon-edit'},
        		           {text:'查询',iconCls:'icon-search'}
        		           ],
        		   //显示分页条
        		   pagination:true
        	  });
        	   
           });
       </script>
      
	</body>

</html>