<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加类别",
            handler: function () {
                $("#addCategoryDialog").dialog({
                    title: "添加类别",
                    width: 500,
                    height: 300,
                    href: "${pageContext.request.contextPath}/category/AddCategory.jsp"
                })
            }
        }, '-', {
            text: "添加类别书籍",
            iconCls: 'icon-add',
            handler: function () {
                $("#addCategoryDia").dialog({
                    title: "添加类别书籍",
                    width: 500,
                    height: 300,
                    href: "${pageContext.request.contextPath}/category/categoryAdd.jsp"
                })
            }
        }
        ]


        $('#category').treegrid({
            method: "post",
            url: '${pageContext.request.contextPath}/category/showAll',
            idField: 'id',
            treeField: 'categoryName',
            onLoadSuccess: function () {
                $('#category').treegrid("collapseAll");
            },
            columns: [[
                {field: 'categoryName', title: '类别名称', width: 60,},
                {field: "status", title: '状态', formatter: formatterStatus, width: 80},
                {field: 'time', title: '上架时间', width: 80},
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar
        });


    })

    function formatterStatus(value) {
        if (value == 1) {
            return "上架中";
        } else if (value == 0) {
            return "售空(下架)";
        } else {
            return "";
        }
    }


</script>


<table id="category"></table>
<div id="addCategoryDialog"></div>
<div id="addCategoryDia"></div>


