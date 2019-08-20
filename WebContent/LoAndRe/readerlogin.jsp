<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>读者登录</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper" style="height:500px">
        <div class="container">
            <h1>Welcome</h1>
            <form action="reader?type=login" method="post" class="form">
                <label> 用户名</label>
                <input id="mobile" name="mobile" type="text" placeholder="Mobile">
               	<label>密码</label>
                <input id="password" name="password" type="password" placeholder="Password">
                <p>没有账号?<a href="readerregist.jsp">现在注册</a></p>
                <button type="submit" name="button1" id="button1">登录</button>
	            
                
                
            </form>
            
        </div>

    </div>
</div>

</body>
</html>