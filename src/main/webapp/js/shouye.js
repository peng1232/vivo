/**
 * 
 */

//轮播
LoopSlider.init({
	el: ".lunbo", //选择器
	navigator: {
		//前进后退按钮
		prevEl: ".prev",
		nextEl: ".next"
	},
	easing: "ease", //动画效果cubic-bezier(0.985, -0.060, 0.000, 1.320)
	duration: 300, //过渡时间，默认为3000ms,
	autoplay: 3000, //boolean 和 number 设置为true 默认延时为3s,如果设置为1000，延时为1s
})

//轮播图的伪类
$(function(){
	
	 $(".lun").hover(function(){
		 $('.prev').css('left','0px');
		 $('.next').css('right','0px');
	 },function(){
		 $('.prev').css('left','-40px');
		 $('.next').css('right','-40px');
	 })
})