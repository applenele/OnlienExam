

$(document).ready(function(){

	  $(".menu li:first-child").addClass("header_show_current");
	  $("div.content").find("div.layout:not(:first-child)").hide();
	 $(".menu li").click(function(){
		 
	         var c = $(".menu li");
	         var index = c.index(this);
	         $(".menu li:not(:eq("+index+"))").siblings().removeClass("header_show_current");
	         $(".menu li:eq("+index+")").show().addClass("header_show_current").siblings().removeClass("header_show_current");
	         show(index);
	     });
	
	     
	function show(num){
		        $("div.content").find("div.layout:not(:eq("+num+"))").siblings().hide();
		        $("div.content").find("div.layout:eq("+num+")").show("slow");
		        if(num==8){
		        	
		        
		         var current_div_node=$("div.content").find("div.layout:eq("+num+")");
		         
		          current_div_node.load("personal_infomation.jsp");
		        }
		        /*$("div.content").find("div.layout:eq("+num+")").show("slow",function(){
		        	 if(num==9){
		        		 $("div.content").find("div.layout:eq("+num+")").load("personal_infomation.jsp");
		        	 }
		        });*/
	    	    //.addClass("current").siblings().removeClass("current");
	    	 };
	   
	  $("#loginout").click(function(){
		  
		  $("#main").load("user_logout.jsp");
		  
	  });  	 
});