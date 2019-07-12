layui.use(['form', 'layer', 'laydate', 'table', 'upload'], function() { 
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery,
		laydate = layui.laydate,
		upload = layui.upload,
		table = layui.table;

	//友链列表
	var tableIns = table.render({
		elem: '#linkList',
		url: '/miMall/kind',
		page: true,
		cellMinWidth: 95,
		height: "full-104",
		limit: 20, 
		limits: [10, 15, 20, 25],
		id: "linkListTab",
		cols: [
			[
				{
					type: "checkbox",
					fixed: "left",
					width: 50
				},
				{
					field: 'kindId',
					title: 'ID',
					width: 60,
					align: "center"
				},
				{
					field: 'kindName',
					title: '敏感词',
					minWidth: 240
				},
			]
		]
	});

	//搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	$(".search_btn").on("click", function() {
		table.reload("linkListTab", {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				key: $(".searchVal").val() //搜索的关键字
			}
		})
	});

	//添加友链
	function addLink(edit) {
		var index = layer.open({
			title: "添加类别",
			type: 2,
			area: ["300px", "185px"],
			content: "page/kindManagement/linksAdd.html",
			success: function(layero, index) {
				var body = $($(".layui-layer-iframe", parent.document).find("iframe")[0].contentWindow.document.body);
				if(edit) {
					body.find(".linkLogo").css("background", "#fff");
					body.find(".linkLogoImg").attr("src", edit.logo);
					body.find(".linkName").val(edit.websiteName);
					body.find(".linkUrl").val(edit.websiteUrl);
					body.find(".masterEmail").val(edit.masterEmail);
					body.find(".showAddress").prop("checked", edit.showAddress);
					form.render();
				}
				setTimeout(function() {
					layui.layer.tips('点击此处返回类别管理列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}, 500)
			}
		})
	}
	$(".addLink_btn").click(function() {
		addLink();
	})

	//批量删除
	$(".delAll_btn").click(function() {
		var checkStatus = table.checkStatus('linkListTab'),
			data = checkStatus.data,
			kindIds = [];
		if(data.length > 0) {
			for(var i in data) {
				kindIds.push(data[i].kindId);
			}
			layer.confirm('确定删除选中的分类？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("/miMall/deleteKind",{
				     kindIds:kindIds
				},function(data){
					tableIns.reload();
					layer.close(index);
				})
			})
		} else {
			layer.msg("请选择需要删除的文章");
		}
	})

	//列表操作
	table.on('tool(linkList)', function(obj) {
		var layEvent = obj.event,
			data = obj.data;

		if(layEvent === 'edit') { //编辑
			addLink(data);
		} else if(layEvent === 'del') { //删除
			layer.confirm('确定删除此友链？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				// $.get("删除友链接口",{
				//     linkId : data.linkId  //将需要删除的linkId作为参数传入
				// },function(data){
				tableIns.reload();
				layer.close(index);
				// })
			});
		}
	});

	//上传logo
	upload.render({
		elem: '.linkLogo',
		url: '../../json/linkLogo.json',
		method: "get", //此处是为了演示之用，实际使用中请将此删除，默认用post方式提交
		done: function(res, index, upload) {
			var num = parseInt(4 * Math.random()); //生成0-4的随机数，随机显示一个头像信息
			$('.linkLogoImg').attr('src', res.data[num].src);
			$('.linkLogo').css("background", "#fff");
		}
	});

	//格式化时间
	function filterTime(val) {
		if(val < 10) {
			return "0" + val;
		} else {
			return val;
		}
	}
	//添加时间
	var time = new Date();
	var submitTime = time.getFullYear() + '-' + filterTime(time.getMonth() + 1) + '-' + filterTime(time.getDate()) + ' ' + filterTime(time.getHours()) + ':' + filterTime(time.getMinutes()) + ':' + filterTime(time.getSeconds());

	form.on("submit(addLink)", function(data) {
		//弹出loading
		var index = top.layer.msg('数据提交中，请稍候', {
			icon: 16,
			time: false,
			shade: 0.8
		});
		$.post("/miMall/addKind",{
		     kindName : $("#kindName").val(),
		},function(res){
			if(res==200){
				top.layer.close(index);
				top.layer.msg("添加成功！");
				layer.closeAll("iframe");
				//刷新父页面
				$(".layui-tab-item.layui-show", parent.document).find("iframe")[0].contentWindow.location.reload();
			}
			else{
				top.layer.close(index);
				top.layer.msg("添加失败！");
				layer.closeAll("iframe");
				//刷新父页面
				$(".layui-tab-item.layui-show", parent.document).find("iframe")[0].contentWindow.location.reload();
			}
		})
		return false;
	})

})