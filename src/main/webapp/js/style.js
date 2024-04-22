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
						
						
