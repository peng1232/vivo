$(function() {
	$('.body_top').find('span').text('商品规格管理')

	//全选按钮
	$('.quanxuan').click(function() {
		var that = $(this);
		if (that.is(':checked')) {
			$('.ew').prop('checked', true);
		} else {
			$('.ew').prop('checked', false);
		}
	})

	//新增弹窗
	$('.newtype').click(function() {
		var dom = $('.xin').prop('outerHTML');

		var mModal1 = new mModal({
			top: "25vh",
			width: "30%",
			title: "新增商品规格",
			showConfirmButton: false,
			showCancelButton: false,
			content: "<div class='clearfix'>" + dom + "</div>",
			confirm: function() {

				mModal1.close();
			},
			cancel: function() {
				//alert("取消弹框21")
			}
		});
		mModal1.renderDom();
	})

	//修改弹窗
	var type_id;
	$('.shen').click(function() {
		var dom = $('.update').prop('outerHTML');
		var mModal1 = new mModal({
			top: "20h",
			width: "30%",
			title: "修改商品规格",
			showConfirmButton: false,
			showCancelButton: false,
			content: "<div class='clearfix'>" + dom + "</div>",
			confirm: function() {

				mModal1.close();
			},
			cancel: function() {
				//alert("取消弹框21")
			}
		});

		mModal1.renderDom();
		var that = $(this).parent().parent()
		$('.id').val(that.find('.ntd').eq(1).text())
		$('.name').val(that.find('.ntd').eq(3).text())
		$('.cate').val(that.find('.proid').attr('value'))


	})

	var that;
	//查看弹窗
	$('.cha').click(function() {
		var dom = $('.chile').prop('outerHTML');
		var mModal1 = new mModal({
			top: "20h",
			width: "50%",
			title: "查看商品规格",
			showConfirmButton: false,
			showCancelButton: false,
			content: "<div class='clearfix'>" + dom + "</div>",
			confirm: function() {

				mModal1.close();
			},
			cancel: function() {
				//alert("取消弹框21")
			}
		});

		mModal1.renderDom();
		that = $(this).parent().parent();
		$('.pname').text(that.find('.proid').text())
		$('.pvalue').text(that.find('.ntd').eq(3).text())
		$('.btnew').attr('specifications_id', that.find('.ntd').eq(1).text()).addClass('zzz')
		generateTableRows();
	})

	var image_value;
	function generateTableRows() {
		$.getJSON('ValueSelectOneServlet', { "specifications_id": that.find('.ntd').eq(1).text() }, function(request) {
			var tbody = $('.tavalue');
			$(".tavalue tr:not(:first-child)").remove();
			if (request.selectValue.length <= 0) {
				var row = $('<tr>');
				row.append($('<td colspan="4" style="text-align: center">暂无数据</td>'));
				tbody.append(row);
			}
			$.each(request.selectValue, function(index, item) {
				var row = $('<tr>');
				row.append($('<td>').text(item.id));
				var input = $('<input>').addClass('valuenr').attr('value', item.value);
				row.append($('<td>').append(input));
				row.append($('<td>').text(request.num[index]));
				var editButton = $('<button>').addClass('an shen upd').attr('value', item.id).text('保存修改');
				editButton.click(function() {
					var id = $(this).parent().parent().find('td').eq(0).text();
					var zhi = $(this).parent().parent().find('.valuenr').val();
					//发送修改请求
					$.getJSON('ValueUpdateServlet', { "specifications_id": id, "value": zhi }, function() {
						generateTableRows()
					})
				})
				var image_url = $('<button>').addClass('an shen image_url').attr('value', item.id).text('查看图片');
				image_url.click(function() {
					$('.pvalue_name').text($(this).parent().parent().find('.valuenr').val());
					image_value = $(this).attr('value');
					$('.tan').css('display', 'block');
					$('.container').css('animation', 'dialog-fade-in .3s')
					generateImageTableRows();
				})
				row.append($('<td>').append(editButton).append(image_url));
				tbody.append(row);
			});
		})
	}
	var image_url_id;
	var image_url_value;
	function generateImageTableRows() {
		$.getJSON('ImageSelectAllServlet', { "value_id": image_value }, function(request) {
			var tbody = $('.taimage');
			$(".taimage tr:not(:first-child)").remove();
			if (request.Product_Image.length <= 0) {
				var row = $('<tr>');
				row.append($('<td colspan="3" style="text-align: center">暂无数据</td>'));
				tbody.append(row);
			}
			$.each(request.Product_Image, function(index, item) {
				var row = $('<tr>').addClass('shijian');
				row.append($('<td>').text(item.id));
				row.append($('<td>').addClass('din').append($('<p>').addClass('sandian').text(item.image_url)));

				var editButton = $('<button>').addClass('an shen upd').attr('value', item.id).text('修改图片');
				editButton.click(function(){
					$('#photo2').click();
					image_url_id = $(this).attr('value')
					image_url_value = $(this).parent().parent().find('.sandian').text();
				})
				var image_url = $('<button>').addClass('an del image_url').attr('value', item.id).text('删除图片');
				image_url.click(function() {
					var tr = $(this).parent().parent();
					var image_id = tr.find('td').eq(0).text();
					var image_url = tr.find('.sandian').text();
					$.getJSON('ImageDelectServlet', { 'image_id': image_id, 'image_url': image_url }, function() {
						generateTableRows();
						generateImageTableRows();
					})
				})
				row.append($('<td>').append(editButton).append(image_url));
				tbody.append(row);
			});
		})
	}


	//提交判断
	$("#s").submit(function(e) {
		alert(3)
		e.preventDefault();  // 阻止表单默认提交行为
		var type = $(".type[name='type']").val();  // 正确的选择器
		if (type == "") {
			alert("类别名称不能为空");
		}
	});

	//添加规格值
	$(document).on('click', '.btnew', function() {
		var id = $(this).attr('specifications_id');
		var ta = $(this).parent().find('.type')
		var value = $(this).parent().find('.type').val().trim();
		if (value.length > 0) {
			$.getJSON('ValueInsertServlet', { "id": id, "value": value }, function() {
				generateTableRows();
				ta.val("")
			})
		}

	});

	//上传图片
	$('.addUrl').click(function() {
		$('#photo').click();
	})
	$('#photo').change(function() {
		// 获取文件对象
		var file = this.files[0];
		// 创建FormData对象，用于传输文件
		var formData = new FormData();
		formData.append('photo', file);
		formData.append('image_value', image_value)
		// 发送JSON请求
		$.ajax({
			url: 'ImageInsertServlet', // 替换为你的JSON请求端点
			type: 'POST', // 使用POST方法发送请求
			data: formData, // 发送FormData对象
			processData: false, // 不处理数据
			contentType: false, // 不设置Content-Type
			success: function(response) {
				// 请求成功的处理逻辑
				generateTableRows();
				generateImageTableRows();
				$('.y').css('display', 'block')
				$('.yul').css('display', 'none')
			},
			error: function(xhr, status, error) {
				// 请求失败的处理逻辑
				console.error('JSON请求失败:', error);
			}
		});
		$(this).val('')
	});
	//关闭一个图片弹窗
	$('.modal__headerbtn').click(function() {
		$('.tan').css('display', 'none')
		$('.y').css('display', 'block')
		$('.yul').css('display', 'none')
	})

	//路径悬浮时间
	$(document).on('mouseover', '.shijian', function() {
		$('.y').css('display', 'none')
		$('.yul').css('display', 'block').attr('src', '../../img/product/' + $(this).find('.sandian').text())
	});


	$('#photo2').change(function() {
		// 获取文件对象
		var file = this.files[0];
		// 创建FormData对象，用于传输文件
		var formData = new FormData();
		formData.append('photo', file);
		formData.append('image_id', image_url_id);
		formData.append('image_url_value', image_url_value);
		
		// 发送JSON请求
		$.ajax({
			url: 'ImageUpdateServlet', // 替换为你的JSON请求端点
			type: 'POST', // 使用POST方法发送请求
			data: formData, // 发送FormData对象
			processData: false, // 不处理数据
			contentType: false, // 不设置Content-Type
			success: function(response) {
				// 请求成功的处理逻辑
				generateTableRows();
				generateImageTableRows();
				$('.y').css('display', 'block')
				$('.yul').css('display', 'none')
			},
			error: function(xhr, status, error) {
				// 请求失败的处理逻辑
				console.error('JSON请求失败:', error);
			}
		});
		$(this).val('')
	});
})