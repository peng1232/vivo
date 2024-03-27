$(function(){
	//全选事件
	$('.check_sum').click(function(){
		var that = $(this);
		if (that.is(':checked')) {
		    // 复选框被选中时执行的代码
			$('.check_item').prop('checked','checked')
			$('.check_sum').prop('checked','checked')
		} else {
		    // 复选框未被选中时执行的代码
			$('.check_item').prop('checked','')
			$('.check_sum').prop('checked','')
		}
		updatePrice();
	})
	
	//选项的点击事件
	$('.check_item').click(function(){
		var that = $(this);
		if ($('.check_item[type="checkbox"]:not(:checked)').length === 0) {
		    $('.check_sum').prop('checked','checked')
		} else {
			$('.check_sum').prop('checked','')
		}
		updatePrice();
	})
	
	//数量-
	$('.reduce-num').click(function(){
		var sum = $(this).siblings('.prod-num').text();
		if(sum>1){
			sum--;
			$(this).siblings('.prod-num').text(sum);
			var price =  $(this).parent().siblings('.price_col').text()
			$(this).parent().siblings('.total_price').text((price*sum).toFixed(2))
			updatePrice();
		}else{
			alert("数量不能少于一")
		}
	})
	//数量+
	$('.add-num').click(function(){
		var sum = $(this).siblings('.prod-num').text();
		if(true){
			sum++;
			$(this).siblings('.prod-num').text(sum);
			var price =  $(this).parent().siblings('.price_col').text()
			$(this).parent().siblings('.total_price').text((price*sum).toFixed(2))
			updatePrice();
		}else{
			alert("")
		}
	})
	
	//修改对应的金额和数量
	function updatePrice(){
		//数量
		$('#number').text($('.check_item[type="checkbox"]:checked').length);
		//金额
		var sum=0.0;
		$('.check_item[type="checkbox"]:checked').each(function(){
			//单价
			var value= parseFloat($(this).parent().parent().parent().find(".column").text())
			sum += (value); // 进行数学运算
			
		})
		$("#jin").text(sum.toFixed(2));
	}
})