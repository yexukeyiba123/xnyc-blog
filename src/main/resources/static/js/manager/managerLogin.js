$(function(){
	/*=================== input获得焦点和失去焦点事件  begin ======================*/
	$("input[id=username]").focus(function(){
		if($(this).val().length==0){
			$("span.tip_username").animate({"bottom":"45px","fontSize":"12px","left":"180px"},500);
		}	
		$("span.sn_username").css({"background-position":"-50px 0px"});
		$("div#un").css({"borderBottom":"1px solid #333"});
		$("div.message").css("display","none");
	});
	$("input[id=username]").blur(function(){
		if($(this).val().length==0){
			$("span.tip_username").animate({"bottom":"10px","fontSize":"18px","left":"170px"},500);
		}	
		$("span.sn_username").css({"background-position":"0px 0px"});
		$("div#un").css({"borderBottom":"1px solid #ccc"});
	});
	$("input[id=password]").focus(function(){
		if($(this).val().length==0){
			$("span.tip_password").animate({"bottom":"45px","fontSize":"12px","left":"185px"},500);
		}	
		$("span.sn_password").css({"background-position":"-50px -45px"});
		$("div#pw").css({"borderBottom":"1px solid #333"});
		$("div.message").css("display","none");
	});
	$("input[id=password]").blur(function(){
		if($(this).val().length==0){
			$("span.tip_password").animate({"bottom":"10px","fontSize":"18px","left":"182px"},500);
		}		
		$("span.sn_password").css({"background-position":"0px -45px"});
		$("div#pw").css({"borderBottom":"1px solid #ccc"});
	});
	/*=================== input获得焦点和失去焦点事件  end ======================*/
	$("button#login").click(function(){
		if($("input[id=username]").val().length == 0){
			$("div.message").css("display","block");
			$("div.message>span").text("请输入用户名！");
			return ;
		}
		if($("input[id=password]").val().length == 0){
			$("div.message").css("display","block");
			$("div.message>span").text("请输入密码！");
			return ;
		}
		$("button#login").text("正在登录......");
		$.ajax({
			url: "/manager/login",
			type: 'post',
			dataType: "json",
			contentType:"application/json;charset=UTF-8",
			data: JSON.stringify({
			        opId: XNYC_CONSTANT.OP_ID.SYSTEM,
			        opType: XNYC_CONSTANT.OP_TYPE.SYSTEM,
					loginName: $("input[id=username]").val(),
					password: $("input[id=password]").val()
				}),
			success: function(resp){
			    if (XNYC_CONSTANT.RESULT_CODE.SUCCESS == resp.resultCode) {
			        window.location.href = "managerIndex.html";
			    } else {
			        $("div.message").css("display","block");
                	$("div.message>span").text(resp.description);
			    }
			    $("button#login").text("登录");
			}
		})
	});
})