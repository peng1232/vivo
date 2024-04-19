/**
 * 
 */
$(function() {
	$('#js_headerSearch').click(function() {
		var serach = $('#js_headerInput').val();
		if (serach.trim().length > 0) {
			location.href = 'SearchSetlvet?search=' + serach;
		}
	})
})