$(function() {
	$('.biyan').click(function() {
		var input = $('.inp').eq($(this).attr("val")); // 根据点击的图标选择对应的输入框
		if (input.attr('type') == 'password') {
			input.attr('type', 'text');
			$(this).find("svg").eq(0).css('display', 'none');
			$(this).find("svg").eq(1).css('display', 'block');
		} else {
			input.attr('type', 'password');
			$(this).find("svg").eq(0).css('display', 'block');
			$(this).find("svg").eq(1).css('display', 'none');
		}
	})
	var yzm;
	//获取验证码
	$('#huoqu').click(function() {
		var input = $('.inp');
		if (isValidPhoneNumber(input.eq(0).val())) {
			//发送请求
			$.getJSON("../login/yzmServler?phone=" + input.eq(0).val(), function(response) {
				// 把验证码存起来
				yzm = response;
			});
			//发送验证码
			dao(60, $(this))
		} else {
			$('.shou').html('请输入正确的手机号')
		}

	})
	//倒计时
	function dao(value, e) {
		e.css('color', '#ccc')
		e.text('重新获取(' + value + ')s');
		e.css('pointer-events', 'none')
		var stop = setInterval(function() {
			value--;
			e.text('重新获取(' + value + ')s');
			if (value == -1) {
				clearInterval(stop)
				e.css('pointer-events', 'initial')
				e.text('获取验证码');
				e.css('color', '#456fff')
			}
		}, 1000);
	}


	//注册判断
	$('#xiu').click(function() {
		var input = $('.inp');
		if (isValidPhoneNumber(input.eq(0).val())) {
			var phone = $('.inp').eq(0).val();
			var user_id = $('.user_id').val();

			
			if (input.eq(1).val() == 'yzm') {
					
				var pho = input.eq(2).val();
						
				$.getJSON('yzmxgmmServlet',{'user_id':user_id,'password':pho},function(){
					 
					 $('.setting').text('修改成功')
				})
				 		
			} else {
				$('.yang').html('请输入正确的验证码')
			}
		} else {
			$('.shou').html('请输入正确的手机号')
		}

	})




	$('.inp').eq(0).focus(function() {
		$('.shou').html('')
	})
	$('.inp').eq(1).focus(function() {
		$('.yang').html('')
	})
	$('.inp').eq(2).focus(function() {
		$('.mi').html('')
	})
	$('.inp').eq(3).focus(function() {
		$('.quemi').html('')
	})



})

//判断手机号
function isValidPhoneNumber(phoneNumber) {
	const pattern = /^1[3-9]\d{9}$/;
	return pattern.test(phoneNumber);
}
