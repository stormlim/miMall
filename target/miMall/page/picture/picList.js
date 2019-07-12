layui.use(['form', 'layer', 'laydate', 'table', 'upload'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery,
		laydate = layui.laydate,
		upload = layui.upload,
		table = layui.table;

	//执行实例
	var upload = layui.upload;
	var uploadInst = upload.render({
		elem: '#test1' //绑定元素
			,
		url: '/miMall/uploadGoodsPicture' //上传接口
			,
		accept: 'file',
		exts: "jpg|png",
		data: {
			picId: $("#picId").val()
		},
		done: function(res) {
			if(res == 200) {
				layer.msg("更换成功,请刷新页面")
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
			} else {
				layer.msg("更换失败")
			}
		},
		error: function() {
			layer.msg("异常")
		}
	});
//	var uploadInst2 = upload.render({
//		elem: '#test2',
//		url: '/miMall/uploadGoodsPicture',
//		accept: 'image',
//		auto: false,
//		bindAction: "#test3",
//		method:"POST",
//		data: {
//			goodsDetailId : $("#goods").val()
//		},
//		done: function(res) {
//			layer.msg("上传成功")
//			var index = parent.layer.getFrameIndex(window.name);
//			parent.layer.close(index);
//		},
//		error: function() {
//			layer.msg("上传失败")
//		}
//	});

	//友链列表
	var tableIns = table.render({
		elem: '#linkList',
		url: '/miMall/getGoodsPicture',
		page: true,
		cellMinWidth: 95,
		height: "full-104",
		limit: 10,
		limits: [10, 15, 20, 25],
		id: "linkListTab",
		cols: [
			[{
					type: "checkbox",
					fixed: "left",
					width: 50
				},
				{
					type: "numbers",
					width: 50
				},
				{
					field: 'picSrc',
					title: '商品图片',
					minWidth: 200,
					align: 'center',
					templet: function(d) {
						return '<a href="javascript:void(0);" onclick=\'$(\"img\").imgZoom();\'><img src="' + d.picSrc + '"data-src="' + d.picSrc + '" alt="" height="100%" > </a>';
					}
				},
				{
					field: 'itemName',
					title: '商品名称',
					align: 'center'
				},
				{
					title: '修改图片',
					width: 170,
					templet: '#newsListBar',
					fixed: "right",
					align: "center"
				}
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
				value: $(".searchVal").val() //搜索的关键字
			}
		})
	});

	//批量禁用
	$(".delAll_btn").click(function() {
		var checkStatus = table.checkStatus('linkListTab'),
			data = checkStatus.data,
			linkId = [];

		if(data.length > 0) {
			for(var i in data) {
				linkId.push(data[i].picId);
			}

			layer.confirm('确定禁用选中的图片？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				// $.get("删除文章接口",{
				// newsId : newsId //将需要删除的newsId作为参数传入
				// },function(data){

				$.ajax({
					type: "POST", //方法类型
					async: false,
					dataType: "json", //预期服务器返回的数据类型
					url: "/allBan", //url
					data: {
						"indexList": linkId
					},
					success: function(result) {},
					error: function() {
						console.log("异常");
					}
				});

				location.replace(location.href);
				tableIns.reload();
				layer.close(index);
				// })
			})
		} else {
			layer.msg("请选择需要禁用的图片");
		}
	})

	//列表操作
	table.on('tool(linkList)', function(obj) {
		var layEvent = obj.event,
			data = obj.data;
		if(layEvent === 'upload') { //上传封面
			//			console.log("-------")
			var index = layui.layer.open({
				title: "修改图片",
				type: 2,
				area: ["200px", "150px"],
				content: "uploadImage.html",
				success: function(layero, index) {
					var body = layui.layer.getChildFrame('body', index);
					var iframeWin = layero.find('iframe')[0].contentWindow;
					body.find(".picId").val(obj.data.linkId);
					setTimeout(function() {
						layui.layer.tips('点击此处返回图片列表', '.layui-layer-setwin .layui-layer-close', {
							tips: 3
						});
					}, 500)
				}
			})
		}
		if(layEvent === 'edit') { //查看
			addLink(data);
		}
		//		else if(layEvent === 'del') { //删除
		//			layer.confirm('确定删除此友链？', {
		//				icon: 3,
		//				title: '提示信息'
		//			}, function(index) {
		//				// $.get("删除友链接口",{
		//				//     linkId : data.linkId  //将需要删除的linkId作为参数传入
		//				// },function(data){
		//				tableIns.reload();
		//				layer.close(index);
		//				// })
		//			});
		//		}
	});

	

	//添加友链
	function addLink(edit) {
		var index = layer.open({
			title: "添加图片",
			type: 2,
			area: ["300px", "225px"],
			content: "page/picture/linksAdd.html",
			success: function(layero, index) {
				var iframeWin = layero.find('iframe')[0].contentWindow;
				var body = $($(".layui-layer-iframe", parent.document).find("iframe")[0].contentWindow.document.body);
				var option="<option value='0'>请选择商品</option>";
				$.ajax({
					url:"/miMall/getGoodsDetail",
					dataType:"json",
					type:"post",
					success:function(result){
						for(var i=0;i<result.length;i++){
							option+="<option value='"+result[i].goodsDetailId+"'>"+result[i].goodsDetailName+"</option>";
						}
						body.find(".goods").html(option);
						iframeWin.layui.form.render();
					},
					error:function(){
						layer.msg("异常");
					}
				})
				setTimeout(function() {
					layui.layer.tips('点击此处返回类别管理列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}, 500)
			}
		})
		
	}
	$(".addPic_btn").click(function() {
		addLink();
	})

	$(".sure").click(function() {
		console.log("yeah")
		layer.closeAll("iframe");
		//刷新父页面
		$(".layui-tab-item.layui-show", parent.document).find("iframe")[0].contentWindow.location.reload();

	})

})