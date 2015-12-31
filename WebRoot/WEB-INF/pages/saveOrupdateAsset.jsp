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
    <td><input type="text" id="number"></td>
  </tr>
  <tr>
    <th>资产名称：</th>
    <td><input type="text" id="name"></td>
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
    <td><input type="text" id="uses"></td>
  </tr>
  <tr>
    <th>购买时间：</th>
    <td><input type="date" id="entryTime"></td>
  </tr>
  <tr>
    <th>使用状态：</th>
    <td>Row 1: Col 1</td>
  </tr>
  <tr>
    <th>Column 2 Heading</th>
    <td>Row 1: Col 1</td>
  </tr>
  <tr>
    <th>Column 2 Heading</th>
    <td>Row 1: Col 1</td>
  </tr>
</table>

	    		资产编号：<input type="text" id="number"><br><br>
	    		资产名称：<input type="text" id="name"><br><br>
	    		资产类别：<select id="category" name="">
		    					<c:forEach var="item" items="${category}">
		    					<option value="${item.value}">${item.value}
		    					</option>
		    					</c:forEach>
	    				   </select><br><br>
	    		资产用途：<input type="text" id="uses"><br><br>
	    		购买时间：<input type="date" id="entryTime"><br><br>
	    		使用状态：<input type="radio" id="status" name="status" value="在用"/>在用<input type="radio" name="status" value="空闲"/>空闲<br><br>
	    	 	备 &nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" id="remarks"><br>
	    		<br><br>
	    		<button style="float:right;" type="button" class="btn btn-info" onclick="addAssetForm()">添加</button>
</body>
</html>