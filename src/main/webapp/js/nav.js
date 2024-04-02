$(function() {
	// 类别的伪类
	$('.c_type').on('mouseenter', 'li', function() {
		$('.bukuai_phone').stop().animate({ top: '0px' }, 100);
		$(this).siblings().find('a').css("color", '#333841');
		$(this).find('a').css("color", '#415fff');
		phone(this);
		yishang(this, 0);
	}).on('mouseleave', 'li', function() {
		$('.bukuai_phone').stop().animate({ top: '-488px' }, 100);
	});


	//搜索按钮
	$('#search').click(function() {
		$('.bukuai_search').stop().animate({ top: '0px', opacity: 1 }, 0);
		$('#search').css('transform', 'translateX(-390px)')
		$('#close').css('opacity', '1').css('pointer-events', 'initial')
		$('.search_input input').focus().val('');
		$('.xian').css('width', '100%').css('opacity', '1');
		$('body').css('overflow-y', 'hidden');


	})



	//关闭
	// $('.bukuai_search').click(function(){
	//   close()
	// })
	$('#close').on('click', function() {
		close()
	})


	//发送请求
	$.getJSON("../navSerlvet?id=" + $('#bian').val(), function(response) {
		if (response.shopping_count != null) {
			$('.gou').text('购物车(' + response.shopping_count + ")")
		}

		$.each(response.list_cate, function(index, category) {
			// 对于数组中的每个元素，我们创建一个新的<li>元素
			var li = $('<li></li>');
			// 然后在这个<li>元素中添加一个新的<a>元素
			var a = $('<a></a>').text(category.category_type).attr('href', '#');
			// 最后，我们将<a>元素添加到<li>元素中，并将<li>元素添加到页面的某个元素中（例如，一个id为"menu"的元素）
			li.append(a);
			$(".c_type").append(li);
		});
		//location.reload();
	});
});

//关闭方法
function close() {
	$('.bukuai_search').animate({ top: '-488px', opacity: 0 }, 100);
	$('#search').css('transform', 'translateX(0px)')
	$('#close').css('opacity', '0').css('pointer-events', 'none')
	$('.xian').css('width', '0%').css('opacity', '0');
	$('body').css('overflow-y', 'auto');
}
function phone(e) {
	$('.bukuai_phone').hover(function() {
		$(this).stop().animate({ top: '0px' }, 100);
	}, function() {
		$(this).stop().animate({ top: '-488px' }, 100);
		$(e).find('a').css("color", '#333841');
	});
}
//元素展开
function yishang(e, i) {
	var total = $('.phone_total').eq($(e).index());
	var liCount = total.find('li').length;
	if (i >= liCount) {
		return;
	}
	total.siblings().css("top", '-488px')
	total.css("top", '0px')
	setTimeout(function() {
		total.eq(i).siblings().find('li').css('opacity', '0').css('transform', 'translateY(50px)');
		total.find('li').eq(i).stop().css('opacity', '1').css('transform', 'translateY(0px)');
		yishang(e, i + 1);
	}, 100);
}
function sou(e) {
	var total = $('.phone_total').eq($(e).index());
	total.find('li').stop().css('opacity', '0').css('transform', 'translateY(50px)');
}




