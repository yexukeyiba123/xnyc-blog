$(function(){
    $(".buttonPage .query").click(function(){
        $.ajax({
            url: "/category/query/by_id",
            type: 'post',
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data: JSON.stringify({
                    opId: XNYC_CONSTANT.OP_ID.SYSTEM,
                    opType: XNYC_CONSTANT.OP_TYPE.SYSTEM,
                    categoryId:null,
                    querySub:true
                }),
            success: function(resp){
                if (XNYC_CONSTANT.RESULT_CODE.SUCCESS == resp.resultCode) {
                    if (resp.categoryList && resp.categoryList.length > 0) {
                        $(".categoryShowPage").html(getCategoryDetailHtml(resp, ""));
                    }
                } else {
                    alert(resp.description);
                }
            }
        })
    });
});

function getCategoryDetailHtml(resp, time) {
    var html = '';
    for(var i = 0; i < resp.categoryList.length; i ++) {
        var category = resp.categoryList[i];
        html += '<div class="category '+ time + ' category-' + category.categoryLevel + '" onclick="categoryOnClick(this)">';
        html += '<span>' + category.categoryLevel + '</span>';
        html += '<span class="categoryId">' + category.categoryId + '</span>';
        html += '<span>' + category.categoryName + '</span>';
        html += '<span>' + (category.status == "1" ? '启用' : '停用') + '</span>';
        html += '<span>' + category.createTime + '</span>';
        html += '<span>' + category.lastModifyTime + '</span>';
        html += '<span class="delete" onclick="deleteCategory(this)">删除</span>';
        html += '</div>';
    }
    return html;
}

//click事件要在元素添加完成后在注册
function categoryOnClick(s) {
    var self = $(s);
    $.ajax({
        url: "/category/query/by_id",
        type: 'post',
        dataType: "json",
        contentType:"application/json;charset=UTF-8",
        data: JSON.stringify({
                opId: XNYC_CONSTANT.OP_ID.SYSTEM,
                opType: XNYC_CONSTANT.OP_TYPE.SYSTEM,
                categoryId:self.find("span.categoryId").text(),
                querySub:true
            }),
        success: function(resp){
            if (XNYC_CONSTANT.RESULT_CODE.SUCCESS == resp.resultCode) {
                if (resp.categoryList && resp.categoryList.length > 0) {
                    //先移除原来的元素
                    var dataValue = self.attr("data");
                    self.nextAll("." + dataValue).remove();
                    //重新添加元素
                    var time = getTimeOfyyyyMMddHHmmssSSS();
                    self.attr("data", time);
                    self.after(getCategoryDetailHtml(resp, time));
                }
            } else {
                alert(resp.description);
            }
        }
    });
}

//删除分类
function deleteCategory(s) {
     var parent = $(s).parent(".category");
     $.ajax({
         url: "/category/delete/by_id",
         type: 'post',
         dataType: "json",
         contentType:"application/json;charset=UTF-8",
         data: JSON.stringify({
                 opId: XNYC_CONSTANT.OP_ID.SYSTEM,
                 opType: XNYC_CONSTANT.OP_TYPE.SYSTEM,
                 categoryId:parent.find("span.categoryId").text()
             }),
         success: function(resp){
             if (XNYC_CONSTANT.RESULT_CODE.SUCCESS == resp.resultCode) {
                 parent.remove();
             } else {
                 alert(resp.description);
             }
         }
     });
}



