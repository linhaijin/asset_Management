
$(function(){

});


function editAsset(id){
	$.ajax({
		type: "post",
        url: "assetController/searchAsset",
        async:false,
        data: {
        	"id":id
        },
        dataType: "json",
        success: function(data){
        	var asset = eval(data['msg']);
        	var date = data['date'];
        	$("input:radio[value="+asset['gender']+"]").attr('checked','true');
        	$("input:radio[value="+asset['status']+"]").attr('checked','true');
        	var index = layer.open({
        		area: ['400px', '500px'],
        		title :'修改资产',
        	    content: "<form id='editAssetForm'>" +
        	    		"资产编号：<input type='text' id='number' value="+"'"+asset['number']+"'"+"><br>" +
        	    		"资产名称：<input type='text' id='name' value="+"'"+asset['name']+"'"+"><br>" +
        	    		"资产类别：<select id='category' name=''><c:forEach var='item' items='${category_list}'><c:choose><c:when test='${category==item.value}'><option value='${item.value}' selected='true'>${item.value}</option></c:when><c:otherwise><option value='${item.value}'>${item.value}</option></c:otherwise></c:choose></c:forEach></select><br>" +
        	    		"资产用途：<input type='text' id='job' value="+"'"+asset['uses']+"'"+"><br>" +
        	    		"入职时间：<input type='date' id='entryTime' value="+"'"+date+"'"+"><br>" +
        	    		"使用状态：<input type='radio' id='status' name='status' value='在用'/>在用<input type='radio' name='status' value='空闲'/>空闲<br>" +
        	    		"备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type='text' id='remarks' value="+"'"+asset['remarks']+"'"+"><br>" +
        	    		"</form>",
        	    btn: ['修改', '取消'],
        	    btn1: function(index, layero){
        	    	$.ajax({
        	    		type: "post",
        	            url: "assetController/addAsset",
        	            async:false,
        	            data: {
        	            	"id" : id,
        	            	"number" : $("#number").val(),
        	            	"name" : $("#name").val(),
        	            	"category" : $("input[name='category']:checked").val(),
        	            	"uses" : $("#uses").val(),
        	            	"entryTime" : $("#entryTime").val(),
        	            	"status" : $("input[name='status']:checked").val(),
        	            	"remarks" : $("#remarks").val()
        	            },
        	            dataType: "json",
        	            success: function(data){
        	            	if(data['success']){
        	            		layer.msg('修改成功', {icon: 1, time: 1000}, function () {
        	                        window.location.href = "assetController/toasset";  //加载员工信息页面
        	                    });
        	            	}else{
        	            		layer.msg('修改失败', {icon: 2, time:1000});
        	            	}
        	            },
        	            error: function(data){
        	            	layer.msg('系统异常，请稍后再试', {icon: 2, time: 1000});
        	            }
        	    	});
        	    },
        	    btn2: function(index){
        	    	layer.close(index);
        	    },
        	});
        },
        error: function(data){
        	layer.msg('查询出错，请稍后再试', {icon: 2, time: 1000});
        }
	});
}

function deleteAsset(id){
	layer.msg('你确定要删除么？', {
	    time: 0 //不自动关闭
	    ,btn: ['必须啊', '算了吧']
	    ,yes: function(index){
	    	$.ajax({
	    		type: "post",
	            url: "assetController/deleteAsset",
	            async:false,
	            data: {
	            	"id" : id
	            },
	            dataType: "json",
	            success: function(data){
	            	if(data['success']){
	            		layer.msg('删除成功', {icon: 1, time: 1000}, function () {
	            			window.location.href = "assetController/toasset";  //加载员工信息页面
	            		});
	            	}else{
	            		layer.msg("删除失败，请稍后再试", {icon: 2, time: 1000});
	            	}
	            },
	            error: function(data){
	            	layer.msg("系统异常，请稍后再试", {icon: 2, time: 1000});
	            }
	    	});
	    }
	});
}

function addAssetForm(){
//	var category = ${category};
//	var value = ${item.value};
	layer.open({
	    type: 2,
	    title: '添加固定资产',
	    shadeClose: true,
	    shade: 0.8,
	    area: ['380px', '60%'],
	    content: 'assetController/tosaveOrupdateAsset' //iframe的url
	});
	
	/*var index = layer.open({
		area: ['400px', '500px'],
		title :'添加资产',
	    content: "<form id='addAssetForm'>" +
	    		"资产编号：<input type='text' id='number'><br>" +
	    		"资产名称：<input type='text' id='name'><br>" +
	    		"资产类别：<select id='category' name=''><c:forEach var='item' items="+${category}+"><c:choose><option value="+${item.value}+">"+${item.value}+"</option></c:choose></c:forEach></select><br>" +
	    		"资产用途：<input type='text' id='uses'><br>" +
	    		"购买时间：<input type='date' id='entryTime'><br>" +
	    		"使用状态：<input type='radio' id='status' name='status' value='在用'/>在用<input type='radio' name='status' value='空闲'/>空闲<br>" +
	    		"备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type='text' id='remarks'><br>" +
	    		"</form>",
	    btn: ['确定', '取消'],
	    btn1: function(index, layero){
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
	                        window.location.href = "assetController/toasset";  //加载员工信息页面
	                    });
	            	}else{
	            		layer.msg(data['msg'], {icon: 2, time:1000});
	            	}
	            },
	            error: function(data){
	            	layer.msg(data['msg'], {icon: 2, time: 1000});
	            }
	    	});
	    },
	    btn2: function(index){
	    	layer.close(index);
	    },
	});*/
}

