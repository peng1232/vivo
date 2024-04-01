$(function(){
	$('.avtive').click(function(){
		$(this).addClass('dian');
		$(this).siblings().removeClass('dian')
	})
	$('.avtive').eq(0).click(function(){
		$('.an_xian').css('left','71px').attr('value','0')
		$('.info_phone').css('display','block');
		$('.info_name').css('display','none');
		
	})
	$('.avtive').eq(1).click(function(){
		$('.an_xian').css('left','252px').attr('value','1')
		$('.info_phone').css('display','none');
		$('.info_name').css('display','block');
	})
	var yzm;
	
	//获取验证码
	$('#huoqu').click(function(){
		var input = $('.inp');
		if(isValidPhoneNumber(input.eq(0).val())){
			//发送请求
			 $.getJSON("yzmServler?phone=" + input.eq(0).val(), function(response) {
    			// 把验证码存起来
    			yzm =response;
			});
			//发送验证码
			dao(60,$(this))
		}else{
			$('.shou').html('请输入正确的手机号')
		}
		
	})
	
	//登录判断
	$('#denglu').click(function(){
		var input = $('.inp');
		var state = $('.an_xian').attr('value');
		if(state==0){
			if(isValidPhoneNumber(input.eq(0).val())){
				if(input.eq(1).val()==yzm){
					//登录进去
					alert("登陆成功")
				}else{
					$('.yang').html('请输入正确的验证码')
				}
			}else{
				$('.shou').html('请输入正确的手机号')
			}
		}else{
			if(isValidPhoneNumber(input.eq(2).val())){
				//需要判断改账号是否存在
				if(input.eq(3).val()==yzm){
					//登录进去
				}else{
					$('.mi').html('请输入正确的密码')
				}
			}else{
				$('.ji').html('请输入正确的手机号')
			}
		}
	})
	
	
	
	
	$('.inp').eq(0).focus(function(){
		$('.shou').html('')
	})
	$('.inp').eq(1).focus(function(){
		$('.yang').html('')
	})
	$('.inp').eq(2).focus(function(){
		$('.ji').html('')
	})
	$('.inp').eq(3).focus(function(){
		$('.mi').html('')
	})
	
	
	//倒计时
	function dao(value,e){
		e.css('color','#ccc')
		e.text('重新获取('+value+')s');
		e.css('pointer-events','none')
		var stop = setInterval(function(){
			value--;
			e.text('重新获取('+value+')s');
			if(value==-1){
				clearInterval(stop)
				e.css('pointer-events','initial')
				e.text('获取验证码');
				e.css('color','#456fff')
			}
		},1000);
	}
	
	$('#biyan').click(function(){
		var input = $('.inp').eq(3);
		if(input.attr('type')=='password'){
			$('.inp').eq(3).attr('type', 'text');
			$('#biyan svg').eq(0).css('display','none');
			$('#biyan svg').eq(1).css('display','block');
		}else{
			$('.inp').eq(3).attr('type', 'password');
			$('#biyan svg').eq(0).css('display','block');
			$('#biyan svg').eq(1).css('display','none');
			
		}
	})
	
	
	//跳转注册页面
	$('#zhuce').click(function(){
		window.location.href="zhuce.jsp"
	})
	
	
})
//判断手机号
function isValidPhoneNumber(phoneNumber) {
  const pattern = /^1[3-9]\d{9}$/;
  return pattern.test(phoneNumber);
}
