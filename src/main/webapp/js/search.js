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
	$('#js_headerInput').keyup(function(event) {
		if (event.which === 13) { // 13是回车键的键码
			var serach = $('#js_headerInput').val();
			if (serach.trim().length > 0) {
				location.href = 'SearchSetlvet?search=' + serach;
			}
		}
	});
})