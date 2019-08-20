<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Visual Admin Dashboard - Manage Users</title>
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
        <div class="templatemo-content-container">
        <form action="operatorsearchbook?type=searchbook" method="post" class="templatemo-search-form" role="search">
          <div class="input-group">
              <button type="submit" class="fa fa-search"></button>
              <input type="text" class="form-control" placeholder="Search" name="search" id="seaarch">
              <select name="select" id="demoSelect" ng-model="binding.value"  style="width:100%;height:26px;background-color:#39ADB4;"  ng-options="key for key in binding.landarr">
                	<option value="b_id">书籍序号</option>
                	<option value="b_name">书籍名称</option>
                	<option value="b_isbn">书籍ISBN号</option>
                	<option value="b_author">书籍作者</option>
                	<option value="b_translator">书籍译者</option>
                	<option value="t_name">书籍种类 </option>
                	<option value="b_location">书籍所在书架</option>
                	<option value="b_press">出版社</option>
                </select>
          </div>
        </form>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="SortOrderId?type=soid" class="white-text templatemo-sort-by">序号 <span class="caret"></span></a></td>
                    <td><a href="SortOrderId?type=soname" class="white-text templatemo-sort-by">书籍名称 <span class="caret"></span></a></td>
                    <td><a href="SortOrderId?type=sonum" class="white-text templatemo-sort-by">书籍编号 <span class="caret"></span></a></td>
                    <td><a href="SortOrderId?type=soauthor" class="white-text templatemo-sort-by">书籍作者 <span class="caret"></span></a></td>
                    <td><a href="SortOrderId?type=sotranslation" class="white-text templatemo-sort-by">书籍译者 <span class="caret"></span></a></td>
                    <td><a href="SortOrderId?type=sokind" class="white-text templatemo-sort-by">书籍种类 <span class="caret"></span></a></td>
                    <td><a href="SortOrderId?type=sobday" class="white-text templatemo-sort-by">最大借阅天数</a></td>
                    <td><a href="SortOrderId?type=solocation" class="white-text templatemo-sort-by">书籍所在书架</a></td>
                    <td><a href="SortOrderId?type=sopress" class="white-text templatemo-sort-by">出版社</a></td>
                    <td><a href="SortOrderId?type=sostate" class="white-text templatemo-sort-by">状态</a></td>
                    <td>操作</td>
                    <td>操作</td>
                  </tr>
                </thead>
                <tbody>
	                <c:forEach var="item" items="${sessionScope.BOOKSHOW }">
		                  <tr>
		                    <td>${item.b_id }</td>
		                    <td>${item.b_name }</td>
		                    <td>${item.b_isbn }</td>
		                    <td>${item.b_author }</td>
		                    <td>${item.b_translator }</td>
		                    <td>${item.t_name }</td>
		                    <td>${item.t_time }</td>
		                    <td>${item.b_location }</td>
		                    <td>${item.b_press }</td>
		                    <td>${item.b_state }</td>
		                    <td><a href="UpdateBookInfo?type=look&b_id=${item.b_id }">修改</a></td>
		                    <td><a href="UpdateBookInfo?type=delete&b_id=${item.b_id }">删除</a></td>
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
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">咦，有个组</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
          </footer>         
        </div>
      </div>
    </div>
    
    <!-- JS -->
    <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
    <script>
      $(document).ready(function(){
        // Content widget with background image
        var imageUrl = $('img.content-bg-img').attr('src');
        $('.templatemo-content-img-bg').css('background-image', 'url(' + imageUrl + ')');
        $('img.content-bg-img').hide();        
      });
    </script>
</body>
</html>