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
								var nikename=$('.inp').eq(0).val();
								var account=$('inp').eq(1).val();
								var password=$('inp').eq(2).val();
								
								alert(nikename);
								alert(account);
								alert(password);
								$.getJSON('guanliyuanzhuce',{
									'nikename':nikename,
									'account':account,
									'password':password
								})
									
							})	
							
							
						})
						
