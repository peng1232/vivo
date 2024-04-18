$(function() {
	//初始化
	address();
	var summ = 0.00;
	$('.total_col').each(function(){
		summ+=parseFloat($(this).text().substring(1,$(this).text().length))
	})
	$('.real_price').text('￥'+summ.toFixed(2))
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
		$('.tishi').css('display', 'none').attr('flag', 'true')
		$('.item select').find('option:eq(0)').prop('selected', true);
		$('.item select').css('color', '#ccc')
		$('.mou').prop('checked', false)
		$('#hao').removeClass();
	}


	//失去焦点事件
	$('.enter').blur(function() {
		if ($(this).val().trim().length <= 0) {
			$(this).parent().find('.tishi').css('display', 'block').attr('flag', 'false')
		} else {
			$(this).parent().find('.tishi').css('display', 'none').attr('flag', 'true')
		}
	})
	$('.enter').eq(1).blur(function() {
		if (isValidPhoneNumber($(this).val())) {
			$(this).parent().find('.tishi').css('display', 'none').attr('flag', 'true')
		} else {
			$(this).parent().find('.tishi').css('display', 'block').attr('flag', 'false')
		}
	})
	$('.item select').change(function() {
		$(this).css('color', '#000')
		var flag = true;
		$('.item select').each(function() {
			var selectedText = $(this).find("option:selected").text();
			if (selectedText == '请选择') {
				flag = false;
			}
		})
		if (!flag) {
			$(this).parent().find('.tishi').css('display', 'block').attr('flag', 'false')
		} else {
			$(this).parent().find('.tishi').css('display', 'none').attr('flag', 'true')
		}
	})

	$('.adress_list').on('click', '.shouhuo ', function() {
		$(this).siblings().removeClass("on");
		$(this).addClass('on');
		$('.value').eq(0).text($(this).find('.xx').text().trim()+" "+$(this).find('.dd').attr('phone'));
		$('.value').eq(1).text($(this).find('.mlellipsis').text().trim())

	})

	$('.message_box_footer').on('click', '.baocun', function() {
		$('.enter').trigger("blur")
		var flag = true;
		$('.item select').each(function() {
			var selectedText = $(this).find("option:selected").text();
			if (selectedText == '请选择') {
				flag = false;
			}
		})
		if (!flag) {
			$('.item select').parent().find('.tishi').css('display', 'block').attr('flag', 'false')
		} else {
			$('.item select').parent().find('.tishi').css('display', 'none').attr('flag', 'true')
		}
		var pan = true;
		//判断
		$('.tishi').each(function() {
			var zhi = $(this).attr('flag')
			if (zhi == 'false') {
				pan = false;
			}
		})
		if (pan) {
			//保存地址 发送请求
			var user_id = $('.user').val();
			var name = $('.enter').eq(0).val();
			var phone = $('.enter').eq(1).val();
			var shou = $('#province').find("option:selected").text() + " " + $('#city').find("option:selected").text() + " " + $('#district').find("option:selected").text();
			var xianxi = $('.enter').eq(2).val();
			var mou = $('.mou').prop('checked')
			$.getJSON('AddressInsertServlet', {
				'user_id': user_id,
				'name': name,
				'phone': phone,
				'shou': shou,
				'xianxi': xianxi,
				'mou': mou
			}, function(request) {
				guanbi();
				//调用查看收货地址
				address()
			});
		}
	})
	function address() {
		$('.adress_list').empty();
		var user_id = $('.user').val();
		$.getJSON('AddressAllServlet', { 'user_id': user_id }, function(request) {
			// Assuming request.Address is your array of addresses
			var addresses = request.Address;

			// Iterate over the array using jQuery's .each() function
			$.each(addresses, function(index, address) {
				// Create a new <li> element for each address
				var newLi = $("<li>").addClass("address_item shouhuo");
				// Create a <label> element with the class 'inner' and its content
				var newLabel = $("<label>").addClass("inner");
				var itemTop = $("<div>").addClass("item_top");
				itemTop.append("<span class='xx'>" + address.consignee + "</span> <span class='dd' phone=" + address.phone + ">" + address.phone.substring(0, 3) + "****" + address.phone.substring(address.phone.length - 4, address.phone.length) + "</span>");
				var clDiv = $("<div>").addClass("cl");
				clDiv.append("<p class='mlellipsis'>" + address.receiving_region + " <span class='addxian'> " + address.detailed_region + " </span>" + "</p>");
				newLabel.append(itemTop, clDiv);
				if(index==0){
					newLi.addClass('on')
				}
				if (address.default_address == 1) {
					newLi.addClass('mouren')
				} else {
					var defaultAddressLi = $("<li>").addClass("operations_address_default").text("设为默认地址");
				}

				// Create a <ul> element with the class 'operations' and its content
				var operationsUl = $("<ul>").addClass("operations");

				var editLi = $("<li>").addClass("operations_address_edit").text("编辑");
				var deleteLi = $("<li>").addClass("operations_address_del").text("删除");
				operationsUl.append(defaultAddressLi, editLi, deleteLi);

				// Append the <label> and <ul> elements to the <li> element
				newLi.append(newLabel, operationsUl);
				newLi.attr('address_id', address.id)
				newLi.attr('defaultadd', address.default_address)
				// Append the new <li> element to a container, assuming 'container' is the ID of the container where you want to append it
				$(".adress_list").append(newLi);
				$('.value').eq(0).text($('.on').find('.xx').text().trim()+" "+$('.on').find('.dd').attr('phone'));
				$('.value').eq(1).text($('.on').find('.mlellipsis').text().trim())
			});
			var newAddressItem = $("<li></li>")
				.addClass("address_item new")
				.append($("<label></label>")
					.addClass("inner")
					.text("添加新地址"));
			$(".adress_list").append(newAddressItem);
		});
	}
	//打开新增弹窗
	$('.adress_list').on('click', '.new', function() {
		kai();
		$('#hao').addClass('baocun')
		$('.mess_title').text('新建收货地址');
	})

	//设置默认地址
	$('.adress_list').on('click', '.operations_address_default', function() {
		var address_id = $(this).parent().parent().attr('address_id');
		$.getJSON('AddressDefaultServlet', { 'address_id': address_id }, function() {
			address();
		})
	})
	//编辑
	var address_id
	$('.adress_list').on('click', '.operations_address_edit', function() {
		var li = $(this).parent().parent();
		$('#hao').addClass('baocun2')
		address_id = li.attr('address_id');

		$('.enter').eq(0).val(li.find('.xx').text());
		$('.enter').eq(1).val(li.find('.dd').attr('phone'));
		$('.enter').eq(2).val(li.find('.addxian').text());
		// 假设你的地址字符串是这样的
		var add = li.find('.mlellipsis').html();
		getProvince(); // 初始加载省份
		// 分割地址字符串为省、市、区
		var addressParts = add.split(" ");
		// 同步加载和设置省份
		$.getJSON("../province", function(data) {
			var provinceSelect = $('#province').empty().append('<option value="">请选择</option>');
			data.forEach(function(item) {
				provinceSelect.append('<option value="' + item.id + '">' + item.name + '</option>');
			});
			var provinceId = provinceSelect.find("option:contains(" + addressParts[0] + ")").val();
			provinceSelect.val(provinceId).trigger('change'); // 触发省份的change事件来加载城市

			// 延迟加载城市和区县
			setTimeout(function() {
				var citySelect = $('#city');
				var cityId = citySelect.find("option:contains(" + addressParts[1] + ")").val();
				citySelect.val(cityId).trigger('change'); // 触发城市的change事件来加载区县

				setTimeout(function() {
					var districtSelect = $('#district');
					var districtId = districtSelect.find("option:contains(" + addressParts[2] + ")").val();
					districtSelect.val(districtId);
					$('.tishi').eq(2).css('display', 'none').attr('flag', 'true')
					if (li.attr('defaultadd') == '1') {
						$('.mou').prop('checked', true);
					} else {
						$('.mou').prop('checked', false);
					}
					$('#district').css('color', 'rgb(0, 0, 0)')
				}, 100); // 设置区县选中值
			}, 100);
		});
		$('.mess_title').text('修改收货地址');
		kai();

	})


	//删除
	$('.adress_list').on('click', '.operations_address_del', function() {
		var li = $(this).parent().parent();
		var address_id = li.attr('address_id');
		$.getJSON('AddressDelectServlet', { 'address_id': address_id }, function() {
			address()
		})
	})

	//修改
	$('.message_box_footer').on('click', '.baocun2', function() {
		var name = $('.enter').eq(0).val();
		var phone = $('.enter').eq(1).val();
		var shou = $('#province').find("option:selected").text() + " " + $('#city').find("option:selected").text() + " " + $('#district').find("option:selected").text();
		var xianxi = $('.enter').eq(2).val();
		var mou = $('.mou').prop('checked')
		$.getJSON('AddressUpdateServlet', {
			'address_id': address_id,
			'name': name,
			'phone': phone,
			'shou': shou,
			'xianxi': xianxi,
			'mou': mou
		}, function(request) {
			guanbi();
			//调用查看收货地址
			address()
		});
	})
	
	
	$('.btn_submit').click(function(){
		var user_id = $('.user').val();
		var name = $('.on').find('.xx').text().trim();
		var phone = $('.on').find('.dd').attr('phone');
		var address =$('.on').find('.mlellipsis').text().trim()
		var details=[];
		$('.product_info').each(function(){
			var sku = $(this).attr('sku')
			var product_id = $(this).attr('product_id')
			var number = $(this).find('.quantity_col').text();
			var t = $(this).find('.total_col');
			var total = t.text().substring(1,t.text().length)
			details.push({
				'sku':sku,
				'product_id':product_id,
				'number':number,
				'total':total
			})
		})
		var jsonData = JSON.stringify(details);
		$.getJSON('OrderInsertServlet',{
			'user_id':user_id,
			'name':name,
			'phone':phone,
			'address':address,
			'details':jsonData,
		},function(){
			
		})
		console.log(user_id,name,phone,address,details)
	})
})




function isValidPhoneNumber(phoneNumber) {
	const pattern = /^1[3-9]\d{9}$/;
	return pattern.test(phoneNumber);
}