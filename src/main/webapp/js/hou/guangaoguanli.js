$(function() {
	$('.body_top').find('span').text('商品广告管理')

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
			title: "新增商品广告",
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
			top: "15vh",
			width:'30%',
			title: "修改商品广告",
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
		var that =$(this).parent().parent()
		$('.id').val(that.find('.ntd').eq(1).text())
		$('.product_name').val(that.find('.proid').attr('value'))
		$('.state').val(that.find('.ntd').eq(4).attr('val'))
		
		
	})

	var asdf_id ;
	var asdf_url ;
	$('.del').click(function(){
		$('#photoss').click()
		asdf_id = $(this).attr('value');
		asdf_url = $(this).parent().parent().find('.s1').text();
	})
	
	
	$('#photoss').change(function() {
		// 获取文件对象
		var file = this.files[0];
		// 创建FormData对象，用于传输文件
		var formData = new FormData();
		formData.append('photo', file);
		formData.append('id', asdf_id);
		formData.append('url', asdf_url);
		
		// 发送JSON请求
		$.ajax({
			url: 'GuanGaoUpdate2Servlet', // 替换为你的JSON请求端点
			type: 'POST', // 使用POST方法发送请求
			data: formData, // 发送FormData对象
			processData: false, // 不处理数据
			contentType: false, // 不设置Content-Type
			success: function(response) {
				// 请求成功的处理逻辑
				location.reload();
			},
			error: function(xhr, status, error) {
				// 请求失败的处理逻辑
				console.error('JSON请求失败:', error);
			}
		});
	});

})