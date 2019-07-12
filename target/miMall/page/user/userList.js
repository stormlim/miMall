layui.use(['form', 'layer', 'table', 'laytpl'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery,
		laytpl = layui.laytpl,
		table = layui.table;

	//用户列表
	var tableIns = table.render({
		elem: '#userList',
		url: '/miMall/getCustomer',
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
					field: 'userName',
					title: '顾客昵称',
					minWidth: 100,
					align: "center"
				},
				{
					field: 'userPhone',
					title: '顾客手机号',
					minWidth: 100,
					align: "center"
				},
				{
					field: 'address',
					title: '顾客地址',
					minWidth: 100,
					align: "center"
				}, {
					field: 'orderNum',
					title: '总订单数',
					minWidth: 100,
					align: "center"
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
		if($(".searchVal").val() != '') {
			table.reload("userListTable", {
				page: {
					curr: 1 //重新从第 1 页开始
				},
				where: {
					key: $(".searchVal").val() //搜索的关键字
				}
			})
		} else {
			layer.msg("请输入搜索的内容");
		}
	});

	//添加用户
	function addUser(edit) {
		var index = layui.layer.open({
			title: "添加用户",
			type: 2,
			content: "userAdd.html",
			success: function(layero, index) {
				var body = layui.layer.getChildFrame('body', index);
				var iframeWin = layero.find('iframe')[0].contentWindow;
				setTimeout(function() {
					layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
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

	//批量删除
	$(".delAll_btn").click(function() {
		var checkStatus = table.checkStatus('userListTable'),
			data = checkStatus.data,
			usersId = [];
		if(data.length > 0) {
			for(var i in data) {
				usersId.push(data[i].usersId);
			}
			layer.confirm('确定删除选中的用户？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.post("/miMall/deleteCustomer",{
				    usersId : usersId  //将需要删除的newsId作为参数传入
				},function(data){
					if(data==0)
						layer.msg("删除成功");
					else
						layer.msg(data+"位用户无法删除，若必须，请先前往订单管理删除其订单");
					tableIns.reload();
					layer.close(index);
				})
			})
		} else {
			layer.msg("请选择需要删除的用户");
		}
	})

	//列表操作
	table.on('tool(userList)', function(obj) {
		var layEvent = obj.event,
			data = obj.data;
			usersId = [];
			usersId.push(data.usersId);
		if(layEvent === 'del') { //删除
			layer.confirm('确定删除此用户？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.get("/miMall/deleteCustomer",{
				    usersId : usersId  //将需要删除的newsId作为参数传入
				},function(data){
					if(data==0)
						layer.msg("删除成功");
					else
						layer.msg("拥有订单的用户无法删除，若必须，请先前往订单管理删除其订单");
					tableIns.reload();
					layer.close(index);
				})
			});
		}
	});

})