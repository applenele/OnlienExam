
/*$(document).ready(function(){
	
   $("#searchOk").click(function(){
	   var suserNameNode=$("#suserName");
	   var xyNode=$("#xy");
	   var majorNode=$("#major");
	   var classNode=$("#class");
	   
	   var suserName=suserNameNode.val();
	   var xyId=xyNode.val();
	   var majorId=majorNode.val();
	   var classId=classNode.val();
	   
	   
	   $.post("searchStudent", 
			  { 
		     "studentOfsearchInfo.suerName":suserName,
	         "studentOfsearchInfo.xyId":xyId,
	         "studentOfsearchInfo.suerName":majorId,
	         "studentOfsearchInfo.suerName":classId,
			   } ); 


	   /* $.ajax({
			type:"post",
	        url:"searchStudent",
			dataType:"json",
			cache:false,
		data:{
			 "studentOfsearchInfo.suerName":suserName,
	         "studentOfsearchInfo.xyId":xyId,
	         "studentOfsearchInfo.suerName":majorId,
	         "studentOfsearchInfo.suerName":classId,
		},
		success:function(data){
			window.location.href="showResultOfSearch.jsp";
		},
		error:function(data){
			alert("错误");
		},
	});
 });
});*/