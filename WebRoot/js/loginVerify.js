
$(document).ready(function(){
	
	/*setting box background*/
	$("#login_box_setting").css({
		"background":"#66CCCC",
		"opacity":0.7,
		
	});
		
	    /***
	     * define function for verify user
	     *@param user's information
	     * @author nele 2013-10-19 00:21 nele0716@163.com
	     * */
		function toLogin(){
		var tuserNameNode=$("#tuserName");
		var tpasswordNode=$("#tpassword");
		var verifyCodeNode=$("#verifyCode");
		var userKindNode=$("#userKind");
		
		var tuserName=tuserNameNode.val();
		var tpassword=tpasswordNode.val();
		var verifyCode=verifyCodeNode.val();
		var userKind=userKindNode.val();
		
		if(tuserName==""){
			$("#warning").text("用户名不能为空！请输入用户名!");
		    return;
		}
		if(tpassword==""){
			$("#warning").text("密码不能为空！请输入密码！");
			return;
		}
		if(verifyCode==""){
			$("#warning").text("验证码不能为空！请输入验证码！");
			return;
		}
		$.ajax({
			type:"post",
			url:"login",
			dataType:"json",
			cache:false,
			data:{
				"user.userName":tuserName,
		        "user.userPassword":tpassword,
		        "verifyCode":verifyCode,
		        "userKind":userKind,
			},
		success:function(data){
               var result=data.result;
			  if(result.toString()=="登陆成功！"){
				   window.location.href="test/index.jsp";
			  }else{
				  $("#warning").text(result);  
			  }
		 },
		 error:function(data){
			 alert(data);
		 }
		});
	};
		

	/**
	 * 调用登陆验证函数 登录初级校验以及通过json向后台传数据  登录成功后跳转index.jsp界面
	 * 登录失败在提示区域提示错误
	 * @author 聂乐 2013-9-22 nele0716@163
	 */	
	$("#loginOK").click(function(){
		toLogin();
	});	
	
	/***
	 * when enter "enter" strike function of toLongin();
	 * @param the key of press
	 * @author  nele   nele0716@163.com  00:34 
	 * */
    $(document).keypress(function(e){  
	        switch(e.which)  
	        {  
	            // user presses the "enter"  
	            case 13:    toLogin();  
	                        break;                                      
	        }  
	 });
    
});