
$(document).ready(function(){
	
	 $("tr:odd").addClass("showStudentTableOddtr");
	    
	  $("td:odd").addClass("showStudentTableOddtd");
	    
		$("#next").mouseover(function(){
			$("#next").css("background-color","yellow");
		});
		$("#next").mouseout(function(){
			$("#next").css("background-color","#0099CC");
		});
	    
		
		$("#last").mouseover(function(){
			$("#last").css("background-color","yellow");
		});
		$("#last").mouseout(function(){
			$("#last").css("background-color","#0099CC");
		});
		
		$("#first").mouseover(function(){
			$("#first").css("background-color","yellow");
		});
		$("#first").mouseout(function(){
			$("#first").css("background-color","#0099CC");
		});
		
		$("#final").mouseover(function(){
			$("#final").css("background-color","yellow");
		});
		$("#final").mouseout(function(){
			$("#final").css("background-color","#0099CC");
		});
		
		$("tr:odd").mouseover(function(){
			$(this).css("background-color","yellow");
		});
		$("tr:odd").mouseout(function(){
			$(this).css("background-color","#99CCFF");
		});
		
		$("tr:even").mouseover(function(){
			$(this).css("background-color","yellow");
		});
		$("tr:even").mouseout(function(){
			$(this).css("background-color","#FFFFFF");
		});
	/***
	 * 实现向下翻页
	 * @author 聂乐 2013-9-24 nele0716@163.com 
	 */
	$("#next").click(function(){
		if($("#last").attr("disabled")=="disabled"){
			$("#last").removeAttr("disabled");
			$("#warning").html("");
		}
		var pageIndexNode=$("#pageIndex");
		var pageIndexString=pageIndexNode.text();
		var pageIndex=parseInt(pageIndexString,10);
		var nextPageIndex=pageIndex+1;
		
		$.ajax({
			type:"post",
			url:"getPage",
			dataType:"json",
			cache:false,
			data:{
				"pageIndex":nextPageIndex,
			},
			success:function(data){
				if(data=="["){
			     	 $("#next").attr("disabled",true);
					 $("#warning").html("已到最后一页"); 
					 return;
				}
				 else{
					 var dataObj=eval("("+data+")");//讲字符创转换成json格式
				 var tds="<thead><tr><th>编号</th><th>学生姓名</th><th>学院</th><th>专业</th><th>班级</th><th>性别</th><th>邮箱</th><th>操作</th></tr></thead>";
     	    	  for(var i=0;i<dataObj.length;i++){
     	    		 tds=tds+"<tr><td>"+(i+1)+"</td><td>"+dataObj[i].suserName+"</td><td>"
     	    		 +dataObj[i].xyName+"</td><td>"+dataObj[i].majorName+"</td><td>"+dataObj[i].classGrade
     	    		 +"</td><td>"+dataObj[i].studentSex+"</td><td>"+dataObj[i].email+"</td><td><a href='toModifyStudent?sno="+dataObj[i].sno+"'>修改 </a><a href=''>删除</a></td></tr>";
     	    	  }
     	    	  $("#showTable").html(tds);//讲td tr加到table上
     	    	 pageIndexNode.html(nextPageIndex);
     	    	 $("tr:odd").addClass("showStudentTableOddtr");
     	        
     	        $("td:odd").addClass("showStudentTableOddtd");
     	        
     	       $("tr:odd").mouseover(function(){
     				$(this).css("background-color","yellow");
     			});
     			$("tr:odd").mouseout(function(){
     				$(this).css("background-color","#99CCFF");
     			});
     			
     			$("tr:even").mouseover(function(){
     				$(this).css("background-color","yellow");
     			});
     			$("tr:even").mouseout(function(){
     				$(this).css("background-color","#FFFFFF");
     			});
			}},
		    error:function(data){
		    	alert(data);
		    },
		});
	});
	
	/***
	 * 实现向上翻页
	 * @author 聂乐 2013-9-24 nele0716@163.com
	 */
	$("#last").click(function(){
		if($("#next").attr("disabled")=="disabled"){
			  $("#next").removeAttr("disabled");
			  $("#warning").html("");
	     }
		var pageIndexNode=$("#pageIndex");
		var pageIndexString=pageIndexNode.text();
		var pageIndex=parseInt(pageIndexString, 10);
		if(pageIndex==1){
			 $("#last").attr("disabled",true);
			 $("#warning").html("已到达首页");
			 return;
		}
		var lastPageIndex=pageIndex-1;
		  pageIndexNode.html(lastPageIndex);
		  $.ajax({
              type:"post",
              url:"getPage",
              dataType:"json",
              cache:false,
              data:{
            	  "pageIndex":lastPageIndex,
              },
              success:function(data){
            		 var dataObj=eval("("+data+")");//讲字符创转换成json格式
    				 var tds="<thead><tr><th>编号</th><th>学生姓名</th><th>学院</th><th>专业</th><th>班级</th><th>性别</th><th>邮箱</th><th>操作</th></tr></thead>";
         	    	  for(var i=0;i<dataObj.length;i++){
         	    		 tds=tds+"<tr><td>"+(i+1)+"</td><td>"+dataObj[i].suserName+"</td><td>"
         	    		 +dataObj[i].xyName+"</td><td>"+dataObj[i].majorName+"</td><td>"+dataObj[i].classGrade
         	    		 +"</td><td>"+dataObj[i].studentSex+"</td><td>"+dataObj[i].email+"</td><td><a href='toModifyStudent?sno="+dataObj[i].sno+"'>修改</a> 删除</td></tr>";
         	    	  }
         	    	  $("#showTable").html(tds);//讲td tr加到table上
         	    	  
         	    	 $("tr:odd").addClass("showStudentTableOddtr");
         	        
         	        $("td:odd").addClass("showStudentTableOddtd");
         	        
         	       $("tr:odd").mouseover(function(){
         				$(this).css("background-color","yellow");
         			});
         			$("tr:odd").mouseout(function(){
         				$(this).css("background-color","#99CCFF");
         			});
         			
         			$("tr:even").mouseover(function(){
         				$(this).css("background-color","yellow");
         			});
         			$("tr:even").mouseout(function(){
         				$(this).css("background-color","#FFFFFF");
         			});
              },
              error:function(data){
            	  alert(data);
              },
		  });
	 });
	
	/***
	 * 分页到首页
	 * @author 聂乐  2013-9-24 nele0716@163.com
	 */
	$("#first").click(function(){
		var pageIndexNode=$("#pageIndex");
		var pageIndexString=pageIndexNode.text();
		var pageIndex=parseInt(pageIndexString, 10);//当前的页数
		if(pageIndex==1){
			if($("#last").attr("disabled")!="disabled"){
				$("#last").attr("disabled",true);
			}
			$("warning").html("已到达首页");
			return;
		}else{
			$.ajax({
				type:"post",
				url:"getPage",
				dataType:"json",
				cache:false,
				data:{
					"pageIndex":1,
				},
				success:function(data){
						 var dataObj=eval("("+data+")");//讲字符创转换成json格式
					 var tds="<thead><tr><th>编号</th><th>学生姓名</th><th>学院</th><th>专业</th><th>班级</th><th>性别</th><th>邮箱</th><th>操作</th></tr></thead>";
	     	    	  for(var i=0;i<dataObj.length;i++){
	     	    		 tds=tds+"<tr><td>"+(i+1)+"</td><td>"+dataObj[i].suserName+"</td><td>"
	     	    		 +dataObj[i].xyName+"</td><td>"+dataObj[i].majorName+"</td><td>"+dataObj[i].classGrade
	     	    		 +"</td><td>"+dataObj[i].studentSex+"</td><td>"+dataObj[i].email+"</td><td><a href='toModifyStudent?sno="+dataObj[i].sno+"'>修改</a> 删除</td></tr>";
	     	    	  }
	     	    	  if($("#next").attr("disabled")=="disabled"){
	     	    		    $("#next").removeAttr("disabled");
	     	    	  }
	     	    	 $("#showTable").html(tds);//讲td tr加到table上
	     	    	 $("#last").attr("disabled",true);
					 $("#warning").html("已到达首页"); 
					 $("#pageIndex").html(1);
					 
					 $("tr:odd").addClass("showStudentTableOddtr");
					    
					 $("td:odd").addClass("showStudentTableOddtd");
					 
					 $("tr:odd").mouseover(function(){
							$(this).css("background-color","yellow");
						});
						$("tr:odd").mouseout(function(){
							$(this).css("background-color","#99CCFF");
						});
						
						$("tr:even").mouseover(function(){
							$(this).css("background-color","yellow");
						});
						$("tr:even").mouseout(function(){
							$(this).css("background-color","#FFFFFF");
						});
				},
			    error:function(data){
			    	alert(data);
			    },
			});
		}
	});
	
	
	/***
	 * 分页到尾页
	 * @author 聂乐  2013-9-25 nele0716@163.com
	 */
	$("#final").click(function(){
		var pageIndexNode=$("#pageIndex");
		var pageIndexString=pageIndexNode.text();
		var pageIndex=parseInt(pageIndexString, 10);//当前的页数
		
		var pageCountNode=$("#showPageCount");
		var pageCountString=pageCountNode.text();
		var pageCount=parseInt(pageCountString, 10);
		
		if(pageIndex==pageCount){
			if($("#next").attr("disabled")!="disabled"){
				$("#next").attr("disabled",true);
			}
			$("warning").html("已到达首页");
			return;
		}else{
		  $.ajax({
				type:"post",
				url:"getPage",
				dataType:"json",
				cache:false,
				data:{
					"pageIndex":pageCount,
				},
				success:function(data){
						 var dataObj=eval("("+data+")");//讲字符创转换成json格式
					 var tds="<thead><tr><th>编号</th><th>学生姓名</th><th>学院</th><th>专业</th><th>班级</th><th>性别</th><th>邮箱</th><th>操作</th></tr></thead>";
	     	    	  for(var i=0;i<dataObj.length;i++){
	     	    		 tds=tds+"<tr><td>"+(i+1)+"</td><td>"+dataObj[i].suserName+"</td><td>"
	     	    		 +dataObj[i].xyName+"</td><td>"+dataObj[i].majorName+"</td><td>"+dataObj[i].classGrade
	     	    		 +"</td><td>"+dataObj[i].studentSex+"</td><td>"+dataObj[i].email+"</td><td><a href='toModifyStudent?sno="+dataObj[i].sno+"'>修改</a> 删除</td></tr>";
	     	    	  }
	     	    	  if($("#last").attr("disabled")=="disabled"){
	     	    		    $("#last").removeAttr("disabled");
	     	    	  }
	     	    	 $("#showTable").html(tds);//讲td tr加到table上
	     	    	 $("#next").attr("disabled",true);
					 $("#warning").html("已到最后一页"); 
					 $("#pageIndex").html(pageCount);
					 
					 $("tr:odd").addClass("showStudentTableOddtr");
					    
					 $("td:odd").addClass("showStudentTableOddtd");
					 
					 $("tr:odd").mouseover(function(){
							$(this).css("background-color","yellow");
						});
						$("tr:odd").mouseout(function(){
							$(this).css("background-color","#99CCFF");
						});
						
						$("tr:even").mouseover(function(){
							$(this).css("background-color","yellow");
						});
						$("tr:even").mouseout(function(){
							$(this).css("background-color","#FFFFFF");
						});
				},
			    error:function(data){
			    	alert(data);
			    },
			});
		
		}});
	
	
	/***
	 * 到用户指定分页界面
	 * @author 聂乐 2013-9-25 nele0716@163.com
	 */
	$(".pageId").click(function(){
		/**
		 * 取到要转向页数
		 */
		 var pageIndexNode=$(this).children("span").children(".pageIdShow");
		 var pageIndexString=pageIndexNode.text();
		 var pageIndex=parseInt(pageIndexString, 10);
		 //取到总页数
		 var pageCountNode=$("#showPageCount");
	     var pageCountString=pageCountNode.text();
	     var pageCount=parseInt(pageCountString, 10);
	     $("#pageIndex").html(pageIndex);
	     if(pageIndex==1){
				if($("#last").attr("disabled")!="disabled"){
					$("#last").attr("disabled",true);
				}
				if($("#next").attr("disabled")=="disabled"){
					 $("#next").removeAttr("disabled");
				 }
				$("#warning").html("已到达首页");
			 }
	       if(pageIndex==pageCount){
	    	   if($("#next").attr("disabled")!="disabled"){
					$("#next").attr("disabled",true);
				}
	    	   if($("#last").attr("disabled")=="disabled"){
					 $("#last").removeAttr("disabled");
				 }
				$("#warning").html("已到达最后一页");
	       } 
	       else{
	    	   if($("#last").attr("disabled")=="disabled"){
					 $("#last").removeAttr("disabled");
				 }
	    	   if($("#next").attr("disabled")=="disabled"){
					 $("#next").removeAttr("disabled");
				 }
	       }
	       $("#warning").html("");
	       $.ajax({
				type:"post",
				url:"getPage",
				dataType:"json",
				cache:false,
				data:{
					"pageIndex":pageIndex,
				},
				success:function(data){
						 var dataObj=eval("("+data+")");//讲字符创转换成json格式
					 var tds="<thead><tr><th>编号</th><th>学生姓名</th><th>学院</th><th>专业</th><th>班级</th><th>性别</th><th>邮箱</th><th>操作</th></tr></thead>";
	     	    	  for(var i=0;i<dataObj.length;i++){
	     	    		 tds=tds+"<tr><td>"+(i+1)+"</td><td>"+dataObj[i].suserName+"</td><td>"
	     	    		 +dataObj[i].xyName+"</td><td>"+dataObj[i].majorName+"</td><td>"+dataObj[i].classGrade
	     	    		 +"</td><td>"+dataObj[i].studentSex+"</td><td>"+dataObj[i].email+"</td><td><a href='toModifyStudent?sno="+dataObj[i].sno+"'>修改</a> 删除</td></tr>";
	     	    	  }
	     	    	 $("#showTable").html(tds);//讲td tr加到table上
	     	    	 
	     	    	 $("tr:odd").addClass("showStudentTableOddtr");
	     	        
	     	        $("td:odd").addClass("showStudentTableOddtd");
	     	        
	     	       $("tr:odd").mouseover(function(){
	     				$(this).css("background-color","yellow");
	     			});
	     			$("tr:odd").mouseout(function(){
	     				$(this).css("background-color","#99CCFF");
	     			});
	     			
	     			$("tr:even").mouseover(function(){
	     				$(this).css("background-color","yellow");
	     			});
	     			$("tr:even").mouseout(function(){
	     				$(this).css("background-color","#FFFFFF");
	     			});
				},
			    error:function(data){
			    	alert(data);
			    },
			});
	});
	
	$(".allPageId").mouseover(function(){
		var pageIdNode=$(this).children(".pageIdShow");
		   pageIdNode.addClass("mouseover"); 
	        
	     
	});
	
	$(".pageIdShow").mouseout(function(){
		//$(".pageIdShow").removeClass("mouseover"); 
		$(".allPageId").children(".pageIdShow").removeClass("mouseover"); 
		$(".pageIdShow").addClass("pageIdShow"); 
	});
});