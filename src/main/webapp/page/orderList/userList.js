layui.use(['form', 'layer', 'table', 'laytpl'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery,
		laytpl = layui.laytpl,
		table = layui.table;

	//用户列表
	var tableIns = table.render({
		elem: '#userList',
		url: '/miMall/getOrders',
		cellMinWidth: 95,
		page: true,
		height: "full-125",
		limits: [10, 15, 20, 25],
		limit: 20,
		id: "userListTable",
		cols: [
			[{
					type: "checkbox",
					fixed: "left",
					width: 50
				},
				{
					field: 'orderNum',
					title: '订单编号',
					minWidth: 100,
					align: "center"
				},
				{
					field: 'orderStatus',
					title: '订单状态',
					minWidth: 100,
					align: "center"
				},
				{
					field: 'orderTime',
					title: '订单时间',
					align: 'center'
				}, {
					field: 'buyer',
					title: '买家昵称',
					align: 'center'
				},
				{
					field: 'address',
					title: '收货地址',
					align: 'center'
				},
				{
					field: 'itemName',
					title: '商品名称',
					align: 'center'
				},
				{
					field: 'itemNum',
					title: '商品数量',
					align: 'center'
				},
				{
					field: 'orderPrice',
					title: '订单总付款',
					align: 'center'
				},
				{
					title: '操作',
					minWidth: 175,
					templet: '#userListBar',
					fixed: "right",
					align: "center"
				}
			]
		]
	});

	//搜索【此功能需要后台配合，所以暂时没有动态效果演示】
	$(".search_btn").on("click", function() {
		table.reload("userListTable", {
			page: {
				curr: 1 //重新从第 1 页开始
			},
			where: {
				key: $(".searchVal").val() //搜索的关键字
			}
		})
	});

	//添加用户
	function addUser(edit) {
		var index = layui.layer.open({
			title: "添加商品",
			type: 2,
			content: "userAdd.html",
			success: function(layero, index) {
				var body = layui.layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0].contentWindow;
				if(edit) {
					body.find(".orderNum").val(edit.orderNum);
					body.find(".itemName").val(edit.itemName); //登录名
					body.find(".itemKind").val(edit.itemKind); //邮箱
					body.find(".orderTime").val(edit.orderTime); //性别
					body.find(".price").val(edit.orderPrice); //会员等级
					if(edit.orderStatus=="未发货") body.find("#orderStatus").val("0");
					if(edit.orderStatus=="已发货") body.find("#orderStatus").val("1");
					if(edit.orderStatus=="已收货"){
						body.find("#orderStatus").val("2");
						body.find("#orderStatus").attr("disabled","true");
					}
					form.render();
				}
				setTimeout(function() {
					layui.layer.tips('点击此处返回商品列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				}, 500)
			}
		})
		layui.layer.full(index);
		window.sessionStorage.setItem("index", index);
		//改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
		$(window).on("resize", function() {
			layui.layer.full(window.sessionStorage.getItem("index"));
		})
	}
	$(".addNews_btn").click(function() {
		addUser();
	})

	//批量删除
	$(".delAll_btn").click(function() {
		var checkStatus = table.checkStatus('userListTable'),
			data = checkStatus.data,
			ordersId = [];
		if(data.length > 0) {
			for(var i in data) {
				ordersId.push(data[i].usersId);
			}
			layer.confirm('确定删除选中的订单？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.get("/miMall/deleteOrders",{
					ordersId : ordersId  //将需要删除的newsId作为参数传入
				},function(data){
					if(data==0)
						layer.msg("删除成功");
					else
						layer.msg(data+"条数据，删除失败");
					tableIns.reload();
					layer.close(index);
				})
			})
		} else {
			layer.msg("请选择需要删除的商品");
		}
	})

	//列表操作
	table.on('tool(userList)', function(obj) {
		var layEvent = obj.event,
			data = obj.data;
			ordersId = [];
			ordersId.push(data.usersId);
		if(layEvent === 'edit') { //编辑
			addUser(data);
		} else if(layEvent === 'usable') { //启用禁用
			var _this = $(this),
				usableText = "是否确定禁用此用户？",
				btnText = "已禁用";
			if(_this.text() == "已禁用") {
				usableText = "是否确定启用此用户？",
					btnText = "已启用";
			}
			layer.confirm(usableText, {
				icon: 3,
				title: '系统提示',
				cancel: function(index) {
					layer.close(index);
				}
			}, function(index) {
				_this.text(btnText);
				layer.close(index);
			}, function(index) {
				layer.close(index);
			});
		} else if(layEvent === 'del') { //删除
			layer.confirm('确定删除此订单？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.get("/miMall/deleteOrders",{
				    ordersId : ordersId  //将需要删除的newsId作为参数传入
				},function(data){
					if(data==0)
						layer.msg("删除成功");
					else
						layer.msg(data+"条数据，删除失败");
					tableIns.reload();
					layer.close(index);
				})
			});
		}
	});

})