<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员登录</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome, Operator</h1>
            <form action="operate?type=login" method="post" class="form">
                <label> 用户名</label>
                <input id="uid" name="uid" type="text" placeholder="Job number">
               	<label>密码</label>
                <input id="password" name="password" type="password" placeholder="Password">
                
                <button type="submit" name="button1" id="button1">登录</button>
            </form>
        </div>

    </div>
</div>

<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>



</body>
</html>