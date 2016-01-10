<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>"></base>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="content/index/css/bootstrap.min.css" rel="stylesheet">
<link href="content/index/css/datepicker3.css" rel="stylesheet">
<link href="content/index/css/styles.css" rel="stylesheet">
<title></title>
</head>
<body>

<table>
  <tr>
    <th>资产编号</th>
    <td><input type="text" id="number" value="${map.msg.number }"></td>
  </tr>
  <tr>
    <th>资产名称：</th>
    <td><input type="text" id="name" value="${map.msg.name }"></td>
  </tr>
  <tr>
    <th>资产类别：</th>
    <td><select id="category" name="">
			<c:forEach var="item" items="${category}">
			<option value="${item.value}">${item.value}
			</option>
			</c:forEach>
	   </select></td>
  </tr>
  <tr>
    <th>资产用途：</th>
    <td><input type="text" id="uses" value="${map.msg.uses }"></td>
  </tr>
  <tr>
    <th>购买时间：</th>
    <td><input type="date" id="entryTime" value="${map.date }"></td>
  </tr>
  <tr>
    <th>使用状态：</th>
    <td><input type="radio" id="status" name="status" value="在用"/>在用<input type="radio" name="status" value="空闲"/>空闲</td>
  </tr>
  <tr>
    <th>备 &nbsp;&nbsp;&nbsp;&nbsp;注：</th>
    <td><input type="text" id="remarks" value="${map.msg.remarks }"></td>
  </tr>
  <tr></tr>
  <tr>
    <th></th>
    <td><button style="float:right;" type="button" class="btn btn-info" onclick="addAsset()">添加</button></td>
  </tr>
</table>

</body>
<script src="content/index/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">

	function addAsset(){
		$.ajax({
	    		type: "post",
	            url: "assetController/addAsset",
	            async:false,
	            data: {
	            	"number" : $("#number").val(),
	            	"name" : $("#name").val(),
	            	"uses" : $("#uses").val(),
	            	"category" : $("#category").val(),
	            	"entryTime" : $("#entryTime").val(),
	            	"status" : $("input[name='status']:checked").val(),
	            	"remarks" : $("#remarks").val()
	            },
	            dataType: "json",
	            success: function(data){
	            	if(data['success']){
	            		layer.msg(data['msg'], {icon: 1, time: 1000}, function () {
	                        window.location.href = "assetController/toasset";  //加载资产信息页面
	                    });
	            	}else{
	            		layer.msg(data['msg'], {icon: 2, time:1000});
	            	}
	            },
	            error: function(data){
	            	layer.msg(data['msg'], {icon: 2, time: 1000});
	            }
	    	});
	}
</script>
</html>