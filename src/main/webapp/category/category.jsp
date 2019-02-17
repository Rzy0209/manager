<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
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