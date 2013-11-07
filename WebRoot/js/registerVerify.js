
/*$(document).ready(function(){

	/**
	 * 注册初级校验以及通过json向后台传数据  登录成功后跳转index.jsp界面
	 * 注册失败在提示区域提示错误
	 * @author 聂乐 2013-9-22 nele0716@163
	 */
	/*$("#registerOK").click(function(){
		var tuserNameNode=$("#tuserNameRegister");
		var tpasswordNode=$("#tpasswordRegister");
		var tconfirmNode=$("#verifyCodeRegister");
		var userKindNode=$("#userKindRegister");
		var emailNode=$("#email");
		var majorNode=$("#major");
		
		var tuserName=tuserNameNode.val();
		var tpassword=tpasswordNode.val();
		var tconfirm=tconfirmNode.val();
		var userKind=userKindNode.val();
		var email=emailNode.val();
		var major=majorNode.val();
	
		
		var emailReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		
		if(tuserName==""){
			$("#warningRegister").text("用户名不能为空！请输入用户名!");
		    return;
		}
		if(tpassword==""){
			$("#warningRegister").text("密码不能为空！请输入密码！");
			return;
		}
		if(tconfirm==""){
			$("#warningRegister").text("密码重复不能为空！请输入密码！");
			return;
		}
		if(email==""){
			$("#warningRegister").text("邮箱不能为空");
			return;
		}
		if(tpassword!=tconfirm){
			$("#warningRegister").text("两次输入密码不一致！");
			return;
		}
		
		if(!emailReg.test(email)){
			 $("#warningRegister").text("邮箱格式不正确！");
			   return;
		}
		
		$.ajax({
			type:"post",
			url:"register",
			dataType:"json",
			cache:false,
			data:{
				"teacher.tuserName":tuserName,
		        "teacher.tpassword":tpassword,
		        "teacher.email":email,
		        "majorId":major,
			},
			success:function(data){
				window.location.href="index.jsp";
			},
			error:function(data){
				   alert(data);
			}
		});
	});
	
	
	
		   var xyNode=$("#xy");//得到major节点
		    $.ajax({
		    	type:"post",
		    	url:"regissterShowXy",
		    	dataType:"json",
		    	cache:false,
		        success:function(data){
		        	var result=eval("("+data+")");
		        	var options="";
		        	options+="<option value='0'>==请选择类型==</option>";
		        	for(var i=0;i<result.length;i++){
		        		options+="<option value="+result[i].xyId+">"+result[i].xyName+"</options>";
		        	}
		        	xyNode.html(options);
		        },
		        error:function(data){
		        	alert(data);
		        },
		    });*/
	
/*});*/

jQuery(function ($) {
	
	$("#suserName").blur(function(){
	   var user_name_node=$("#suserName");
	   if(user_name_node.val()==""){
			if( $("#input_user_warning").hasClass("input_or_select_correct")){
			  $("#input_user_warning").removeClass("input_or_select_correct").addClass("input_error").text("请输入用户名");			  
			   }
			   else{
   $("#input_user_warning").removeClass("input_user_warning").addClass("input_error");
			  }}
			  else{
				  $("#input_user_warning").removeClass("input_user_warning").addClass("input_or_select_correct");
				  $("#input_user_warning").text("用户名正确！");
				  suserNameIsRight=true;
				  }
		});

    $("#register_tpassword").blur(function(){
	     var password_node=$("#register_tpassword");
		 if(password_node.val()==""){
			 if($("#input_password_warning").hasClass("input_or_select_correct")){
				 $("#input_password_warning").removeClass("input_or_select_correct").addClass("input_error").text("请输入密码");
				 }
				 else{
			        $("#input_password_warning").removeClass("input_password_warning").addClass("input_error");
					 }
			 }else{
				 $("#input_password_warning").removeClass("input_password_warning").addClass("input_or_select_correct");
				  $("#input_password_warning").text("密码正确！");
				  register_tpassword_isRight=true;
				 }
		});		
	
	
	$("#tpasswordConfirm").blur(function(){
	     var password_node=$("#register_tpassword");
		 var password_again_node=$("#tpasswordConfirm");
		 if(password_again_node.val()==""){
			 if($("#input_password_again_warning").hasClass("input_or_select_correct")){
				 $("#input_password_again_warning").removeClass("input_or_select_correct").addClass("input_error").text("请再次输入密码");
				 }
				 else{
			        $("#input_password_again_warning").removeClass("input_password_again_warning").addClass("input_error");
					 }
			 }
			 else if(password_again_node.val()!=password_node.val()){
				 if($("#input_password_again_warning").hasClass("input_or_select_correct")){
					   $("#input_password_again_warning").removeClass("input_or_select_correct").addClass("input_error").text("两次密码不一致");
							  }
					 else if($("#input_password_again_warning").hasClass("input_password_again_warning")){
						 $("#input_password_again_warning").removeClass("input_password_again_warning").addClass("input_error").text("两次密码不一致");                            addClass("input_error").text("邮箱格式错");
						   }
					 else{
						   $("#input_password_again_warning").text("两次密码不一致");
						  }	
				 
				 }
		 
			 else {
				 $("#input_password_again_warning").removeClass("input_password_again_warning").addClass("input_or_select_correct");
				  $("#input_password_again_warning").text("密码重复正确！");
				  tpasswordConfirm_isRight=true;
				 }
		});	
		
		
		$("#email").blur(function(){
	     var email_node=$("#email");
		 var email=email_node.val();
		 var emailReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		 
		 if(email_node.val()==""){
			 if($("#input_email_warning").hasClass("input_or_select_correct")){
				 $("#input_email_warning").removeClass("input_or_select_correct").addClass("input_error").text("请输入邮箱");
				 }
				 else{
			    $("#input_email_warning").removeClass("input_email_warning").addClass("input_error");
					 }
			 } 
	   else if(!emailReg.test(email)){
       	 if($("#input_email_warning").hasClass("input_or_select_correct")){
		   $("#input_email_warning").removeClass("input_or_select_correct").addClass("input_error").text("邮箱格式错");
				  }
		 else if($("#input_email_warning").hasClass("input_email_warning")){
			 $("#input_email_warning").removeClass("input_email_warning").addClass("input_error").text("邮箱格式错");                            addClass("input_error").text("邮箱格式错");
			   }
		 else{
			   $("#input_email_warning").text("邮箱格式错");
						  }	
				 }
				
   else{
				 $("#input_email_warning").removeClass("input_email_warning").addClass("input_or_select_correct");
				  $("#input_email_warning").text("邮箱正确！");
				  email_isRight=true;
				 }
		});
		
	
		$("#register_verifyCode").blur(function() {
			var register_verify_code_node=$("#register_verifyCode");
			if(register_verify_code_node.val()==""){
			   if($("#input_verifycode_warning").hasClass("input_verifycode_warning")){
				   $("#input_verifycode_warning").removeClass("input_verifycode_warning").addClass("input_error");
			   }
			}else{
				var verifyCode=register_verify_code_node.val();
				$.ajax({
					type:"post",
					url:"verifyCode",
					dataType:"json",
					cache:false,
					data:{
						"verifyCode":verifyCode
					    },
					success:function(data){
						if(data=="验证码错误"){
							 $("#input_verifycode_warning").html("验证码错误！");
							 $("#input_verifycode_warning").removeClass().addClass("input_error");	 
						}else if(data=="验证码正确"){
							 $("#input_verifycode_warning").html("验证码正确！");
							 $("#input_verifycode_warning").removeClass().addClass("input_or_select_correct");	 
							 register_verifyCode=true;
						}
					}
				});
			}
			
		});
		
	$("#register_submit_button").click(function(){
		 var user_name_node=$("#suserName");
		 var password_node=$("#register_tpassword");
		 var password_node=$("#register_tpassword");
		 var email_node=$("#email");
		 var register_verify_code_node=$("#register_verifyCode");
		 
		 var user_name=user_name_node.val();
	});
});
		
	
/*
$("#cilickToRegister").click(function (e) {
		e.preventDefault();

		// example of calling the confirm function
		// you must use a callback function to perform the "yes" action
		confirm(function () {
			window.location.href = 'register.html';
		});
	});
});

function confirm(callback) {
	$('#confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>X</a>",
		position: ["20%",],
		overlayId: 'confirm-overlay',
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			//$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
				// close the dialog
				modal.close(); // or $.modal.close();
			});
		}
	});
}*/