layui.use(['form', 'layer'], function() {
	var form = layui.form
	layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery;

	form.on("submit(addUser)", function(data) {
		//弹出loading
		var index = top.layer.msg('数据提交中，请稍候', {
			icon: 16,
			time: false,
			shade: 0.8
		});
		$.post("/miMall/uploadGoods",{
		    itemName : $(".itemName").val(),  //登录名
		    itemKind : $(".itemKind").val(),  //邮箱
		    introduce : $(".introduce").val(),  //性别
		    price : $(".price").val(),  //会员等级
		    discount : $(".discount").val(),    //用户状态
		    remain : $(".remain").val(),
		    date : $(".releaseTime").val(),    //添加时间
		},function(res){
			top.layer.close(index);
			top.layer.msg("添加成功！");
			layer.closeAll("iframe");
			parent.location.reload();
		})
		return false;
	})

	//格式化时间
	function filterTime(val) {
		if(val < 10) {
			return "0" + val;
		} else {
			return val;
		}
	}
	//定时发布
	var time = new Date();
	var submitTime = time.getFullYear() + '-' + filterTime(time.getMonth() + 1) + '-' + filterTime(time.getDate()) + ' ' + filterTime(time.getHours()) + ':' + filterTime(time.getMinutes()) + ':' + filterTime(time.getSeconds());
})