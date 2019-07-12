layui.use(['form', 'layer', 'table', 'laytpl'], function() {
	var form = layui.form,
		layer = parent.layer === undefined ? layui.layer : top.layer,
		$ = layui.jquery,
		laytpl = layui.laytpl,
		table = layui.table;

	//用户列表
	var tableIns = table.render({
		elem: '#userList',
		url: '/miMall/getGoods',
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
					field: 'itemName',
					title: '商品名称',
					minWidth: 100,
					align: "center"
				},
				{
					field: 'itemKind',
					title: '商品类别',
					minWidth: 100,
					align: "center"
				},
				{
					field: 'introduce',
					title: '商品介绍',
					align: 'center'
				},
				{
					field: 'status',
					title: '起售状态',
					align: 'center'
				},
				{
					field: 'price',
					title: '商品价格',
					align: 'center'
				},
				{
					field: 'discount',
					title: '商品折扣',
					align: 'center'
				},
				{
					field: 'sail',
					title: '商品销量',
					align: 'center'
				}, 
				{
					field: 'remain',
					title: '库存量',
					align: 'center'
				}, 
				{
					field: 'releaseTime',
					title: '发布日期',
					align: 'center',
					minWidth: 150
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
			title: "添加/修改商品",
			type: 2,
			content: "userAdd.html",
			success: function(layero, index) {
				var body = layui.layer.getChildFrame('body', index);
				if(edit) {
					body.find(".itemName").val(edit.itemName); //登录名
					body.find(".itemKind").val(edit.itemKind); //邮箱
					body.find(".introduce").val(edit.introduce); //性别
					body.find(".price").val(edit.price); //会员等级
					body.find(".discount").val(edit.discount); //用户状态
					body.find(".sail").text(edit.sail); //用户简介
					body.find(".remain").val(edit.remain);
					body.find(".releaseTime").val(edit.releaseTime);
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
			itemIds = [];
		if(data.length > 0) {
			for(var i in data) {
				itemIds.push(data[i].itemId);
			}
			layer.confirm('确定删除选中的商品？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				$.get("/miMall/deleteGoods",{
				    itemIds : itemIds  //将需要删除的newsId作为参数传入
				},function(data){
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
			layer.confirm('确定删除此商品？', {
				icon: 3,
				title: '提示信息'
			}, function(index) {
				itemIds = []
				itemIds.push(data.itemId)
				$.post("/miMall/deleteGoods",{
				    itemIds : itemIds  //将需要删除的newsId作为参数传入
				},function(data){
					tableIns.reload();
					layer.close(index);
				})
			});
		}
	});

})