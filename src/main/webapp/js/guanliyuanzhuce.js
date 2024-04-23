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
	
	

$(function(){
							$('.btn').click(function(){
								var nikename=$('.inp').eq(0).val();
								var account=$('.inp').eq(1).val();
								var password=$('.inp').eq(2).val();
								
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
	

	



})


