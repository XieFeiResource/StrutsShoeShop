<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.scheme }://${pageContext.request.serverName}:${pageContext.request.serverPort}/strutsShoeShopServer/">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>

<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">	
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>	
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>

</head>
<body>

<table id="tg" title="用户信息" style="width:100%;height:400px"
			data-options="
				iconCls: 'icon-ok',
				rownumbers: true,
				animate: true,
				collapsible: true,
				fitColumns: true,
				url: 'UserAction!showAllUsers.action',
				method: 'get',
				idField: 'id',
				treeField: 'name',
				pagination: true,
				pageSize: 2,
				pageList: [2,5,10]
			">
		<thead>
			<tr>
				<th data-options="field:'userid',width:80,align:'left'">用户编号</th>
				<th data-options="field:'image',width:80,align:'left'">头像</th>
				<th data-options="field:'username',width:80,align:'left'">账号</th>
				<th data-options="field:'nickname',width:80,align:'left'">昵称</th>
				<th data-options="field:'sex',width:40,align:'left'">性别</th>
				<th data-options="field:'age',width:40,align:'left'">年龄</th>
				<th data-options="field:'job',width:60,align:'left'">职业</th>
				<th data-options="field:'email',width:80,align:'left'">邮箱</th>
				<th data-options="field:'tel',width:80,align:'left'">电话</th>				
				
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		(function($){
			function pagerFilter(data){
		        if ($.isArray(data)){    // is array  
		            data = {  
		                total: data.length,  
		                rows: data  
		            }  
		        }
		        var target = this;
		        var tg = $(target);  
				var state = tg.data('treegrid');
		        var opts = tg.treegrid('options');  
		        if (!state.allRows){
		        	state.allRows = data.rows;
		        }
				if (!opts.remoteSort && opts.sortName){
					var names = opts.sortName.split(',');
					var orders = opts.sortOrder.split(',');
					state.allRows.sort(function(r1,r2){
						var r = 0;
						for(var i=0; i<names.length; i++){
							var sn = names[i];
							var so = orders[i];
							var col = $(target).treegrid('getColumnOption', sn);
							var sortFunc = col.sorter || function(a,b){
								return a==b ? 0 : (a>b?1:-1);
							};
							r = sortFunc(r1[sn], r2[sn]) * (so=='asc'?1:-1);
							if (r != 0){
								return r;
							}
						}
						return r;
					});
				}
		        var topRows = [];
		        var childRows = [];
		        $.map(state.allRows, function(row){
		        	row._parentId ? childRows.push(row) : topRows.push(row);
		        	row.children = null;
		        });
		        data.total = topRows.length;
		        var pager = tg.treegrid('getPager');
		        pager.pagination('refresh', {
		        	total: data.total,
		        	pageNumber: opts.pageNumber
		        });
		        opts.pageNumber = pager.pagination('options').pageNumber || 1;
		        var start = (opts.pageNumber-1)*parseInt(opts.pageSize);  
		        var end = start + parseInt(opts.pageSize);  
				data.rows = topRows.slice(start, end).concat(childRows);
				return data;
			}

			var appendMethod = $.fn.treegrid.methods.append;
			var removeMethod = $.fn.treegrid.methods.remove;
			var loadDataMethod = $.fn.treegrid.methods.loadData;
			$.extend($.fn.treegrid.methods, {
				clientPaging: function(jq){
					return jq.each(function(){
						var tg = $(this);
						var state = tg.data('treegrid');
						var opts = state.options;
						opts.loadFilter = pagerFilter;
						var onBeforeLoad = opts.onBeforeLoad;
						opts.onBeforeLoad = function(row,param){
							state.allRows = null;
							return onBeforeLoad.call(this, row, param);
						}
						var pager = tg.treegrid('getPager');
						pager.pagination({
							onSelectPage:function(pageNum, pageSize){
								opts.pageNumber = pageNum;
								opts.pageSize = pageSize;
								pager.pagination('refresh',{
									pageNumber:pageNum,
									pageSize:pageSize
								});
								tg.treegrid('loadData',state.allRows);
							}
						});
						tg.treegrid('loadData', state.data);
						if (opts.url){
							tg.treegrid('reload');
						}
					});
				},
				loadData: function(jq, data){
					jq.each(function(){
						$(this).data('treegrid').allRows = null;
					});
					return loadDataMethod.call($.fn.treegrid.methods, jq, data);
				},
				append: function(jq, param){
					return jq.each(function(){
						var state = $(this).data('treegrid');
						if (state.options.loadFilter == pagerFilter){
							$.map(param.data, function(row){
								row._parentId = row._parentId || param.parent;
								state.allRows.push(row);
							});
							$(this).treegrid('loadData', state.allRows);
						} else {
							appendMethod.call($.fn.treegrid.methods, $(this), param);
						}
					})
				},
				remove: function(jq, id){
					return jq.each(function(){
						if ($(this).treegrid('find', id)){
							removeMethod.call($.fn.treegrid.methods, $(this), id);
						}
						var state = $(this).data('treegrid');
						if (state.options.loadFilter == pagerFilter){
							for(var i=0; i<state.allRows.length; i++){
								if (state.allRows[i][state.options.idField] == id){
									state.allRows.splice(i,1);
									break;
								}
							}
							$(this).treegrid('loadData', state.allRows);
						}
					})
				},
				getAllRows: function(jq){
					return jq.data('treegrid').allRows;
				}
			});

		})(jQuery);

		function formatProgress(value){
	    	if (value){
		    	var s = '<div style="width:100%;border:1px solid #ccc">' +
		    			'<div style="width:' + value + '%;background:#cc0000;color:#fff">' + value + '%' + '</div>'
		    			'</div>';
		    	return s;
	    	} else {
		    	return '';
	    	}
		}
		
		$(function(){
			$('#tg').treegrid().treegrid('clientPaging');
		})
	</script>



</body>
</html>