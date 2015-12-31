<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<jsp:include page="/content/jsp/header.jsp"/>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="loginController/loginSuccess"><span class="glyphicon glyphicon-home"></span></a></li>
				<li class="active">固定资产信息</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">固定资产信息</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">资产信息表<button style="float:right;" type="button" class="btn btn-info" onclick="addAssetForm()">添加</button></div>
					<div class="panel-body">
						<table class="table-striped" data-toggle="table" data-url="content/index/tables/data1.json"  data-show-refresh="true" data-show-toggle="true" data-show-columns="true" data-search="true" data-select-item-name="toolbar1" data-pagination="true" data-sort-name="name" data-sort-order="desc">
						    <thead>
						    <tr>
						        <th data-field="number" data-sortable="true">资产编号</th>
						        <th data-field="name" data-sortable="true">资产名称</th>
						        <th data-field="uses"  data-sortable="true">资产用途</th>
						        <th data-field="category" data-sortable="true">资产类别</th>
						        <th data-field="entryTime"  data-sortable="true">购买时间</th>
						        <th data-field="status"  data-sortable="true">使用状态</th>
						        <th data-field="remarks"  data-sortable="true">备注</th>
						        <th data-field="edit"  data-sortable="false">编辑</th>
						    </tr>
						    </thead>
						</table>
					</div>
				</div>
			</div>
		</div><!--/.row-->	
	</div><!--/.main-->

	<script src="content/index/js/jquery-1.11.1.min.js"></script>
	<script src="content/index/js/bootstrap.min.js"></script>
	<script src="content/index/js/chart.min.js"></script>
	<script src="content/index/js/chart-data.js"></script>
	<script src="content/index/js/easypiechart.js"></script>
	<script src="content/index/js/easypiechart-data.js"></script>
	<script src="content/index/js/bootstrap-datepicker.js"></script>
	<script src="content/index/js/bootstrap-table.js"></script>
	<script src="content/plugin/layer/layer.js" type="text/javascript"></script>
	<script src="content/js/asset.js"></script>
	<script>
	

		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
		
		
	</script>	
</body>

</html>
