<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd(){
		//alert("增加...");
		$('#addStaffWindow').window("open");
	}
	
	function doView(){
		alert("查看...");
	}
	
	function doDelete(){
		//alert("删除...");
		//获取数据表格中所有选中的行  返回数组对象                       
	     var rows  =	$("#grid").datagrid("getSelections");
	     if(rows.length == 0){ //等于0 表示数组的长度为0 就是没有选中记录  弹出提示
		 $.messager.alert("提示信息","请选择需要删除的取派员","warning");
		   
	   }else{
		   //否则  选中了取派员  不管是几条 ,选中了就行
		   //弹出确认框
		   $.messager.confirm("删除确认","你确认要删除选中的取派员吗?",function(r){
			    if(r){
			    	var ids = "";
			    	var array = new Array();//js里面的数组对象
			    	//alert('确定删除.....');
			    	//确定删除 ,则需要发送请求  不管选中多少条,都应该只发送一次请求,在发送请求之前 要获取选中取派员的id
			    	//如何获取要删除的id  并拼成串
			    	
			    	 for(var i = 0 ; i<rows.length;i++){
			    		 var staff = rows[i];//json对象
			    	     var id = staff.id;  //如果是staff.name 则是获取的name
			    		// alert(id);
			    	    // ids+= id+",";
			    	    array.push(id);
			    	 }
			    	//alert(ids);
			    	//alert(array.join(","));//join的意思是把数组里面的对象都取出来,然后中间用逗号隔开,连成串儿对象,不用关心最后一个逗号
			        var ids = array.join(",");//1,2,3....中间用逗号隔开然后发送请求,提交请求.当发送完,希望页面刷新一次,发送一个同步的请求
			        location.href = "staffAction_deleteBatch.action?ids="+ids;
			       // $.post("staffAction_deleteBatch.action?ids="+ids);
			        
			    } else{
			    	
			    	
			   } 
			   
		  });
		   
	 }   
	}
	
	function doRestore(){
		alert("将取派员还原...");
	}
	//工具栏
	var toolbar = [ {
		id : 'button-view',	
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : '删除',
		iconCls : 'icon-cancel',
		handler : doDelete
	},{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [ [ {
		field : 'id',
		checkbox : true,
	},{
		field : 'name',
		title : '姓名',
		width : 120,
		align : 'center'
	}, {
		field : 'telephone',
		title : '手机号',
		width : 120,
		align : 'center'
	}, {
		field : 'haspda',
		title : '是否有PDA',
		width : 120,
		align : 'center' ,
		formatter : function(data,row, index){
			if(data=="1"){
				return "有";
			}else{
				return "无";
			}
		} 
	}, {
		field : 'deltag',
		title : '是否作废',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="0"){
				return "正常使用"
			}else{
				return "已删除";
			}
		} 
	}, {
		field : 'standard',
		title : '取派标准',
		width : 120,
		align : 'center'
	}, {
		field : 'station',
		title : '所谓单位',
		width : 200,
		align : 'center'
	} ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});
		
		// 取派员信息表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageList: [10,30,50,100],
			//pageList: [1],//强制指定每页显示条数为1 这样3条数据可以分3页
			pagination : true,
			toolbar : toolbar,
			//url : "json/staff.json",
			  url : "staffAction_pageQuery.action",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#addStaffWindow').window({
	        title: '添加取派员',
	        width: 400,
	        modal: true,  //遮罩效果
	        shadow: true, //阴影效果
	        closed: true,  //默认关闭状态
	        height: 400,  //高度
	        resizable:true  //窗口是否可以调整大小
	    });
		// 修改取派员窗口
		$('#editStaffWindow').window({
	        title: '修改取派员',
	        width: 400,
	        modal: true,  //遮罩效果
	        shadow: true, //阴影效果
	        closed: true,  //默认关闭状态
	        height: 400,  //高度
	        resizable:false  //窗口是否可以调整大小
	    });
		
	});
  //数据表格绑定的双击行事件对应的函数  在页面中找到添加的窗口 复制一份用来当作修改的窗口来使用
	function doDblClickRow(rowIndex, rowData){
		//alert("双击表格数据...");
		//打开 修改取派员窗口 打开之后 需要知道双击是哪一行  rowData是json对象
		$("#editStaffWindow").window("open");
		//alert(rowData.name);
		$("#editStaffWindow").form("load",rowData);
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="center" border="false">
    	<table id="grid"></table>
	</div>
	<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="addStaffForm" action="staffAction_add.action" method="post">  
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<!-- <tr>
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr> -->
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td>
						<!-- 校验电话输入规则 -->
						 <script type="text/javascript">
						    $(function(){
						    	//为保存按钮绑定事件
						    	$("#save").click(function(){
						    		//表单校验,如果校验通过,则提交表单
						    		var v = $("#addStaffForm").form("validate");
						    		if(v){
						    			//$("#addStaffForm").form("submit");//这样写也可以 模拟了ajax 提交表单之后不刷新
						    			//而现在希望表单提交之后,表单可以刷新 下面的方法更合适
						    			  $("#addStaffForm").submit();
						    			
						    		}
						    	});
						    	
						    	
						    	var reg = /^1[3|4|5|7|8][0-9]{9}$/; //电话的正则表达
						    	$.extend($.fn.validatebox.defaults.rules, { 
						    		telephone: { 
								    		validator: function(value,param){ 
								    		return reg.test(value);
								    		}, 
								    		message: '手机号输入有误' 
						    		} 
						    		}); 

						    });
						 </script>
						  <input type="text" name="telephone"  data-options="validType:'telephone'" class="easyui-validatebox" required="true"/>
						</td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>
	
	
	
	
	
	<!-- 修改取派员窗口  -->
		<div class="easyui-window" title="对收派员进行添加或者修改" id="editStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="edit" icon="icon-edit" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			  <form id="editStaffForm" action="staffAction_edit.action" method="post">  
			   <input type="hidden" name="id">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<!-- <tr>
						<td>取派员编号</td>
						<td><input type="text" name="id" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr> -->
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td>
						<!-- 校验电话输入规则 -->
						 <script type="text/javascript">
						    $(function(){
						    	//为保存按钮绑定事件
						    	$("#edit").click(function(){
						    		//表单校验,如果校验通过,则提交表单
						    		var v = $("#editStaffForm").form("validate");
						    		if(v){
						    			//$("#addStaffForm").form("submit");//这样写也可以 模拟了ajax 提交表单之后不刷新
						    			//而现在希望表单提交之后,表单可以刷新 下面的方法更合适
						    			  $("#editStaffForm").submit();
						    			
						    		}
						    	});
						    	
						    	
						    	var reg = /^1[3|4|5|7|8][0-9]{9}$/; //电话的正则表达
						    	$.extend($.fn.validatebox.defaults.rules, { 
						    		telephone: { 
								    		validator: function(value,param){ 
								    		return reg.test(value);
								    		}, 
								    		message: '手机号输入有误' 
						    		} 
						    		}); 

						    });
						 </script>
						  <input type="text" name="telephone"  data-options="validType:'telephone'" class="easyui-validatebox" required="true"/>
						</td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>  
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>
	
</body>
</html>	