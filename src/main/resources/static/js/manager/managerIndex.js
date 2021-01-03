$(function(){
	$.ajax({
		url: "CheckManagerIndex",
		dataType: "text",
		type: 'post',
		data: {
				destination: 1, 
			},
		success: function(data){
			aa(data);
		}
	});
	function aa(data){
		var json = eval("(" + data + ")");
		var oPArticle = getClass("p-article")[0];//p.p-article
		var oPComment = getClass("p-comment")[0];//p.p-comment
		var oPDonate = getClass("p-donate")[0];//p.p-donate
		var oPView = getClass("p-view")[0];//p.p-view
		var oPUser = getClass("p-user")[0];//p.p-user
		oPArticle.innerHTML = "(" + json.article + "篇)";
		oPComment.innerHTML = "(" + json.comment + "条)";
		oPDonate.innerHTML = "(" + json.donate + "人)";
		oPView.innerHTML = "(" + json.view + "条)";
		oPUser.innerHTML = "(" + json.user + "个)";
	}
	
	//“退出”按钮
	var oExit = getClass("exit")[0];//div.exit
	oExit.onclick = function(){
		$.ajax({
			url: "CheckManagerIndex",
			dataType: "text",
			type: 'post',
			data: {
					destination: 2, 
				},
			success: function(data){
				if(data=="1"){
					window.location.href = "managerLogin.jsp";
				}
			}
		});
	};
});