
$(document).ready(function(){
//	 var data=[{'name':'nale','age':18},{'name':'try','age':18}];
//	 
//	 alert(data[0].name);
//	
	
	
	  /**
	   * 根据选择的学院自动匹配该学院全部的major 实现了菜单的联动
	   * @author 聂乐 2013-9-21 nele0716@163.com
	   */
	   $("#xy").change(function(){
		   var xyNode=$("#xy");
		   var xyId=xyNode.val();//得到是value的值；
		   $.ajax({
			  type:"post",
		      url:"getMajor",
		      dataType:"json",
		      cache:false,
		      data:{
		    	  "xyId":xyId
		      },
		      success:function(data){
         	    	  var dataObj=eval("("+data+")");//讲字符创转换成json格式
//		    	   alert(dataObj.length);//可以去json值得长度
         	    	 var options="";
         	    	 options+="<option value='0'>==请选择类型==</option>"; 

         	    	  for(var i=0;i<dataObj.length;i++){
         	    		  options+="<option value="+dataObj[i].majorId+">"+dataObj[i].majorName+"</option>";//拼凑option
         	    	  }
         	    	  $("#major").html(options);//讲options加入<select>中
		      },
		      error:function(data){
		    	  alert(data);
		      }
		   });
	   });
	   
	   /**
	    * 根据选择的major自动匹配改major全部的class 实现了菜单的联动
	    * @author 聂乐 2013-9-21 nele0716@163.com 
	    */
	   $("#major").change(function(){
		   var majorNode=$("#major");//得到major节点
		   var majorId=majorNode.val();//获得选择的专业的majorId
		    $.ajax({
		    	type:"post",
		    	url:"getClass",
		    	dataType:"json",
		    	cache:false,
		        data:{
		        	"majorId":majorId
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
		        }
		    }); 
	   });
	
	   /**
	    * 添加学生的初次校验，以及向后台传一个学生的信息
	    * @author 聂乐 2013-9-22 nele0716@163.com
	    */
	   $("#addStudent").click(function(){
		   var suserNameNode=$("#suserName");
		   var spasswordNode=$("#spassword");
		   var sconfirmNode=$("#sconfirm");
		   var studentNumNode=$("#studentNum");
		   
		   var ssexNode=$("#ssex");
		   var sxyNode=$("#xy");
		   var smajorNode=$("#major");
		   var sclassNode=$("#class");
		   var semailNode=$("#email")
		   
           var suserName=suserNameNode.val();
		   var spassword=spasswordNode.val();
		   var sconfirm=sconfirmNode.val();
		   var studentNum=studentNumNode.val();
		   var ssex=ssexNode.val();
		   var sclass=sclassNode.val();
		   var semail=semailNode.val();
		   
		   //邮箱的验证的形式
		   var emailReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		   
		    if(suserName==""){
		    	$("#warning").text("用户名不能为空！");
		    	return;
		    } if(spassword==""){
		    	$("#warning").text("密码不能为空！");
		    	return;
		    }if(sconfirm==""){
		    	$("#warning").text("密码验证不能为空！");
		    	return;
		    }if(spassword!=sconfirm){
			   $("#warning").text("两次密码不一致");
			   return;
		   }
		   if(!emailReg.test(semail)){
			   $("#warning").text("邮箱格式不正确！");
			   return;
		   }
		   
		   $.ajax({
			   type:"post",
		       url:"submitaddStudent",
		       dataType:"json",
		       cache:false,
		       data:{
		    	   "student.studentName":suserName,
		    	   "student.studentPassword":spassword,
		    	   "student.studentNum":studentNum,
		    	   "student.studentSex":ssex,
		    	   "student.classId":sclass,
		    	   "student.email":semail
		       },
		       success:function(data){
		    	   window.location.href="operatorSuccess.jsp";
		       },
		       error:function(data){
		    	   alert(data);
		       }
		   });
	   });
});