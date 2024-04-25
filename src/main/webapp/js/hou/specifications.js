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
		$('.btnew').attr('specifications_id',that.find('.ntd').eq(1).text()).addClass('zzz')
		generateTableRows();
	})

	function generateTableRows() {
		$.getJSON('ValueSelectOneServlet', { "specifications_id": that.find('.ntd').eq(1).text() }, function(request) {
			var tbody = $('.tavalue');
		$(".tavalue tr:not(:first-child)").remove();
		if (request.selectValue.length <= 0) {
			var row = $('<tr>');
			row.append($('<td colspan="11" style="text-align: center">暂无数据</td>'));
			tbody.append(row);
		}
		$.each(request.selectValue, function(index, item) {
			var row = $('<tr>');
			row.append($('<td>').text(item.id));
			var input = $('<input>').addClass('valuenr').attr('value', item.value);
			row.append($('<td>').append(input));
			var editButton = $('<button>').addClass('an shen upd').attr('value', item.id).text('保存修改');
			editButton.click(function() {
				var id = $(this).parent().parent().find('td').eq(0).text();
				var zhi = $(this).parent().parent().find('.valuenr').val();
				//发送修改请求
				$.getJSON('ValueUpdateServlet',{"specifications_id":id,"value":zhi},function(){
					generateTableRows()
				})
			})

			row.append($('<td>').append(editButton));
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
		var ta =$(this).parent().find('.type')
    	var value = $(this).parent().find('.type').val().trim();
    	if(value.length>0){
			$.getJSON('ValueInsertServlet',{"id":id,"value":value},function(){
				generateTableRows();
				ta.val("")
			})
		}
    	
	});


})