//buildinginfo:function(){
//$.ajax{
//	url:"buildinginfo",
//	dataType:"text",
//	Type:"post",
//	success:function(data){
//		console.log(data);
//	}
//}
//}

var TableInit = function () {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function () {
		$('#tb_room').bootstrapTable({
			url: '/buildingroom', //请求后台的URL（*）
			method: 'post', //请求方式（*）
			toolbar: '#toolbar', //工具按钮用哪个容器
			striped: true, //是否显示行间隔色
			cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true, //是否显示分页（*）
			sortable: false, //是否启用排序
			sortOrder: "asc", //排序方式
			queryParams: oTableInit.queryParams, //传递参数（*）
			sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
			pageNumber: 1, //初始化加载第一页，默认第一页
			pageSize: 10, //每页的记录行数（*）
			pageList: [10, 25, 50, 100], //可供选择的每页的行数（*）
			search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,
			showColumns: true, //是否显示所有的列
			showRefresh: true, //是否显示刷新按钮
			minimumCountColumns: 2, //最少允许的列数
			clickToSelect: true, //是否启用点击选中行
			// height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "id", //每一行的唯一标识，一般为主键列
			showToggle: true, //是否显示详细视图和列表视图的切换按钮
			cardView: false, //是否显示详细视图
			detailView: false, //是否显示父子表
			columns: [{
				checkbox: true
			}, {
				field: 'roomId',
				title: '房间id',

			}, {
				field: 'isIn',
				title: '状态',
				formatter: function (value, row, index) {
					console.log('sdfsdfdsf' + row.isIn);
					console.log(row.isIn == '0');
					if (value != '0') {
						return '<i class="fa fa-lock" style="color:red"></i>'
					} else if (value == '0') {
						return '<i class="fa fa-unlock" style="color:green"></i>'; //
					}
				}
			}, {
				field: 'description',
				title: '备注',
			}, {
				title: '欢迎',
				formatter: function (value, row, index) {
					if (row.isIn == 0) { //模态框						
						return '<button type="button" class="btn btn-success name="bookRoom" onclick="book('+row.roomId +')" >入住</button>';//<h1 onclick="changetext(this)">点击文本!</h1>
					} else if (row.isIn != 0) {
						return '<button type="button" class="btn btn-default" disabled="disabled">入住</button>';
					}
				}
			}],
		});
	};