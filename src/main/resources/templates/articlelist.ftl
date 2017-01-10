<!DOCTYPE html>
<html lang="en">
<head>
    <base href="[@spring.url value="/"/]">
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.css"/>

    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
</head>
<body>
<div class="page-content">
    <div class="page-content-area">
        <div class="row">
            <div class="col-xs-12">
                <table id="table" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>文章ID</th>
                        <th>标题</th>
                        <th>内容</th>
                        <td>发表人</td>
                    </tr>
                    <tfoot>
                    <tr>
                        <th>文章ID</th>
                        <th>标题</th>
                        <th>内容</th>
                        <td>发表人</td>
                    </tr>
                    </tfoot>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#table tfoot th').each( function () {
            var title = $('#table thead th').eq( $(this).index() ).text();
            $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
        } );
        var table=$("#table").DataTable({
            bDestroy: true,
            processing:true,
            serverSide: true,
            ajax: {
                url: 'admin/articleList',
                type: 'POST',
            },

            language: {
                url: 'datatables/i18n/Chinese.json'
            },
            columns: [
                {data: 'articleId'},
                {data: 'title'},
                {data: 'content'},
                {data: 'user.name'}
            ],
            "columnDefs": [{
                "targets": [3],
                "data": null,
                "defaultContent": "<button class='btn btn-default btn-sm'>删除</button>"
            }]
        });

        table.columns().eq( 0 ).each( function ( colIdx ) {
            $( 'input', table.column( colIdx ).footer() ).on( 'keyup change', function () {
                table
                        .column( colIdx )
                        .search( this.value )
                        .draw();
            } );
        } );


        $("#table").on('click','button',function(){
            var data = table.row( $(this).parents('tr') ).data();
            //询问框
            layer.confirm('你确定要删除吗？', {
                btn: ['确定','取消'] //按钮
            }, function(){
                $.ajax({
                    'url':'user/delete',
                    'type':'POST',
                    'dataType':'json',
                    'data':{id:data.id},
                    'success':function (result) {
                        layer.msg(result.message, {icon: 1});
                    }
                });
            }, function(){
                layer.close();
//                layer.msg('也可以这样', {
//                    time: 20000, //20s后自动关闭
//                    btn: ['明白了', '知道了']
//                });
            });
        })
    });
</script>
</body>
</html>