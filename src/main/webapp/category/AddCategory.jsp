<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#categoryName").textbox({
            required: true
        }),
            $("#id").textbox({
                required: true,
                prompt: '000001'
            })

        $("#addCategoryBtn").linkbutton({
            iconCls: "icon-add",
            plain: true,
            onClick: function () {
                $("#addCategoryForm").form("submit", {
                    url: "${pageContext.request.contextPath}/category/addCategory",
                    onSubmit: function () {
                        return true;
                    },
                    success: function () {
                        $("#addCategoryDialog").dialog("close");
                        $.messager.show({
                            title: '消息消息',
                            msg: '成功添加一个类别',
                            timeout: 400,
                            showType: 'slide'
                        });
                        url:"${pageContext.request.contextPath}/category/showAll"
                    }
                })
            }
        });

        $("#clearCategoryBtn").linkbutton({
            onClick: function () {
                $("#addCategoryForm").form("clear")
            }
        })
    })
</script>
<form id="addCategoryForm" method="post">

    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">
        <tr>
            <td valign="middle" align="right">
                类别名称:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="categoryName" id="categoryName"/>
            </td>
        </tr>
    </table>

    <p>
        <a id="addCategoryBtn">添加</a>
        <a id="clearCategoryBtn">重置</a>
    </p>

</form>