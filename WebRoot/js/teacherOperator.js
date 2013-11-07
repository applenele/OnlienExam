

$(document).ready(function(){
		/**
		 * 教师管理界面左侧导航栏的效果
		 * @author 聂乐 2013-9-22 nele0716@163
		 */
		$('.box h1:first').addClass('active');
		
		$('.box p:not(:first)').hide();
		
		
		$('.box h1').hover(function(){
			
		$(this).addClass('hover');
		},function(){

		$(this).removeClass('hover');	

			});
			
		$('.box h1').click(function(){
			
			$(this).next('p').slideToggle()
			
					.siblings('p').slideUp();	
			
			$(this).toggleClass('active')
			
					.siblings('h1').removeClass('active');
					});
	});