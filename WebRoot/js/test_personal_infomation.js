$(document).ready(function(){

	/***
	 *  用于用户个人中心，鼠标移到到功能上背景变色，鼠标移开恢复以前；
	 * @author nele nele0716@163.com  2013-11-3
	 */
	var modify_user_info_node=$("#modify_user_info");
	var search_user_grade_node=$("#search_user_grade");
	 modify_user_info_node.mouseover(function(){
		 modify_user_info_node.css("background-color","#66CC99"); 
	 });
	 
   modify_user_info_node.mouseout(function(){ 
		 modify_user_info_node.css("background-color","#99CCFF"); 
	 });
	
   search_user_grade_node.mouseover(function(){
	   search_user_grade_node.css("background-color","#66CC99"); 
   });
   
   search_user_grade_node.mouseout(function() {
	   search_user_grade_node.css("background-color","#99CCFF"); 
   });
   
   
   /***
    * 加载显示学校，专业，班级的页面到当前页面
    * @author nele nele0716@163.com 2013-11-3
    */
 modify_user_info_node.click(function(){
		 $("#main").load("show_or_modify_personal_info.jsp");
	});
	 
	  /***
	  * 显示用户学校，专业，班级；用于修改
	  * @author nele  nele0716@163.com 2013-11-3 
	  */
	/*$("#test_modify_user_info_modify_class_btn").click(function(){
		var show_xy_major__class_node=$("#show_class_div");
		  show_xy_major__class_node.load("show_xy_major_class_toModify.jsp");
	});*/
    var bj;//当前专业班级组成
	var bjId;//当前班级id
 $("#test_modify_user_info_modify_class_btn").click(function(){
	 $("#show_class_div").hide();
	$("#show_xy_major_class").show("slow",function(){
		var xyIdString=$("#xy").find("option:first").val();
		var majorIdString=$("#major").find("option:first").val();
		var bjIdString=$("#bj").find("option:first").val();

		var xyId=parseInt(xyIdString, 10);
		var majorId=parseInt(majorIdString,10);
		bjId=parseInt(bjIdString,10);
		$.ajax({
	    	   type: "POST",
	    	   url: "getAllXyAndMajorAndClass",
	    	   data:{
	    		      "xyId":xyId,
	    		      "majorId":majorId,
	    		      },
	    	         // 成功返回map
	    	   success: function(data){
         	    	   var options="";
         	    	   var majoroptions="";
         	    	   var bjoptions="";
         	    	   //先取出学院 和major的list 在eval解析
                       // var xueYuan=eval("("+data["xueYuan"]+")");\
         	    	   var xueYuanDemo=data["xueYuan"];
         	    	   var majorDemo=data["major"];
         	    	   var bjDamo=data["bj"];
         	    	   var major=eval("("+majorDemo+")");
         	    	   var xueYuan=eval("("+xueYuanDemo+")");
         	    	    bj=eval("("+bjDamo+")");
         	    	    
         	    for(var i=0;i<xueYuan.length;i++){
         	        if(xyId==xueYuan[i].xyId){
         	    		   options+="<option value="+xueYuan[i].xyId+" selected='selected'>"+xueYuan[i].xyName+"</option>";
         	    	    }
         	    		 else{
         	    			options+="<option value="+xueYuan[i].xyId+">"+xueYuan[i].xyName+"</option>";
         	    		  }
         	    	  }
         	
         	    	  
         	 for(var j=0;j<major.length;j++){
         	         if(majorId==major[j].majorId){
         	    			 majoroptions+="<option value="+major[j].majorId+" selected='selected'>"+major[j].majorName+"</option>";
            	    	    }
            	    		else{
            	    		majoroptions+="<option value="+major[j].majorId+">"+major[j].majorName+"</option>";
            	    	   }
         	    	 }
         	 
         	for(var k=0;k<bj.length;k++){
	    		  if(bjId==bj[k].classId){
	    			  bjoptions+="<option value="+bj[k].classId+" selected='selected'>"+bj[k].classGrade+"</option>";
	    	       }
	    		else{
	    			  bjoptions+="<option value="+bj[k].classId+">"+bj[k].classGrade+"</option>";
	    	   }
	    	 }
                     $("#xy").html(options);
         	    	 $("#major").html(majoroptions);
         	    	 $("#bj").html(bjoptions);
	    	   }, 
	    	   error:function(data){
	    		     alert(data);
	    	   },
	      });	
	});  
	});
	
   /***
    * 学校改变，专业联动
    * @author nele nele0716@163.com 2013-11-5
    */
    $("#xy").change(function(){
       var xyIdModifyString=$("#xy").val();
       var xyIdModify=parseInt(xyIdModifyString, 10);
       $.ajax({
			  type:"post",
		      url:"getMajor",
		      dataType:"json",
		      cache:false,
		      data:{
		    	  "xyId":xyIdModify,
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
		          $("#bj").html("<option>==请选择班级==</option>")
		      },
		      error:function(data){
		    	  alert(data);
		      }
		   });
    	
    });
 
    /***
     * 专业改变时，获得对应的班级，显示在班级的下拉列表中
     * @author nele nele0716@163.com 2013-11-4
     */
    $("#major").change(function(){
    	var majorIdModifyString=$("#major").val();
    	var majorIdModify=parseInt(majorIdModifyString, 10);
    	 $.ajax({
		    	type:"post",
		    	url:"getClass",
		    	dataType:"json",
		    	cache:false,
		        data:{
		        	"majorId":majorIdModify,
		        },
		        success:function(data){
		        	var result=eval("("+data+")");
		        	var options="";
		        	options+="<option value='0'>==请选择类型==</option>";
		        	for(var i=0;i<result.length;i++){
		        		options+="<option value="+result[i].classId+">"+result[i].classGrade+"</options>";
		        	}
		        	$("#bj").html(options);
		        },
		        error:function(data){
		        	alert(data);
		        }
		    }); 
    	
    });
    
    /***
     * 选择新班级时。获得新班级的id
     * @author nele  nele0716@163.com 2013-11-5
     */
     var bjIdModify;//选择的新班级的id
	 $("#bj").change(function(){
		    var bjIdModifyString=$("#bj").val();
		    bjIdModify=parseInt(bjIdModifyString, 10);	    
	});
	 
	 /***
	  * 提交修改的学院，专业，班级，
	  * @author nele nele0716@163.com 2013-11-4
	  */
	$("#modify_ok").click(function(){
		var bjIdModifyString=$("#bj").val();
		var bjIdModifySubmit=parseInt(bjIdModifyString, 10);
		var s_num=$("#sno").val();
		var pk_sno_string=$("#pk_sno").val();
	    var pk_sno=parseInt(pk_sno_string, 10);
		$("#show_xy_major_class").hide("fast");
		$("#show_class_div").show("slow");
		if(bjIdModify!=bjId){
			for(var k=0;k<bj.length;k++){
				if(bj[k].classId==bjIdModify)
					$("#bjName").text(bj[k].classGrade);
			}
			$.ajax({
				type:"post",
				url:"modifyClassId",
				dataType:"json",
			    cache:false, 
			    data:{
			    	"classId":bjIdModifySubmit,
			    	"sno":pk_sno,
			    },
			    success:function(data){
			    	alert(data);
			    },
			    error:function(data){
			    	alert("修改班级出错！");
			    }
			});
	    }
		
	});
	
	/**
	 * 修改班级id取消操作
	 * @author nele nele0716@163.com  2013-11-5
	 */
	$("#bi_modify_cancal_btn").click(function(){
		$("#show_xy_major_class").hide("fast");
		$("#show_class_div").show("slow");
	});
	
	/***
	 * 点击修改密码，显示修改div
	 * @author nele nele0716@163.com 2013-11-5
	 */
   $("#click_to_modify_pwd").click(function(){
	     $("#click_modify_pwd_div").hide();
	     $("#show_modify_pwd_box").show("slow");
   });
   
   
   /***
    * 对输入原始密码进行验证
    * @author nele  nele0716@163.com 2013-11-6
    */
   $("#pre_pwd").blur(function(){
	   var sno=$("#sno").val();
	   var pre_pwd_node=$("#pre_pwd");
	   var waring_node= $("#right_show_error_warning");
	   var new_pwd_node=$("#new_pwd");
	   var new_pwd_again_node=$("#new_pwd_again");
	   var pre_pwd=pre_pwd_node.val();
	   if(pre_pwd==""){
		   waring_node.html("原始密码不能为空！");
		   return;
	   }
	   $.ajax({
		      type:"post",
			  url:"verifyToPrePwd",
		      dataType:"json",
		      cache:false, 
		      data:{
		    	  "prePwd":pre_pwd,
		    	  "s_num":sno,
		      },
		      success:function(data){
		    	 if(data=="原始密码不正确"){
		    		 if(new_pwd_node.attr("disabled")!="disabled")
			    		    new_pwd_node.attr("disabled","disabled");
			    	if(new_pwd_again_node.attr("disabled")!="disabled")
			    			 new_pwd_again_node.attr("disabled","disabled");
			    	waring_node.html("原始密码不正确,请重新输入");
		    		 return;
		    	 }
		    	 else{
		    		 if(new_pwd_node.attr("disabled")=="disabled")
			    		    new_pwd_node.attr("disabled",false);
			    	if(new_pwd_again_node.attr("disabled")=="disabled")
			    			 new_pwd_again_node.attr("disabled",false);
		    		 waring_node.html("原始密码正确");
		    	 }
		    		 
		      },
		      error:function(data){
		    	  alert("验证原始密码出现错误！");
		    	  return;
		      }
	    });
   });
    
   /***
    * 点击向后输新密码，并提交修改密码
    * @author nele nele0716@163.com 2013-11-5
    */
   $("#pwd_modify_ok").click(function(){
	   var sno=$("#sno").val();
	   var pk_sno_string=$("#pk_sno").val();
	   var pk_sno=parseInt(pk_sno_string, 10);
	   var pre_pwd_node=$("#pre_pwd");
	   var new_pwd_node=$("#new_pwd");
	   var new_pwd_again_node=$("#new_pwd_again");
	   var  waring_node= $("#right_show_error_warning");
	   var new_pwd=new_pwd_node.val();
	   var new_pwd_again=new_pwd_again_node.val();
	   pre_pwd_node.val("");
	   new_pwd_node.val("");
	   new_pwd_again_node.val("");
	   
	   if(new_pwd==""){
		   waring_node.html("新密码不能为空!");
		   return;
	   }
	   if(new_pwd_again==""){
		   waring_node.html("新密码重复不能为空!");
		   return;
	   }
	   if(new_pwd!=new_pwd_again){
		   waring_node.html("两次输入的新密码不一致");
		   return;
	   }
	   $.ajax({
		  type:"post",
		  url:"studentModifyPwd",
	      dataType:"json",
	      cache:false, 
	      data:{
	    	  "pwd":new_pwd,
	    	  "sno":pk_sno,
	      },
	      success:function(data){
	    	  alert(data);
	    	  $("#show_modify_pwd_box").hide();
	          $("#click_modify_pwd_div").show();	  
	      },
	      error:function(data){
	    	   alert("更改密码失败啦");
	      }
		   
	   });
	   
   });

    /***
     *密码修改div取消
     * @author nele nele0716@163.com 2013-11-6
     */
   $("#pwd_modify_cancel").click(function(){
         $("#show_modify_pwd_box").hide();
         $("#click_modify_pwd_div").show();
   });
   
   
   /**
    * 点击修改邮箱
    * @author nele nele0716@163.com 2013-11-6
    */
   $("#email_submit_modify_btn").click(function(){
	   var new_email_node=$("#email_modify_text");
	   var new_email=new_email_node.val();
	   var pk_sno_string=$("#pk_sno").val();
	   var pk_sno=parseInt(pk_sno_string, 10);
	   var emailReg=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	   if(!emailReg.test(new_email)){
		   $("#email_warning").text("邮箱格式不正确！");
		   return;
	   }
	   else{
		   $("#email_warning").text("");
	   }
	   $.ajax({
		    type:"post",
		    url:"modifyEmail",
		    dataType:"json",
		    cache:false, 
		    data:{
		    	  "new_email":new_email,
		    	  "sno":pk_sno,
		      },
		      success:function(data){
		    	  alert(data);  
		      },
		      error:function(data){
		    	  alert("修改邮箱错误！");
		      }
		   
	   });
   });
});