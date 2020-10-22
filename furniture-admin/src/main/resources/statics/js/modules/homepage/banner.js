$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'homepage/banner/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
            { label: 'banner名称', name: 'bannerName', index: 'banner_name', width: 80 },
            { label: '图片地址', name: 'picUrl', index: 'pic_url', width: 80, formatter:function(value, options, row){
                    return '<img src="+value+" width="50%" height="90%" align="center"/>';
            }
            },
            //显示图片缩略图
            { label: '排序', name: 'sort', index: 'sort', width: 80 },
            // { label: '删除', name: 'isDelete', index: 'is_delete', width: 80,
            //     formatter:function(index,row){
            //         var html="<span>";
            //         html += "<a href='javascript:void(0);' title='"+cellvalue+"' @click='deleteBanner(\""+row.id+"\")'>";
            //         html += "<font color='blue'>"+cellvalue;
            //         html += "</font>";
            //         html += "</a></span>";
            //         return html;
            //     }
            //     },

        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		banner: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.banner = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
		    $('#btnSaveOrUpdate').button('loading').delay(1000).queue(function() {
                var url = vm.banner.id == null ? "homepage/banner/save" : "homepage/banner/update";
                $.ajax({
                    type: "POST",
                    url: baseURL + url,
                    contentType: "application/json",
                    data: JSON.stringify(vm.banner),
                    success: function(r){
                        if(r.code === 0){
                             layer.msg("操作成功", {icon: 1});
                             vm.reload();
                             $('#btnSaveOrUpdate').button('reset');
                             $('#btnSaveOrUpdate').dequeue();
                        }else{
                            layer.alert(r.msg);
                            $('#btnSaveOrUpdate').button('reset');
                            $('#btnSaveOrUpdate').dequeue();
                        }
                    }
                });
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			var lock = false;
            layer.confirm('确定要删除选中的记录？', {
                btn: ['确定','取消'] //按钮
            }, function(){
               if(!lock) {
                    lock = true;
		            $.ajax({
                        type: "POST",
                        url: baseURL + "homepage/banner/delete",
                        contentType: "application/json",
                        data: JSON.stringify(ids),
                        success: function(r){
                            if(r.code == 0){
                                layer.msg("操作成功", {icon: 1});
                                $("#jqGrid").trigger("reloadGrid");
                            }else{
                                layer.alert(r.msg);
                            }
                        }
				    });
			    }
             }, function(){
             });
		},
		getInfo: function(id){
			$.get(baseURL + "homepage/banner/info/"+id, function(r){
                vm.banner = r.banner;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        handleAvatarSuccess:function(res, file) {
            console.log(res);
            console.log(file);
            vm.banner.picUr = res.picPath;
            console.log(vm.banner.picUr);
        },
        beforeAvatarUpload:function(file) {
            var testmsg = /^image\/(jpeg|png|jpg)$/.test(file.type)
            const isLt5M = file.size / 1024 / 1024 < 5
            if (!testmsg) {
                this.$message.error('上传图片格式不对!')
                return
            }
            if (!isLt5M) {
                this.$message.error('上传头像图片大小不能超过 5M!')
            }
            return testmsg && isLt5M
        }
	}
});