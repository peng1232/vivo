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
			width:"30%",
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
			width:"30%",
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
		var that =$(this).parent().parent()
		$('.id').val(that.find('.ntd').eq(1).text())
		$('.name').val(that.find('.ntd').eq(3).text())
		$('.cate').val(that.find('.proid').attr('value'))
	
		
	})

	//提交判断
	$("#s").submit(function(e) {
		alert(3)
		e.preventDefault();  // 阻止表单默认提交行为
		var type = $(".type[name='type']").val();  // 正确的选择器
		if (type == "") {
			alert("类别名称不能为空");
		}
	});


})