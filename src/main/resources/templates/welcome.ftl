<html lang="en">

<header>
    <#--使用datatables-->
        <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.13/css/jquery.dataTables.css">
    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.13/js/jquery.dataTables.js"></script>
</header>
<body>
<@spring.url value="/xxxx"/>



<#-- freemarker注释-->
Date   :  ${time?date}<br>
Time   :  ${time?time}<br>
message:  ${name}<br>
age    :  ${age?c}<hr>

<#if qksdList?size gt 0>
遍历List：大小${qksdList?size}<br>
<#list qksdList?sort_by("date")?reverse as item >
list索引:${item_index}
<#if !item_has_next >最后一个元素了</#if>
ID:${item.qksdID?c}
password:${item.password}<br>
date: ${item.date?string("yyyy-MM-dd")}
<#-- 给一个默认值-->
age:  ${item.age?default('100')}
<#if (!item_has_next)><#break /></#if>
</#list>
</#if>
<hr>

遍历map:<br>
<#if mapdata?exists>
<#list mapdata?keys as key>
<tr>
<td>${key}</td>
<td>${mapdata[key]}</td>
</tr>
</#list>
</#if>
<hr>

freemaker基础
<#if user??>这个变量是存在的</#if>
${name2!"xxx"}
${person.qksdObj.qksdID!123}


<!--第二步：添加如下 HTML 代码-->
<table id="table_id_example" class="display">
    <thead>
    <tr>
        <th>Column 1</th>
        <th>Column 2</th>
        <th>Column 3</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Row 1 Data 1</td>
        <td>Row 1 Data 2</td>
        <td>Row 1 Data 3</td>
    </tr>
    <tr>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 3</td>
    </tr>
    </tbody>
</table>

<hr>
<table id="table_id_example2" class="display">
    <thead>
    <tr>
        <th>Column 1</th>
        <th>Column 2</th>
        <th>Column 3</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Row 1 Data 1</td>
        <td>Row 1 Data 2</td>
        <td>Row 1 Data 3</td>
    </tr>
    <tr>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 3</td>
    </tr>
    </tbody>
</table>


<table id="ajaxData"></table>
<#include  "copyright_footer.ftl">
</body>
</html>
<script>
    <!--第三步：初始化Datatables-->
    $(document).ready( function () {
        //设置所有表格的属性，可在不同表格做更改覆盖
        $.extend($.fn.dataTable.defaults,{
            searching:false,
            ordering:false
        });
        $('#table_id_example').DataTable({
            scrollY:300,    //滚动
            paging:false,  //分页
        });
        $("#table_id_example2").DataTable({
            searching:true,
        });
    } );

</script>