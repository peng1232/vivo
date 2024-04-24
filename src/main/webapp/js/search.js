/**
 * 
 */
$(function() {
	$('#js_headerSearch').click(function() {
		var serach = $('#js_headerInput').val();
		serach = serach.replace(/\\/g, "");
		if (serach.trim().length > 0) {
			location.href = 'SearchSetlvet?search=' + serach;
		}
	})
	$('#js_headerInput').keyup(function(event) {
		if (event.which === 13) { // 13是回车键的键码
			var serach = $('#js_headerInput').val();
			serach = serach.replace(/\\/g, "");
			if (serach.trim().length > 0) {
				location.href = 'SearchSetlvet?search=' + serach;
			}
		}
	});


	var start = 0;
	var pagesize = 8;
	var search;
	//加载更多
	$('#jiazai').click(function() {
		search = $('#js_headerInput').val();
		loading(++start * pagesize, start * pagesize + pagesize, search)
	})

	//加载商品
	function loading(start, end, search) {
		//评论初始化
		$.getJSON('SearchSetlvet2', { 'start': start, 'end': end, 'search': search }, function(request) {
			$.each(request.querySearch, function(index, item) {
				// 创建一个新的 div 元素，并添加类名为 'content_item'
				var newItem = $('<div>').addClass('content_item');

				// 添加条件类 'yi'，条件是 va.index % 4 等于 3
				if (index % 4 == 3) {
					newItem.addClass('yi');
				}

				// 设置 'product' 属性为 item.id
				newItem.attr('product', item.id);

				// 创建并添加图片元素，并设置 src 属性
				var img = $('<img>').addClass('result_pic').attr('src', `../../img/product/${item.image_url}`);
				newItem.append(img);

				// 创建并添加标题元素，并设置文本内容
				var title = $('<p>').addClass('result_title').text(`${item.products_name} ${item.pagTtype} ${item.color}`);
				newItem.append(title);

				// 创建并添加描述元素，并设置文本内容
				var description = $('<span>').addClass('result_text').text(item.description);
				newItem.append(description);

				// 创建价格元素，并设置价格文本
				var price = $('<p>').addClass('result_price');
				var priceNew = $('<span>').addClass('result_price_new').text(`￥${item.price}`);
				price.append(priceNew);
				newItem.append(price);

				// 创建并添加链接元素，并设置 href 属性
				var link = $('<a>').attr('href', `XianXiSerlvet?id=${item.id}`);
				newItem.append(link);

				// 将新创建的元素添加到文档中的合适位置
				$('.page_search_result_content').append(newItem);
			});
			console.log(23)
			if (request.querySearch.length < pagesize) {
				$('#meile').css('display', 'block')
				$('#jiazai').css('display', 'none')
			}
		})
	}
})