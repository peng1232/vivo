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
							$('#addBtn').click(function(){
								kai2();
								
								
							})
							//弹窗点击时间
							$('.message_box_footer2 .btn5').click(function(){
								var phone=$('#inp3').val();
								var user_password=$('#inp4').val();
								
								
								$.getJSON('Userzhuce',{
									'phone':phone,
									'user_password':user_password
								},function(){
									guanbi2();
									location.href = "users.jsp";
								})
									
							})
					$('.zhe2').click(function(){
						guanbi2();
					})
					$('.guan2').click(function(){
						guanbi2();
					})
					$('.btn6').click(function(){
						guanbi2();
					})
							//开启弹窗
					function kai2(){
						$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
						$('.message2').css('display','block');
						$(".zhe2").animate({
							opacity: 0.6
						},100)
						$('.message_box2').css('transform','scale(1) translateY(0%)');
					}
					
					//关闭弹窗
					function guanbi2(){
						$('body').css('overflow-x',"auto").css("overflow-y",'auto')
						$(".zhe2").animate({
							opacity: 0
						},100)
						$('.message_box2').css('transform','scale(0) translateY(-100%)');
						setTimeout(function(){
							$('.message2').css('display','none');
						},300)
						
					}	
			})
						
				
			$(function(){
							var id;
							$('.zhuantai').click(function(){
								kai();
								id= $(this).attr('admin');
							})
							//弹窗点击时间
							$('.message_box_footer .btn1').click(function(){
								var user_nickname=$('#inp1').val();
								var phone=$('#inp2').val();
								var user_password=$('#inpt0').val();
		
								
								
								
								$.getJSON('Userxiugai',{
									'id':id,
									'user_nickname':user_nickname,
									'phone':phone,
									'user_password':user_password,
								},function(){
									guanbi();
									location.href = "users.jsp";
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
					
					
					$(function(){
						var id;
							$('.shujuxiugai').click(function(){
								kai3();
								id= $(this).attr('admin');
								
							})
							//弹窗点击时间
							$('.message_box_footer3 .btn7').click(function(){
								var state=$('.inp6').val();
								$.getJSON('UserDeleteServlet',{
									'id':id,
									'state':state
								},function(){
									guanbi3();
									location.href = "users.jsp";
								})
									
							})
					$('.zhe3').click(function(){
						guanbi3();
					})
					$('.guan3').click(function(){
						guanbi3();
					})
					$('.btn8').click(function(){
						guanbi3();
					})
							//开启弹窗
					function kai3(){
						$('body').css('overflow-x',"hidden").css("overflow-y",'hidden')
						$('.message3').css('display','block');
						$(".zhe3").animate({
							opacity: 0.6
						},100)
						$('.message_box3').css('transform','scale(1) translateY(0%)');
					}
					
					//关闭弹窗
					function guanbi3(){
						$('body').css('overflow-x',"auto").css("overflow-y",'auto')
						$(".zhe3").animate({
							opacity: 0
						},100)
						$('.message_box3').css('transform','scale(0) translateY(-100%)');
						setTimeout(function(){
							$('.message3').css('display','none'); //33333
						},300)
						
					}	
							$('.btn7').click(function(){
								var state=$(".inp6").val();
								if(state=="All"){
									location.href = "UserServlet";
								}
								
							})
			
			})		
			// 获取所有class为zhuantai的按钮
const buttons = document.querySelectorAll('.zhuantai');

// 绑定点击事件
buttons.forEach(button => {
  button.addEventListener('click', function() {
    // 获取按钮所在行的表格
    const row = this.closest('tr');
    
    // 获取该行表格的五个参数
    
    const param2 = row.cells[1].innerText;
    const param3 = row.cells[2].innerText;
    const param4 = row.cells[3].innerText;
    
    // 显示在相应的输入框内
    
    document.getElementById('inp1').value = param2;
    document.getElementById('inp2').value = param3;
    document.getElementById('inpt0').value = param4;
  });
});				
})