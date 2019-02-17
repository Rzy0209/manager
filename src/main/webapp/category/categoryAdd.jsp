<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        $("#sid").textbox({
            required: true,
            prompt: '000000'
        })

        $("#cname").textbox({
            required: true
        }),

            $("#pid").textbox({
                required: true
            }),
            $("#status").switchbutton({
                checked: true,
                onText: "上架",
                offText: "下架",
            }),
            $("#time").datebox({
                required: true,
                editable: false
            })

        $("#categoryAddBtn").linkbutton({
            iconCls: "icon-add",
            plain: true,
            onClick: function () {
                $("#categoryAddForm").form("submit", {
                    url: "${pageContext.request.contextPath}/category/categoryAdd",
                    onSubmit: function () {
                        return true;
                    },
                    success: function () {
                        $("#addCategoryDia").dialog("close");
                        $.messager.show({
                            title: '消息消息',
                            msg: '成功添加所属分类',
                            timeout: 400,
                            showType: 'slide'
                        });
                        $("#category").treegrid("reload")
                    }
                })
            }
        })

        $("#clearBtn").linkbutton({
            onClick: function () {
                $("#categoryAddForm").form("clear")
            }
        })

    })
</script>

<form id="categoryAddForm" method="post">

    <table cellpadding="0" cellspacing="0" border="0"
           class="form_table">

        <tr>
            <td valign="middle" align="right">
                编号:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="id" id="sid"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                名称:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="categoryName" id="cname"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                所属分类:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="pid" id="pid"/>
            </td>
        </tr>

        <tr>
            <td valign="middle" align="right">
                状态:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="status" id="status" value="1"/>
            </td>
        </tr>
        <tr>
            <td valign="middle" align="right">
                上架时间:
            </td>
            <td valign="middle" align="right">
                <input type="text" class="inputgri" name="time" id="time"/>
            </td>
        </tr>

    </table>
    <p>
        <a id="categoryAddBtn">添加</a>
        <a id="clearBtn">重置</a>
    </p>
</form>