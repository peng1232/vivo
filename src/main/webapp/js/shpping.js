$(function() {
	//计算金额
	var ind = 0;
	$('.cart_item_info').each(function() {
		var sum = parseInt($(this).find('.prod-num').text());
		var value = parseFloat($(this).find('.price_col').text())
		$('.total_price').eq(ind).text((sum * value).toFixed(2))
		ind++;
	});

	//全选事件
	$('.check_sum').click(function() {
		var that = $(this);
		if (that.is(':checked')) {
			// 复选框被选中时执行的代码
			$('.check_item').prop('checked', 'checked')
			$('.check_sum').prop('checked', 'checked')
		} else {
			// 复选框未被选中时执行的代码
			$('.check_item').prop('checked', '')
			$('.check_sum').prop('checked', '')
		}
		updatePrice();
	})

	//选项的点击事件
	$('.check_item').click(function() {
		var that = $(this);
		if ($('.check_item[type="checkbox"]:not(:checked)').length === 0) {
			$('.check_sum').prop('checked', 'checked')
		} else {
			$('.check_sum').prop('checked', '')
		}
		updatePrice();
	})
	var user_id = $('.user').val();
	//数量-
	$('.reduce-num').click(function() {
		var that = $(this);
		var sum = $(this).siblings('.prod-num').text();
		var shopping_id = $(this).siblings('.prod-num').attr('shopping_id');
		sum--;
		if (sum > 0) {
			//发送请求user_id='+user_id+'&shopping_id='+shopping_id+'&sum='+sum
			$.getJSON('ShoppingUpdateNumberServlet', {
				'user_id': user_id,
				'shopping_id': shopping_id,
				'sum': sum
			}, function(request) {
				if (request.zhi != null) {
					that.siblings('.prod-num').text(sum);
					var price = that.parent().siblings('.price_col').text()
					that.parent().siblings('.total_price').text((price * sum).toFixed(2))
					that.parent().parent().find('.check_item').attr('sku',request.zhi)
					updatePrice();
				} else {
					$('.setting').text("修改失败！")
					kai();
				}
			})

		} else {
			$('.setting').text("温馨提示：数量不能少于零！")
			kai();
		}
	})
	//数量+
	$('.add-num').click(function() {
		var that = $(this);
		var sum = parseInt($(this).siblings('.prod-num').text());
		var max = parseInt($(this).siblings('.prod-num').attr('max'));
		var shopping_id = $(this).siblings('.prod-num').attr('shopping_id');
		sum++;
		if (sum <= max) {
			//发送请求
			$.getJSON('ShoppingUpdateNumberServlet', {
				'user_id': user_id,
				'shopping_id': shopping_id,
				'sum': sum
			}, function(request) {
				if (request.zhi!= null) {
					that.siblings('.prod-num').text(sum);
					var price = that.parent().siblings('.price_col').text()
					that.parent().siblings('.total_price').text((price * sum).toFixed(2))
					that.parent().parent().find('.check_item').attr('sku',request.zhi)
					updatePrice();
				} else {
					$('.setting').text("修改失败！")
					kai();
				}
			})

			/*	$(this).siblings('.prod-num').text(sum);
				var price =  $(this).parent().siblings('.price_col').text()
				$(this).parent().siblings('.total_price').text((price*sum).toFixed(2))
				updatePrice();*/
		} else {
			$('.setting').text("温馨提示：购物车商品数量超限")
			kai();
		}
	})

	//修改对应的金额和数量
	function updatePrice() {
		//数量
		$('#number').text($('.check_item[type="checkbox"]:checked').length);
		//金额
		var sum = 0.0;
		$('.check_item[type="checkbox"]:checked').each(function() {
			//单价
			var value = parseFloat($(this).parent().parent().parent().find(".column").text())
			sum += (value); // 进行数学运算

		})
		$("#jin").text(sum.toFixed(2));
	}


	//弹窗点击时间
	$('.message_box_footer .guanque,.message_box_footer #xuxiao').click(function() {
		guanbi();
	})
	$('.zhe').click(function() {
		guanbi();
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
		$('#xuxiao').css('display', 'none')
		$('.delque').css('display', 'none')
		$('.guanque').css('display', 'inline-block')
		$('.message_box_center p').css('color', '#000')
	}

	//删除购物车
	var gou_id;
	var delbtn;
	var jsonData;
	$('.del').on('click', function() {
		gou_id = $(this).attr('shopping_id')
		delbtn = $(this)
		$('.setting').text("确定将该商品从购物车中删除吗？")
		$('#xuxiao').css('display', 'inline-block')
		$('.delque').css('display', 'inline-block')
		$('.guanque').css('display', 'none')
		$('.message_box_center p').css('color', 'red')
		kai();
		var shop_id = [];
		shop_id.push(gou_id);
		jsonData = JSON.stringify(shop_id);
	})

	//批量删除
	$('.delshop').click(function() {
		$('.setting').text("确定将该商品从购物车中删除吗？")
		$('#xuxiao').css('display', 'inline-block')
		$('.delque').css('display', 'inline-block')
		$('.guanque').css('display', 'none')
		$('.message_box_center p').css('color', 'red')
		kai();
		var shop_id = [];
		$('.check_item:checked').each(function() {
			var checkedCheckbox = $(this);
			var shoppingId = checkedCheckbox.attr('shopping_id');
			shop_id.push(shoppingId)
		});
		jsonData = JSON.stringify(shop_id);
	})

	//确认删除
	$('.delque').click(function() {
		$.getJSON('ShoppingUpdateStateServlet', {
			'user_id': user_id,
			'shopping_id': jsonData,
			'state': 2
		}, function(request) {
			if (request.shopping_count > 0) {
				guanbi();
				delbtn.closest('.shop_cart_item').remove();
				$('.gou').html('购物车(' + request.shopping_count + ')');
				updatePrice();
			} else {
				location.reload();
			}
		})
	})
	//结算
	$('#jiesuan').click(function() {
		var proid =[];
		var userid = $(".check_item").attr('user_id');
		var sku = [];
		$(".check_item:checked").each(function() {
			var skuval = $(this).attr('sku');
			 skuval=skuval.replace(/\\/g, '')

			// 替换后的字符串数组
			sku.push(skuval)
			var a = $(this).attr('product_id');
			 a=a.replace(/\\/g, '')
			proid.push({
				'product_id':a
			})
		});
		var jsonData = JSON.stringify(sku);
		var product_id = JSON.stringify(proid);
		console.log(proid)
		var url = 'SelectSKUProductServlet?user_id=' + userid + '&product_id=' + encodeURIComponent(product_id) + '&sku=' + encodeURIComponent(jsonData);
		location.href = url;
	})

})