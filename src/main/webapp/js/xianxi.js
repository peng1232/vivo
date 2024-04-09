$(function(){
	
	$('.sku-module_item').on('click',function(){
		$(this).siblings().removeClass("sku_checked");
		$(this).addClass('sku_checked');
		shua()
	})
	shua();
})
var yuan = [];
function shua(){
	var xin = [];
	$('.sku_checked').each(function() {
	   xin.push($(this).attr('productid'));
	});
	if(!arraysEqual(yuan,xin)){
		//发送请求
		
		console.log("不一样"+xin);
		yuan = xin;
	}
	
}
//比较前后规格有没有变化
function arraysEqual(arr1, arr2) {
  if (arr1.length !== arr2.length) {
    return false;
  }
  for (var i = 0; i < arr1.length; i++) {
    if (arr1[i] !== arr2[i]) {
      return false;
    }
  }
  return true;
}