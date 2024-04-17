$(function() {
	$('.new').click(function() {
		kai();
		$('.mess_title').text('新建收货地址')
	})
	//弹窗点击时间
	$('.message_box_footer button').click(function() {
		
	})
	$('.guan').click(function() {
		guanbi();
	})
	//开启弹窗
	function kai() {
		$('body').css('overflow-x', "hidden").css("overflow-y", 'hidden')
		$('.message').css('display', 'block');
		$(".zhe").animate({
			opacity: 0.6
		}, 100)
		$('.message_box').css('transform', 'scale(1) translateY(0%)');
	}

	//关闭弹窗
	function guanbi() {
		$('body').css('overflow-x', "auto").css("overflow-y", 'auto')
		$(".zhe").animate({
			opacity: 0
		}, 100)
		$('.message_box').css('transform', 'scale(0) translateY(-100%)');
		setTimeout(function() {
			$('.message').css('display', 'none');
		}, 300)
		$('.enter').val('')
		$('.tishi').css('display','none').attr('flag','true')
		$('.item select').find('option:eq(0)').prop('selected', true);
		$('.item select').css('color','#ccc')
	}
	
	
	//失去焦点事件
	$('.enter').blur(function(){
		if($(this).val().trim().length<=0){
			$(this).parent().find('.tishi').css('display','block').attr('flag','false')
		}else{
			$(this).parent().find('.tishi').css('display','none').attr('flag','true')
		}
	})
	$('.enter').eq(1).blur(function(){
		if(isValidPhoneNumber($(this).val())){
			$(this).parent().find('.tishi').css('display','none').attr('flag','true')
		}else{
			$(this).parent().find('.tishi').css('display','block').attr('flag','false')
		}
	})
	$('.item select').change(function(){
		$(this).css('color','#000')
		var flag = true;
		$('.item select').each(function(){
			var selectedText = $(this).find("option:selected").text();
			if(selectedText=='请选择'){
				flag= false;
			}
		})
		if(!flag){
			$(this).parent().find('.tishi').css('display','block').attr('flag','false')
		}else{
			$(this).parent().find('.tishi').css('display','none').attr('flag','true')
		}
	})
	$('#baocun').click(function(){
		$('.enter').trigger("blur")
		var flag = true;
		$('.item select').each(function(){
			var selectedText = $(this).find("option:selected").text();
			if(selectedText=='请选择'){
				flag= false;
			}
		})
		if(!flag){
			$('.item select').parent().find('.tishi').css('display','block').attr('flag','false')
		}else{
			$('.item select').parent().find('.tishi').css('display','none').attr('flag','true')
		}
		var pan = true;
		//判断
		$('.tishi').each(function(){
			var zhi = $(this).attr('flag')
			if(zhi=='false'){
				pan = false;
			}
		})
		if(pan){
			//保存地址 发送请求
			var user_id =$('.user').val();
			var name = $('.enter').eq(0).val();
			var phone = $('.enter').eq(1).val();
			var shou = $('#province').find("option:selected").text()+" "+$('#city').find("option:selected").text()+" "+$('#district').find("option:selected").text();
			var xianxi = $('.enter').eq(2).val();
			var mou=  $('.mou').prop('checked')
			$.getJSON('AddressInsertServlet',{
				'user_id':user_id,
				'name':name,
				'phone':phone,
				'shou':shou,
				'xianxi':xianxi,
				'mou':mou
			},function(request){
				guanbi();
				//调用查看收货地址
				
			});
		}
	})
})
function isValidPhoneNumber(phoneNumber) {
  const pattern = /^1[3-9]\d{9}$/;
  return pattern.test(phoneNumber);
}