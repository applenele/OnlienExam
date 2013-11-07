
$(document).ready(function(){
	
	$("#xy").change(function(){
		   var xyNode=$("#xy");
		   var xyId=xyNode.val();//得到是value的值；
		   $.ajax({
			  type:"post",
		      url:"getMajor",
		      dataType:"json", 
		      cache:false,
		      data:{
		    	  "xyId":xyId,
		      },
		      success:function(data){
      	    	  var dataObj=eval("("+data+")");//讲字符创转换成json格式
//		    	   alert(dataObj.length);//可以去json值得长度
      	    	 var options="";
      	    	 options+="<option value='0'>==请选择类型==</option>"; 

      	    	  for(var i=0;i<dataObj.length;i++){
      	    		  options+="<option value="+dataObj[i].majorId+">"+dataObj[i].majorName+"</option>";//拼凑option
      	    	  }
      	    	  $("#major").html(options);//讲option
		      },
		      error:function(data){
		    	  alert(data);
		      }
		   });
	   });
	
	$("#major").change(function(){
		   var majorNode=$("#major");//得到major节点
		   var majorId=majorNode.val();//获得选择的专业的majorId
		    $.ajax({
		    	type:"post",
		    	url:"getClass",
		    	dataType:"json",
		    	cache:false,
		        data:{
		        	"majorId":majorId,
		        },
		        success:function(data){
		        	var result=eval("("+data+")");
		        	var options="";
		        	options+="<option value='0'>==请选择类型==</option>";
		        	for(var i=0;i<result.length;i++){
		        		options+="<option value="+result[i].classId+">"+result[i].classGrade+"</options>";
		        	}
		        	$("#class").html(options);
		        },
		        error:function(data){
		        	alert(data);
		        },
		    }); 
	   });
	
		$("#submit").click(function(){
			 var snoNode=$("#sno");
			 var suserNameNode=$("#suserName");
			 var studentNumNode=$("#studnetNum");
			 var classIdNode=$("#classId");
			 var emailNode=$("#email");
			 var studentSexNode=$("#studentSex");
			 var oldPasswordNode=$("#oldPassword");
			 var newPasswordNode=$("#newPassword");
			 var ConfirmTewPassword=$("#ConfirmTewPassword");
			 
			 var sno=snoNode.val();
			 var suserName=suserNameNode.val();
			 var studentNum=studentNumNode.val();
			 var classId=classIdNode.val();
			 var email=emailNode.val();
			 var studentSex=studentSexNode.val();
			 var oldPassword=oldPasswordNode.val();
			 var newPassword=newPasswordNode.val();
			 var ConfirmTewPassword=ConfirmTewPassword.val();
			 
			 var emailReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			 
			 
			 if(newPassword!=ConfirmTewPassword){
				 $("#warning").html("新密码两次输入不一样！");
				 return;
			 }
			 if(!emailReg.test(email)){
				 $("#warning").html("邮箱的格式不正确!");
			 }
			 	 
		     $.ajax({
		    	type:"post",
		        url:"toModifyStudentInfo",
		        dataType:"json",
		        async:false,
		        data:{
		        	"student.sno":sno,
		        	"student.studentName":suserName,
		        	"student.studentPassword":oldPassword,
		        	"student.studentSex":studentSex,
		        	"student.classId":classId,
		        	"student.email":email,
		        	"student.studentNum":studentNum,
		        	"newPassword":newPassword,
		        },
		        success:function(data){
		                if(data=="用户名与原始密码不一致！"){
		                	$("#warning").html("用户名与原始密码不一致!");
		                	return;
		                }
		                if(data=="更改成功！"){
		                	window.location.href="operatorSuccess.jsp";
		                }
		        },
		        error:function(data){
		        	 alert("error");
		        },
		    	 
		     });
		});
});