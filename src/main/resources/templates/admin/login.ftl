<!doctype html>
<html lang="en">
<head>
    <base href="[@spring.url value="/"/]">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <img src="images/fenjin.jpg" width="400" height="200">
    <form action="/admin/dologin" method="POST">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>