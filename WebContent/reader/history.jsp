<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>读者-借阅历史</title>
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
          <h1>欢迎，${READER.r_name }!</h1>
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
			
			<li><a href="bookmanage1?type=login"><i class="fa fa-bar-chart fa-fw"></i>图书信息</a></li>
			<li><a href="bookmanage1?type=bookapp&r_id=${READER.r_id }"><i class="fa fa-database fa-fw"></i>预约图书</a></li>
			<li><a href="bookmanage1?type=bookhis&r_id=${READER.r_id }"  class="active"><i class="fa fa-users fa-fw"></i>借阅历史</a></li>
			<li><a href="bookmanage1?type=bookmy&r_id=${READER.r_id }"><i class="fa fa-sliders fa-fw"></i>我的图书</a></li>
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
                <li><a href="" class="active">借阅历史</a></li>
              </ul>
            </nav>
          </div>
        </div>
        <div class="templatemo-content-container">
         <form action="searchbook1?type=history&r_id=${READER.r_id }" method="post" class="templatemo-search-form" role="search">
		          <div class="input-group">
		              <button type="submit" class="fa fa-search"></button>
		              <input type="text" class="form-control" placeholder="Search" name="search" id="seaarch">
		              <select name="select" id="demoSelect" ng-model="binding.value"  style="width:100%;height:26px;background-color:#39ADB4;"  ng-options="key for key in binding.landarr">
		                	<option value="g_ID">书籍序号</option>
		                	<option value="b_name">书籍名称</option>
		                	<option value="b_isbn">书籍ISBN号</option>
		                	<option value="b_author">书籍作者</option>
		                	<option value="t_name">书籍种类 </option>
		                	<option value="b_location">书籍所在书架</option>

		                </select>
		          </div>
		        </form>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by">序号 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">书籍名称 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">书籍ISBN号 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">书籍作者 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">书籍种类 <span class="caret"></span></a></td>
                    <td>书籍所在书架</td>
                    <td>到期时间</td>
                    <td>状态</td>
                    
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="item" items="${sessionScope.BookBack }">
					<tr>
						<td>${item.g_ID }</td>
						<td>${item.b_name }</td>
						<td>${item.b_isbn }</td>
						<td>${item.b_author }</td>
						<td>${item.t_name }</td>
						<td>${item.b_location }</td>
						<td>${item.g_backtime }</td>
						
						<c:choose>
								<c:when test="${item.b_ifBack==0}">
									<td>未归还</td>
								</c:when>
								<c:otherwise>
									<td>已归还</td>
								</c:otherwise>
							</c:choose>
						
						
					</tr>
				</c:forEach>
                                   
                </tbody>
              </table>    
            </div>                          
          </div>          
           <!-- Second row ends -->
          <div class="pagination-wrap">
            <ul class="pagination">
              <li><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
              <li><a href="#">4</a></li>
              <li><a href="#">5</a></li>
              <li>
                <a href="#" aria-label="Next">
                  <span aria-hidden="true"><i class="fa fa-play"></i></span>
                </a>
              </li>
            </ul>
          </div>                 
        </div>
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">咦，有个组</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
          </footer>
        </div>
      </div>
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>        <!-- jQuery -->
    <script type="text/javascript" src="js/bootstrap-filestyle.min.js"></script>  <!-- http://markusslima.github.io/bootstrap-filestyle/ -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>        <!-- Templatemo Script -->
</body>
</html>