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
	//市选中事件
	$("#city").change(function() {
		var zhi = $(this).val();
		getDistrict(zhi);
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
	$('#district').children().not(':first').remove();
	citySelect.children().not(':first').remove();
	$.getJSON("../city?parentid=" + zhi, function(data) {
		for (var i = 0; i < data.length; i++) {
			citySelect.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
		}
	})
}
function getDistrict(zhi) {
	var districtSelect = $('#district');
	districtSelect.children().not(':first').remove();
	$.getJSON("../district?parentid=" + zhi, function(data) {
		for (var i = 0; i < data.length; i++) {
			districtSelect.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
		}
	})
}