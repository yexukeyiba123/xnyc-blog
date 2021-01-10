$(function(){
    //退出登录
	$("div.exit").click(function(){
        $.ajax({
            url: "/manager/loginout",
            type: 'post',
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data: JSON.stringify({}),
            success: function(resp){
                if (XNYC_CONSTANT.RESULT_CODE.SUCCESS == resp.resultCode) {
                    window.location.href = "managerIndex.html";
                }
            }
        })
    });
});