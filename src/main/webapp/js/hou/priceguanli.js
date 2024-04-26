$(function() {
	$('.body_top').find('span').text('价格管理')

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
			top: "22vh",
			width: "30%",
			title: "新增商品价格",
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
			top: "20vh",
			width: "30%",
			title: "修改商品价格",
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
		var pro = that.find('.proid');
		$('.name').val(pro.text())
		$('.product_id').val(pro.attr('value'))
		$('.price_value').val(that.find('.ntd').eq(3).text())
		$('.is').val(that.find('.ntd').eq(4).attr('iss'))

	})
	
	var that;
	//查看弹窗
	$('.cha').click(function() {
		var dom = $('.chile').prop('outerHTML');
		var mModal1 = new mModal({
			top: "20vh",
			width: "50%",
			title: "查看商品价格组合",
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
		$('.pname').attr("product_id",that.find('.proid').attr("value"))
		
		$('.pvalue').text(that.find('.ntd').eq(3).text())
		$('.pvalue').attr('price_id',that.find('.ntd').eq(1).text())
		
		$('.btnew').attr('price_id',that.find('.ntd').eq(1).text())
		generateTableRows();
	})

	function generateTableRows() {
		$.getJSON('CombinationSelectServlet', { "price_id": $('.pvalue').attr('price_id'),"product_id": $('.pname').attr('product_id')  }, function(request) {
			var tbody = $('.tavalue');
			$(".tavalue tr:not(:first-child)").remove();
			if (request.selectAll.length <= 0) {
				var row = $('<tr>');
				row.append($('<td colspan="11" style="text-align: center">暂无数据</td>'));
				tbody.append(row);
			}
			$.each(request.selectAll, function(index, item) {
				var row = $('<tr>');
				row.append($('<td>').text(item.value_id));
				row.append($('<td>').text(request.ps[index].specifications_name));
				row.append($('<td>').text(request.value[index].value));
				var editButton = $('<button>').addClass('an del shang').attr('value', item.id).text('删除');
				editButton.click(function() {
					var id = $(this).attr('value');
					//发送修改请求
					$.getJSON('CombinationUpdateServlet',{"id":id},function(){
						generateTableRows()
					})
				})
	
				row.append($('<td>').append(editButton));
				tbody.append(row);
			});
			
			//渲染下拉框
			var select = $('.product_name');
			select.empty();
			$.each(request.svalue, function(index, item) {
				var option =$('<option>').attr("value",item.id).text(item.value);
				select.append(option);
			})
		})
		
	}


	//提交判断
	$("#s").submit(function(e) {

		e.preventDefault();  // 阻止表单默认提交行为
		var type = $(".type[name='type']").val();  // 正确的选择器
		if (type == "") {
			alert("类别名称不能为空");
		}
	});
	
	//添加规格值
	$(document).on('click', '.btnew', function() {
		var price_id =  $(this).attr('price_id');
		var value_id = $(this).parent().find('.product_name').val();
		$.getJSON('CombinationInsertServlet',{"price_id":price_id,"value_id":value_id},function(){
			
			generateTableRows();
		})
		
    	
	});


})