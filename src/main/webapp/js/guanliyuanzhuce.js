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
	
	


	//注册判断
	$('#zhuce').click(function() {
		var input = $('.inp');
		if (isValidPhoneNumber(input.eq(0).val())) {
			
				if (input.eq(1).val().length >= 6) {
					if (input.eq(2).val()==input.eq(1).val()) {
						
							//注册
							var phone = input.eq(0).val();
							var mi = input.eq(2).val();
							console.log(phone+mi)
							$("#sub").submit();
					
					} else {
						$('.quemi').html('两次密码不一致')
					}
				} else {
					$('.mi').html('密码格式错误')
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




})

//判断手机号
function isValidPhoneNumber(phoneNumber) {
	const pattern = /^1[3-9]\d{9}$/;
	return pattern.test(phoneNumber);
}
