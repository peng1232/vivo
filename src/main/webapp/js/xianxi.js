$(function() {

	$('.sku-module_item').on('click', function() {
		$(this).siblings().removeClass("sku_checked");
		$(this).addClass('sku_checked');
		shua()
	})
	setTimeout(function() {
		shua();
	}, 100)

	//左右
	$(".opration").on("mousedown", function() {
		$(this).css('borderColor','#eaeaea')
		$(this).find('svg path').css("fill",'#eaeaea')
	});
	$(".opration").on("mouseup", function() {
		$(this).css('borderColor','#b3b3b3')
		$(this).find('svg path').css("fill",'#b3b3b3')
	});
	//右点击事件
	var count = 0;
	var lian = 91;
	$(".op_right").on("click", function() {
		var sum = $('.small_item').length;
		if(sum>4&&(sum-4)>count){
			count++;
			var p = count*lian;
			$('.img_samll').css('left','-'+p+'px')
		}
		
	});
	//左点击事件
	$(".op_left").on("click", function() {
		if(count>0){
			count--;
			var p = count*lian;
			$('.img_samll').css('left','-'+p+'px')
		}
	});
	
	//小图标的伪类
	$('.small_item').on('mouseover',function(){
		var that = $(this);
		$('.big_item').removeClass('xianshi');
		$('.big_item').eq(that.index()).addClass('xianshi')
	})
})
var yuan = [];
function shua() {
	//设置标题
	$('.name').text($('.tit').val() + " " + $('.sku_checked').eq(0).text() + " " + $('.sku_checked').eq(1).text())
	//存规格值id
	var xin = [];
	$('.sku_checked').each(function() {
		xin.push($(this).attr('productid'));
	});
	if (!arraysEqual(yuan, xin)) {
		//发送请求
		var jsonData = JSON.stringify(xin);
		$.getJSON("SKUServlet", { data: jsonData }, function(response) {
			$('.sale-price').text("￥" + response.price.price + ".00");
			$('.sale-price').attr("price_id", response.price.id);
			console.log(response)
		});

		console.log("不一样" + xin);
		yuan = xin;
	}

}
//比较前后规格有没有变化
function arraysEqual(arr1, arr2) {
	if (arr1.length !== arr2.length) {
		return false;
	}
	for (var i = 0; i < arr1.length; i++) {
		if (arr1[i] !== arr2[i]) {
			return false;
		}
	}
	return true;
}