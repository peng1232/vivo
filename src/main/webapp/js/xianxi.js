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
		$(this).css('borderColor', '#eaeaea')
		$(this).find('svg path').css("fill", '#eaeaea')
	});
	$(".opration").on("mouseup", function() {
		$(this).css('borderColor', '#b3b3b3')
		$(this).find('svg path').css("fill", '#b3b3b3')
	});
	//右点击事件
	var count = 0;
	var lian = 91;
	$(".op_right").on("click", function() {
		var sum = $('.small_item').length;
		if (sum > 4 && (sum - 4) > count) {
			count++;
			var p = count * lian;
			$('.img_samll').css('left', '-' + p + 'px')
		}

	});
	//左点击事件
	$(".op_left").on("click", function() {
		if (count > 0) {
			count--;
			var p = count * lian;
			$('.img_samll').css('left', '-' + p + 'px')
		}
	});

	// 将事件绑定到父元素上
	$('.img_small').on('mouseover', '.small_item', function() {
	    var that = $(this);
	    $('.big_item').removeClass('xianshi');
	    $('.big_item').eq(that.index()).addClass('xianshi');
	});
	
	//数量的加减 减
	$(".num_left").on("click", function() {
		var sum = $(".number").text();
		if(parseInt(sum)>1){
			sum--;
		}
		$(".number").text(sum)
		info();
	});
	//加
	$(".num_rigth").on("click", function() {
		var sum = $(".number").text();
		var max = $('.limit').val();
		if(sum<max){
			sum++;
		}else{
			dong();
		}
		$(".number").text(sum);
		info();
	});
	
	//添加收藏，取消收藏
	$('.shouc').click(function(){
		var proid = $(".name").attr('pro');
		var userid = $(".user_id").val();
		var skuvalue = $('.shousku').attr('sku');
		if(userid.trim().length>0){
			//已登录
			if($(this).attr('check')=='true'){
				//取消
				$(this).attr('check','false');
				$(this).find('path').css('fill','#acacac')
			}else{
				//收藏
				$(this).attr('check','true');
				$(this).find('path').css('fill','#f51919')
			}
			var flag = ($(this).attr('check'));//true收藏 false no
			//发送请求
			$.getJSON('CollectionServlet',{'user_id':userid,'product_id':proid,'sku':skuvalue,'flag':flag},function(request){
				$('.text').text("收藏商品（"+request.queryCollection+"人收藏）")
			});
		}else{
			//未登录
			location.href = '../login/login.jsp'
		}
	})
})

//设置已选择内容,与价格
function info(){
	$('.info').text('已选：'+$('.sku_checked').eq(0).text() + " " + $('.sku_checked').eq(1).text()+" "+$(".number").text()+"件")
	$('.price').text('￥'+(parseInt($(".number").text())*$(".sale-price").attr('price')))
}
	
	
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
		var proid = $(".name").attr('pro');
		var userid = $(".user_id").val();
		var skuvalue = $('.shousku').attr('sku');
		$.getJSON("SKUServlet", { data: jsonData, proid: proid }, function(response) {
			$('.sale-price').text("￥" + response.price.price + ".00");
			$('.sale-price').attr("price_id", response.price.id);
			$('.sale-price').attr("price", response.price.price);
			//设置价格
			info();
			console.log(response.url_image)
			//创建图片
			$(".img_list_big").empty();
			$(".img_samll").empty();
			for (var i = 0; i < response.url_image.length; i++) {
				// 添加商品图片
				var li = $('<li class="big_item"></li>');
				var img = $('<img />', { src: "../../img/product/" + response.url_image[i] });
				li.append(img);
				if (i == 0) {
					li.addClass('xianshi')
				}
				$('.img_list_big').append(li);
				//添加商品小图片
				var li2 = $('<li class="small_item"></li>');
				var img2 = $('<img />', { src: "../../img/product/" + response.url_image[i] });
				li2.append(img2);
				$('.img_samll').append(li2);
			}
			//默认的
			var li = $('<li class="big_item"></li>');
			var img = $('<img />', { src: "../../img/product/gou.png" });
			li.append(img);
			if (i == 0) {
				li.addClass('xianshi')
			}
			$('.img_list_big').append(li);
			//添加商品小图片
			var li2 = $('<li class="small_item"></li>');
			var img2 = $('<img />', { src: "../../img/product/gou.png" });
			li2.append(img2);
			$('.img_samll').append(li2);
			console.log(response)
			
			
			//存储对应的sku
			var sku='{"sku_price":'+response.price.id+',"pageType":'+$('.sku_checked').eq(0).attr('productid')+',"color":'+$('.sku_checked').eq(1).attr('productid')/*+',"number":'+$('.number').text()*/+'}'
			$('.shousku').attr('sku',sku)
		
			//查看是否是收藏	
			$.getJSON('IsShouServlet',{'user_id':userid,'product_id':proid,'sku':sku},function(request){
				console.log(request.collection)
				if(request.collection){
					$('.shouc').attr('check','true');
					$('.shouc').find('path').css('fill','#f51919')
				}else{
					$('.shouc').attr('check','false');
					$('.shouc').find('path').css('fill','#acacac')
				}
			})
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

//动画
function dong() {
	$('.shu').css('color', 'red')
	setTimeout(function() {
		$('.shu').stop().css('color', '#999')
	}, 200);
	setTimeout(function() {
		$('.shu').stop().css('color', 'red')
	}, 400);
	setTimeout(function() {
		$('.shu').stop().css('color', '#999')
	}, 600);
	setTimeout(function() {
		$('.shu').stop().css('color', 'red')
	}, 800);
	setTimeout(function() {
		$('.shu').stop().css('color', '#999')
	}, 1000);
}