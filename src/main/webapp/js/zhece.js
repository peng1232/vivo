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
			$.getJSON("yzmServler?phone=" + input.eq(0).val(), function(response) {
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


	
	function dong() {
		$('.xieyi').css('left', '10px')
		setTimeout(function() {
			$('.xieyi').stop().css('left', '-10px')
		}, 100);
		setTimeout(function() {
			$('.xieyi').stop().css('left', '10px')
		}, 200);
		setTimeout(function() {
			$('.xieyi').stop().css('left', '-10px')
		}, 300);
		setTimeout(function() {
			$('.xieyi').stop().css('left', '0px')
		}, 400);
	}


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


