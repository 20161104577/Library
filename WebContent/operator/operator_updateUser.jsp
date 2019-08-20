
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visual Admin Dashboard - Preferences</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">
    
    <link href='http://fonts.useso.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<!-- Left column -->
    <div class="templatemo-flex-row">
      <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
          <div class="square"></div>
          <h1>管理员：${USERBEAN.u_name }</h1>
          
        </header>
        <div class="profile-photo-container">
          <img src="images/profile-photo.jpg" alt="Profile Photo" class="img-responsive">
          <div class="profile-photo-overlay"></div>
        </div>
        <!-- Search box -->
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
          </div>
        <nav class="templatemo-left-nav">
          <ul>
            <li><a href="operatorbookmessage?type=operator_booksearch" class="active"><i class="fa fa-bar-chart fa-fw"></i>图书信息查询</a></li>
            <li><a href="OperatorBorrowBookInfo"><i class="fa fa-database fa-fw"></i>读者借阅信息</a></li>
            <li><a href="/Library/operator/operator_newborrow.jsp" ><i class="fa fa-users fa-fw"></i>书籍借阅</a></li>
            <li><a href="ReadAddBookType"><i class="fa fa-sliders fa-fw"></i>添加图书</a></li>
            <c:choose>
            	<c:when test="${USERBEAN.u_name=='admin' }">
            		<li><a href="ListOfOperator?type=show"><i class="fa fa-sliders fa-fw"></i>管理员列表</a></li>
            		<li><a href="operator_addOperator.jsp"><i class="fa fa-sliders fa-fw"></i>添加新管理员</a></li>
            	</c:when>
            	<c:otherwise>
            		<li><a href="operatorbookmessage?type=operator_booksearch"><i class="fa fa-sliders fa-fw"></i>管理员列表</a></li>
            		<li><a href="operatorbookmessage?type=operator_booksearch"><i class="fa fa-sliders fa-fw"></i>添加新管理员</a></li>
            	</c:otherwise>
            </c:choose>
            <li><a href="/Library/LoAndRe/index.html"><i class="fa fa-eject fa-fw"></i>退出登录</a></li>
          </ul>
        </nav>
      </div>
      <!-- Main content -->
      <div class="templatemo-content col-1 light-gray-bg">
        <div class="templatemo-top-nav-container">
          <div class="row">
            <nav class="templatemo-top-nav col-lg-12 col-md-12">
              <ul class="text-uppercase">
                <li>图书管理员信息修改</li>
              </ul>
            </nav>
          </div>
        </div>
        <div class="templatemo-content-container">
          <div class="templatemo-content-widget white-bg">
            <form action="ListOfOperator?type=update&uid=${SELECTUSER.u_ID }" class="templatemo-login-form" method="post" >
	            <div class="row form-group">
	              	<div class="col-lg-6 col-md-6 form-group">                  
	                    <label>图书管理员名字</label>
	                    <input type="text" class="form-control" value="${SELECTUSER.u_name }" name="username" id="username">
	                </div>
	                <div class="col-lg-6 col-md-6 form-group">                  
	                    <label >图书管理员密码</label>
	                    <input type="text" class="form-control" value="${SELECTUSER.u_pwd }" name="password" id="password">
	                </div>
	            </div>
	            <div class="row form-group">
	                <div class="col-lg-12 has-warning form-group" align="center">                  
	                    <button type="submit" class="templatemo-blue-button" id="button" name="button">添加</button>
	                </div>
	            </div>    
               </form>
              </div>
                </div>                       
            
         
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | More Templates 咦，有个组</p>
          </footer>
        </div>
      </div>
    </div>

    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>        <!-- jQuery -->
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
</body>
</html>