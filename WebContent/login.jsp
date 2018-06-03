<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/strutsShoeShopServer/">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登陆</title>
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">	
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	
	
    <link rel="stylesheet" type="text/css" href="Styles/base.css" />
    <link rel="stylesheet" type="text/css" href="Styles/admin-all.css" />
    <script type="text/javascript" src="Scripts/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="Scripts/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="Styles/login.css" />
    <script type="text/javascript">
        $(function () {
            $('#clouds').pan({ fps: 20, speed: 3, dir: 'right', depth: 10 });
           
        })
    </script>
</head>

<body>
<div id="clouds" ></div>
<div style="width:400px;height:400px;position:absolute;z-index:199;top:150px;left:490px">
	
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="登陆" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff" method="post" action="UserAction!login.action">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="u.username" style="width:100%" data-options="label:'用户名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" name="u.password" style="width:100%" data-options="label:'密码:',required:true">
			</div>	
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="code"  maxlength="4" style="width:60%" data-options="label:'验证码:'">
				<img id="code" src="admin/CodeAction.action" style="width: 90px;height: 30px;position: relative;top: 11px;margin-left: 10px;" />
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清空</a>
		</div>
	</div>
	
</div>
<script>
		function alert1(title,message){
			$.messager.alert(title,message);
		}
		
		function errorMessage(title,message){
			$.messager.alert(title,message,'error');
		}
		
		function infoMessage(title,message){
			$.messager.alert(title,message,'info');
		}
		function questionMessage(title,message){
			$.messager.alert(title,message,'question');
		}
		function warningMessage(title,message){
			$.messager.alert(title,message,'warning');
		}
	</script>
	
	<script>
	//因为有验证码，点击登陆的js事件是：先判断ajax请求得到验证码是否正确，正确才提交表单数据
		function submitForm(){
		var mycode=$("[name='code']").val(); //先要获取到输入的code，传入后台，无法通过表单，因为验证验证码之前表单还没有提交
		    $.get("CodeAction!identifyCode.action?code="+mycode,function(data,statue){
		    	if(data=="wrong"){
		    		$('#dlg').html("<span style='color:red;font-weight:bold'>验证码错误！</span>");
					errorMessage('温馨提示','验证码错误！');
					$('#dlg').dialog('open');
		    	}else{
		    		$('#ff').submit();
		    	}
		    });		
		}
	
		function clearForm(){
			$('#ff').form('clear');
		}
		
		
		$(document).ready(function(){
			$('#dlg').dialog('close');//网页一打开让提示框消失			
			$("#autocode").click(function(){
				$(this).attr("src","CodeAction!excute.action?time="+new Date())
			})
			
		})
	</script>
	
	
	
	<c:if test="${requestScope.Message eq 'loginFail'}">
		 <script type="text/javascript">
		//当用户在后天验证登陆失败时存储一个字段，到这里判断
	        $.messager.alert('温馨提示','您的用户名或密码错误，请重新输入!','error');
	     </script>
	</c:if>
   
	
</body>
</html>
