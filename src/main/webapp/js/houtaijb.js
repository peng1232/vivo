$(function(){
	$('.body_top_left').click(function(){
					$('.body_left').css('transition','0.5s');
					$('.body_right').css('transition','0.5s');
					var svg =  $(this);
					var val = svg.attr('val');
					if(val==0){
						//收
						svg.attr('val','1');
						svg.css('transform','rotate(180deg)')
						$('.body_left').css('width','0.1%');
						$('.body_right').css('width','99.9%');
						
					}else{
						//展
						svg.attr('val','0');
						svg.css('transform','rotate(0deg)')
						$('.body_left').css('width','15%');
						$('.body_right').css('width','85%');
						
					}
				})
});

