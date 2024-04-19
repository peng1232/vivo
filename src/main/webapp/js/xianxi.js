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
		if (parseInt(sum) > 1) {
			sum--;
		}
		$(".number").text(sum)
		info();
	});
	//加
	$(".num_rigth").on("click", function() {
		var sum = $(".number").text();
		var max = $('.limit').val();
		if (sum < max) {
			sum++;
		} else {
			dong();
		}
		$(".number").text(sum);
		info();
	});

	//添加收藏，取消收藏
	$('.shouc').click(function() {
		var proid = $(".name").attr('pro');
		var userid = $(".user_id").val();
		var skuvalue = $('.shousku').attr('sku');
		if (userid.trim().length > 0) {
			//已登录
			if ($(this).attr('check') == 'true') {
				//取消
				$(this).attr('check', 'false');
				$(this).find('path').css('fill', '#acacac')
			} else {
				//收藏
				$(this).attr('check', 'true');
				$(this).find('path').css('fill', '#f51919')
			}
			var flag = ($(this).attr('check'));//true收藏 false no
			//发送请求
			$.getJSON('CollectionServlet', { 'user_id': userid, 'product_id': proid, 'sku': skuvalue, 'flag': flag }, function(request) {
				$('.text').text("收藏商品（" + request.queryCollection + "人收藏）")
			});
		} else {
			//未登录
			location.href = '../login/login.jsp'
		}
	})

	//添加购物车
	$('.addshopping').click(function() {
		var proid = $(".name").attr('pro');
		var userid = $(".user_id").val();
		var userid = $(".user_id").val();
		var skuval = $('.addS').attr('sku');
		if (userid.trim().length > 0) {
			//已登录
			//判断是否有该购物车
			$.getJSON('IsShopping', { 'user_id': userid, 'product_id': proid, 'sku': skuval }, function(request) {
				if (!request.Shopp) {
					//添加购物车
					$.getJSON('ShoppingInsertServlet', { 'user_id': userid, 'product_id': proid, 'sku': skuval }, function(request) {
						$('.gou').text('购物车(' + request.shopping_count + ')')
						location.href = 'CardServlet?shopping_id='+request.shoppingid
					});
				} else {
					//不能添加 弹窗
					kai();
				}
			});
		} else {
			//未登录
			location.href = '../login/login.jsp'
		}

	})
	
	//立即购买
	$('.brand').click(function() {
		var proid =[];
		proid.push({
			'product_id':$(".name").attr('pro')
		});
		var userid = $(".user_id").val();
		var skuval = $('.addS').attr('sku');
		var sku = [];
		sku.push(skuval)
		var jsonData = JSON.stringify(sku);
		var product_id = JSON.stringify(proid);
		if (userid.trim().length > 0) {
			//已登录
			var url = 'SelectSKUProductServlet?user_id=' + userid + '&product_id=' + encodeURIComponent(product_id) + '&sku=' + encodeURIComponent(jsonData);
			location.href = url;
		} else {
			//未登录
			location.href = '../login/login.jsp'
		}

	})
	var start =0;
	var pagesize = 5;
	var proid = $(".name").attr('pro');
	setTimeout(function(){
		loading(start,pagesize,proid)
		start++;	
	},100)
	//加载更多
	$('#jiazai').click(function(){
		loading(start++*pagesize,pagesize,proid)
	})
	
	//加载评论
	function loading(start,end,proid){
		console.log("xxxx"+start,end)
		//评论初始化
		$.getJSON('CommentsInitServlet',{'start':start,'end':end,'product_id':proid},function(request){
			$.each(request.commentList, function(index, value) {
			    var listItem = $('<li>').addClass('remark_item clearfix');
			    var userInfoDiv = $('<div>').addClass('clearfix user_info');
			    var avatarImg = $('<img>').addClass('avatar').attr('src', '../../img/'+value.head_sculpture);
			    var nameInfoDiv = $('<div>').addClass('name_info');
			    var userNameDiv = $('<div>').addClass('user_name').text(value.user_nickname);
			    var productNameDiv = $('<div>').addClass('product_name').text(value.sku);
			    var iconLineDiv = $('<div>').addClass('iconLine');
			    var clearfix = $('<li>').addClass('clearfix');
			    
			    // Generate stars
			    for (var i = 0; i < 5; i++) {
			        var starIcon = $('<div>').addClass('iconInterval icon-star').text('★');
			        iconLineDiv.append(starIcon);
			        if(!(i<value.com_grade)){
						starIcon.css('color','#fff')
					}
			    }
				clearfix.append(userInfoDiv,iconLineDiv)
			    var remarkContentDiv = $('<div>').addClass('remark_content');
			    var remarkTextP = $('<p>').addClass('remark_text').text(value.user_com);
			
			    nameInfoDiv.append(userNameDiv, productNameDiv);
			    userInfoDiv.append(avatarImg, nameInfoDiv);
			    listItem.append(clearfix, remarkContentDiv.append(remarkTextP));
			
			    // Append to the target element
			    $('.remark_list').append(listItem);
			  //  console.log(request.commentList)
			});
			if(request.commentList.length<pagesize){
				$('#meile').css('display','block')
				$('#jiazai').css('display','none')
			}
		})
	}


	//弹窗点击时间
	$('.message_box_footer button').click(function() {
		guanbi();
	})
	$('.zhe').click(function() {
		guanbi();
	})
	$('.guan').click(function() {
		guanbi();
	})

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

}

var jiageid;
//设置已选择内容,与价格
function info() {
	$('.info').text('已选：' + $('.sku_checked').eq(0).text() + " " + $('.sku_checked').eq(1).text() + " " + $(".number").text() + "件")
	$('.price').text('￥' + (parseInt($(".number").text()) * $(".sale-price").attr('price')))
	$('.addS').attr('sku', '{"sku_price":' + jiageid + ',"pageType":' + $('.sku_checked').eq(0).attr('productid') + ',"color":' + $('.sku_checked').eq(1).attr('productid') + ',"number":' + $('.number').text() + '}')
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
			var sku = '{"sku_price":' + response.price.id + ',"pageType":' + $('.sku_checked').eq(0).attr('productid') + ',"color":' + $('.sku_checked').eq(1).attr('productid')/*+',"number":'+$('.number').text()*/ + '}'
			$('.shousku').attr('sku', sku)
			$('.addS').attr('sku', '{"sku_price":'+response.price.id+',"pageType":'+$('.sku_checked').eq(0).attr('productid')+',"color":'+$('.sku_checked').eq(1).attr('productid')+',"number":'+$('.number').text() + '}')
			jiageid = response.price.id
			//查看是否是收藏	
			$.getJSON('IsShouServlet', { 'user_id': userid, 'product_id': proid, 'sku': sku }, function(request) {
				console.log(request.collection)
				if (request.collection) {
					$('.shouc').attr('check', 'true');
					$('.shouc').find('path').css('fill', '#f51919')
				} else {
					$('.shouc').attr('check', 'false');
					$('.shouc').find('path').css('fill', '#acacac')
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