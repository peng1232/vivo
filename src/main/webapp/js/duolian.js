/**
 * 
 */
$(function() {
	getProvince();
	//省选中事件
	$("#province").change(function() {
		var zhi = $(this).val();
		getCity(zhi);
	});
})
function getProvince() {
	$.getJSON("../province", function(data) {
		var provinceSelect = $('#province');
		for (var i = 0; i < data.length; i++) {
			provinceSelect.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
		}
	})
}
function getCity(zhi) {
	var citySelect = $('#city');
	citySelect.empty();
	$.getJSON("../city?parentid=" + zhi, function(data) {
		for (var i = 0; i < data.length; i++) {
			provinceSelect.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
		}
	})
}