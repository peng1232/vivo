$(function() {
	$('.body_top').find('span').text('商品分类管理')

	$('.quanxuan').click(function() {
		var that = $(this);
		if (that.is(':checked')) {
			$('.ew').prop('checked', true);
		} else {
			$('.ew').prop('checked', false);
		}
	})
})