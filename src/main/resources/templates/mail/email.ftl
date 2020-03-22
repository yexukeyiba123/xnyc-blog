<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
</head>
<body>    
<div>
	<style type="text/css">
		.xnycEmailContainer{
			background-color:#d0d0d0;
			background-image: url(http://www.xuniyicheng.com/qq-email/mmsgletter_2_bg.png);
			text-align:center;
			padding:40px;
		}
		.emailContent{
			width: 580px;
			margin: 0 auto;
			padding: 10px;
			color: #333;
			background-color: #fff;
			border: 0px solid #aaa;
			border-radius: 5px;
			-webkit-box-shadow: 3px 3px 10px #999;
			-moz-box-shadow: 3px 3px 10px #999;
			box-shadow: 3px 3px 10px #999;
			font-family: 微软雅黑, Verdana, sans-serif;
		}
		.emailContent .emailHeader{
			height: 23px;
			background: url(http://www.xuniyicheng.com/qq-email/mmsgletter_2_bg_topline.png) repeat-x 0 0;
		}
	</style>
	<style>
		* {
			margin:0;
			padding:0;
		}
		.xnycEmail{
			position: relative;
			margin: 0 auto;
			width:100%;
			height:100%;
			max-width:1200px;			
		}
		.flush-1, .flush-2, .flush-3, .flush-4, .flush-5 {
			background: url(http://www.xuniyicheng.com/qq-email/spr_r5.png) no-repeat;
			overflow: hidden;
			z-index:100000;
		}
		.flush-1 {
			left: 42px;
			top: 100px;
			background-position: 0 0;
			-webkit-animation: flush-1 2.6s linear infinite both;
			animation: flush-1 2.6s linear infinite both;
		}
		.flush-2 {
			left: 186px;
			top: 200px;
			background-position: -75px 0;
			-webkit-animation: flush-2 2s linear infinite both;
			animation: flush-2 2s linear infinite both;
		}
		.flush-3 {
			left: 770px;
			top: 100px;
			background-position: -150px 0;
			-webkit-animation: flush-3 2s linear infinite both;
			animation: flush-3 2s linear infinite both;
		}
		.flush-4 {
			position: absolute;
			left: 822px;
			top: 180px;
			width: 100px;
			height: 100px;
			background-position:-225px 0px;
			-webkit-animation: flush-4 2.2s linear infinite both;
			animation: flush-4 2.2s linear infinite both;
		}
		.flush-5 {
			left: 1000px;
			top: 230px;
			background-position: 0 0;
			-webkit-animation: flush-1 2.6s .4s linear infinite both;
			animation: flush-1 2.6s .4s linear infinite both;
		}
		.flush-1, .flush-2, .flush-3, .flush-5 {
			position: absolute;
			width: 75px;
			height: 75px;
		}
		@keyframes flush-1{
			0% {
				transform: translateY(140px) scale(.1);
				opacity: 0;
			}
			40% {
				transform: translateY(0) scale(.2);
				opacity: .5;
			}
			60% {
				transform: translateY(0) scale(1);
				opacity: 1;
			}
			100% {
				transform: translateY(0) scale(1.6);
				opacity: 0;
			}
		}
		@keyframes flush-2{
			0% {
				transform: translateY(310px) scale(.1);
				opacity: 0;
			}
			40% {
				transform: translateY(0) scale(.2);
				opacity: .5;
			}
			60% {
				transform: translateY(0) scale(1);
				opacity: 1;
			}
			100% {
				transform: translateY(0) scale(1.6);
				opacity: 0;
			}
		}
		@keyframes flush-3{
			0% {
				transform: translateY(410px) scale(.1);
				opacity: 0;
			}
			40% {
				transform: translateY(0) scale(.2);
				opacity: .5;
			}
			60% {
				transform: translateY(0) scale(1);
				opacity: 1;
			}
			100% {
				transform: translateY(0) scale(1.6);
				opacity: 0;
			}
		}
		@keyframes flush-4{
			0% {
				transform: translateY(350px) scale(.1);
				opacity: 0;
			}
			40% {
				transform: translateY(0) scale(.2);
				opacity: .5;
			}
			60% {
				transform: translateY(0) scale(1);
				opacity: 1;
			}
			100% {
				transform: translateY(0) scale(1.8);
				opacity: 0;
			}
		}
		@keyframes flush-5{
			0% {
				transform: translateY(140px) scale(.1);
				opacity: 0;
			}
			40% {
				transform: translateY(0) scale(.2);
				opacity: .5;
			}
			60% {
				transform: translateY(0) scale(1);
				opacity: 1;
			}
			100% {
				transform: translateY(0) scale(1.6);
				opacity: 0;
			}
		}
	</style>
	<div id="xnycEmail">
		<div class="xnycEmailContainer">
			<div class="emailContent">
				<div class="emailHeader"></div>
				<div class="emailMsg" style="text-align:left;padding:0px;font-size:14px;line-height:1.5;">	
					<div>	
						<h3 style="border-top:0px;text-align:center;margin:0px;font-size:22px;">新年祝福</h3>
						<p style="margin:0px;font-size: 16px;"><b>XX</b>xx，您好：</p>
						<p style="margin:10px 0px;text-indent: 32px;font-size: 16px;">
							新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新新！
						</p>
						<p style="margin:0px;font-size: 16px;"><b>此致</b></p>
						<p style="margin:0px;font-size: 16px;text-indent: 32px;"><b>敬礼！</b></p>
						<p style="margin:0px;padding-right:60px;font-size: 16px;text-align:right;"><b>${name}</b></p>
						<p style="margin:0px;padding-right:15px;font-size: 16px;text-align:right;"><b>2019年2月5日</b></p>

						<br/>
						<hr style="border-top:1px dashed #bbb;"/>
					</div>
				</div>
			</div>
		</div>
		<i class="flush-1" data-reactid=".0.0.0.0"></i>
		<i class="flush-2" data-reactid=".0.0.0.1"></i>
		<i class="flush-3" data-reactid=".0.0.0.2"></i>
		<i class="flush-4" data-reactid=".0.0.0.3"></i>
		<i class="flush-5" data-reactid=".0.0.0.4"></i>
	</div>


<script type="text/javascript">
	
</script>
</body>
</html>
