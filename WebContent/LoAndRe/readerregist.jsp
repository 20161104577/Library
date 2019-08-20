<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>读者注册</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
</head>
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }js/jquery-1.11.1.min.js.js"></script>
<script type="text/javascript">
function checkmobile(obj) {
	var u_val = obj.value;
	
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/CheckMobileServlet',
		data:{'mobile':u_val},
		dataType:'text',
		success:function(data) {
			if("no"==data) {
				$("#msg").html("该手机号已被注册");
			} else if("ok" == data) {
				$("#msg").html("该手机号可以注册");
			}
		}
	})
}
</script>

<body>
<div class="htmleaf-container" style="margin-bottom:10px;">
    <div class="wrapper" style="height:600px">
        <div class="container">
            <h1>Welcome</h1>
            <form action="reader?type=regist" method="post" class="form">
                <input id="mobile" type="text" name="mobile" placeholder="手机号"  onblur="checkmobile(this);"><div style="float:right"></div><span id="msg"></span>
                <input id="password" type="password" name="password" placeholder="密码">
                <input id="username" type="text" name="username" placeholder="姓名">
                <input id="papertype" type="text" name="papertype" value="二代身份证"  readonly>
                <input id="paperno" type="text" name="paperno" placeholder="身份证号">
                <p>已有账号？<a href="/Library/LoAndRe/readerlogin.jsp">现在登录</a></p>
                <button type="submit" id="button" name="button">注册</button>
                
                
            </form>
        </div>

    </div>
</div>

</body>
</html>