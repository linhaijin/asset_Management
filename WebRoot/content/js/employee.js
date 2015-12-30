
$(function(){

});


function editEmployee(id){
	$.ajax({
		type: "post",
        url: "employeeController/searchEmployee",
        async:false,
        data: {
        	"id":id
        },
        dataType: "json",
        success: function(data){
        	var employee = eval(data['msg']);
        	var date = data['date'];
        	console.log(data);
        	console.log(employee);
        	console.log(date);
        	console.log(employee['number']);
        	$("input:radio[value="+employee['gender']+"]").attr('checked','true');
        	$("input:radio[value="+employee['status']+"]").attr('checked','true');
        	var index = layer.open({
        		area: ['400px', '500px'],
        		title :'添加员工',
        	    content: "<form id='editEmployeeForm'>" +
        	    		"员工编号：<input type='text' id='number' value="+"'"+employee['number']+"'"+"><br>" +
        	    		"员工姓名：<input type='text' id='name' value="+"'"+employee['name']+"'"+"><br>" +
        	    		"员工性别：<input type='radio' id='gender' name='gender' value='男'/>男<input type='radio' name='gender' value='女'/>女<br>" +
        	    		"员工职务：<input type='text' id='job' value="+"'"+employee['job']+"'"+"><br>" +
        	    		"入职时间：<input type='date' id='entryTime' value="+"'"+date+"'"+"><br>" +
        	    		"员工状态：<input type='radio' id='status' name='status' value='试用'/>试用<input type='radio' name='status' value='在职'/>在职" +
        	    		"<input type='radio' name='status' value='离职'/>离职<input type='radio' name='status' value='实习'/>实习<br>" +
        	    		"备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type='text' id='remarks' value="+"'"+employee['remarks']+"'"+"><br>" +
        	    		"</form>",
        	    btn: ['修改', '取消'],
        	    btn1: function(index, layero){
        	    	$.ajax({
        	    		type: "post",
        	            url: "employeeController/addEmployee",
        	            async:false,
        	            data: {
        	            	"id" : id,
        	            	"number" : $("#number").val(),
        	            	"name" : $("#name").val(),
        	            	"gender" : $("input[name='gender']:checked").val(),
        	            	"job" : $("#job").val(),
        	            	"entryTime" : $("#entryTime").val(),
        	            	"status" : $("input[name='status']:checked").val(),
        	            	"remarks" : $("#remarks").val()
        	            },
        	            dataType: "json",
        	            success: function(data){
        	            	if(data['success']){
        	            		layer.msg('修改成功', {icon: 1, time: 1000}, function () {
        	                        window.location.href = "employeeController/toemployee";  //加载员工信息页面
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

function deleteEmployee(id){
	layer.msg('你确定要删除么？', {
	    time: 0 //不自动关闭
	    ,btn: ['必须啊', '算了吧']
	    ,yes: function(index){
	    	$.ajax({
	    		type: "post",
	            url: "employeeController/deleteEmployee",
	            async:false,
	            data: {
	            	"id" : id
	            },
	            dataType: "json",
	            success: function(data){
	            	if(data['success']){
	            		layer.msg('删除成功', {icon: 1, time: 1000}, function () {
	            			window.location.href = "employeeController/toemployee";  //加载员工信息页面
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

function addEmployeeForm(){
	var index = layer.open({
		area: ['400px', '500px'],
		title :'添加员工',
	    content: "<form id='addEmployeeForm'>" +
	    		"员工编号：<input type='text' id='number'><br>" +
	    		"员工姓名：<input type='text' id='name'><br>" +
	    		"员工性别：<input type='radio' id='gender' name='gender' value='男'/>男<input type='radio' name='gender' value='女'/>女<br>" +
	    		"员工职务：<input type='text' id='job'><br>" +
	    		"入职时间：<input type='date' id='entryTime'><br>" +
	    		"员工状态：<input type='radio' id='status' name='status' value='试用'/>试用<input type='radio' name='status' value='在职'/>在职" +
	    		"<input type='radio' name='status' value='离职'/>离职<input type='radio' name='status' value='实习'/>实习<br>" +
	    		"备 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type='text' id='remarks'><br>" +
	    		"</form>",
	    btn: ['确定', '取消'],
	    btn1: function(index, layero){
	    	$.ajax({
	    		type: "post",
	            url: "employeeController/addEmployee",
	            async:false,
	            data: {
	            	"number" : $("#number").val(),
	            	"name" : $("#name").val(),
	            	"gender" : $("input[name='gender']:checked").val(),
	            	"job" : $("#job").val(),
	            	"entryTime" : $("#entryTime").val(),
	            	"status" : $("input[name='status']:checked").val(),
	            	"remarks" : $("#remarks").val()
	            },
	            dataType: "json",
	            success: function(data){
	            	if(data['success']){
	            		layer.msg(data['msg'], {icon: 1, time: 1000}, function () {
	                        window.location.href = "employeeController/toemployee";  //加载员工信息页面
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
	});
}

