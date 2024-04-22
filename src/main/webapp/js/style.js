$(".body_left_list >li >label").on('click',function () {
    $gao = $(this).parent('li').css('max-height');
    if($gao == '1500px'){
        $(this).parent('li').animate({'max-height':'40px'});
        $(this).children('i').css({
            'transform':'rotate(-90deg)'
        })
    }else{
        $(this).parent('li').animate({'max-height':'1500px'});
        $(this).children('i').css({
            'transform':'rotate(0)'
        })
    }
});

$(".body_left_list >li >ul >li >ul >li").on({
    mouseover: function () {
        var juli = $(this).offset().top;
        $(this).children('ul').css({
            'padding-top':juli
        })
    },
    mouseout: function () {
        $(".link").hide();
    }
});
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

				$(function(){
							$('.add').click(function(){
								kai();
								alert("88");
								
							})
							//弹窗点击时间
							$('.message_box_footer .btn1').click(function(){
								var nikename=$('#ip0').val();
								var account=$('#ip1').val();
								var password=$('#ip2').val();
								
								alert(nikename);
								alert(account);
								alert(password);
								$.getJSON('guanliyuanzhuce',{
									'nikename':nikename,
									'account':account,
									'password':password
								},function(){
									guanbi();
								})
									
							})
					$('.zhe').click(function(){
						guanbi();
					})
					$('.guan').click(function(){
						guanbi();
					})
					$('.btn2').click(function(){
						guanbi();
					})
							//开启弹窗
					function kai(){
						$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
						$('.message').css('display','block');
						$(".zhe").animate({
							opacity: 0.6
						},100)
						$('.message_box').css('transform','scale(1) translateY(0%)');
					}
					
					//关闭弹窗
					function guanbi(){
						$('body').css('overflow-x',"auto").css("overflow-y",'auto')
						$(".zhe").animate({
							opacity: 0
						},100)
						$('.message_box').css('transform','scale(0) translateY(-100%)');
						setTimeout(function(){
							$('.message').css('display','none');
						},300)
						
					}	
			})
						
				$(function(){
							$('#editBtn').click(function(){
								kai1();
								alert("88");
								
							})
							//弹窗点击时间
							$('.message_box_footer1 .btn3').click(function(){
								var id=$('#inp1').val();
								var password=$('#inp2').val();
								
								
								
								alert(id);
								alert(password);
								$.getJSON('glyxiugaiServlet',{
									'id':id,
									'password':password
								},function(){
									guanbi1();
								})
									
							})
					$('.zhe1').click(function(){
						guanbi1();
					})
					$('.guan1').click(function(){
						guanbi1();
					})
					$('.btn4').click(function(){
						guanbi1();
					})
							//开启弹窗
					function kai1(){
						$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
						$('.message1').css('display','block');
						$(".zhe1").animate({
							opacity: 0.6
						},100)
						$('.message_box1').css('transform','scale(1) translateY(0%)');
					}
					
					//关闭弹窗
					function guanbi1(){
						$('body').css('overflow-x',"auto").css("overflow-y",'auto')
						$(".zhe1").animate({
							opacity: 0
						},100)
						$('.message_box1').css('transform','scale(0) translateY(-100%)');
						setTimeout(function(){
							$('.message1').css('display','none');
						},300)
						
					}	
			})
						
