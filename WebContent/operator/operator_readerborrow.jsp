<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <li><a href="operatorbookmessage?type=operator_booksearch"><i class="fa fa-bar-chart fa-fw"></i>图书信息查询</a></li>
            <li><a href="OperatorBorrowBookInfo" class="active"><i class="fa fa-database fa-fw"></i>读者借阅信息</a></li>
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
        <form action="operatorsearchbook?type=readerborrow" method="post" class="templatemo-search-form" role="search">
          <div class="input-group">
              <button type="submit" class="fa fa-search"></button>
              <input type="text" class="form-control" placeholder="Search" name="search" id="seaarch">
              <select name="select" id="demoSelect" ng-model="binding.value"  style="width:100%;height:26px;background-color:#39ADB4;"  ng-options="key for key in binding.landarr">
                	<option value="tb_borrow.b_ID">借书单序号</option>
                	<option value="tb_reader.r_name">读者姓名</option>
                	<option value="tb_reader.r_id">读者ID</option>
                	<option value="tb_bookinfo.b_name">书籍名称</option>
                	<option value="tb_bookinfo.b_id">书籍ID</option>
                	<option value="tb_booktype.t_name">书籍种类 </option>
                </select>
          </div>
        </form>
          <div class="templatemo-content-widget no-padding">
            <div class="panel panel-default table-responsive">
              <table class="table table-striped table-bordered templatemo-user-table">
                <thead>
                  <tr>
                    <td><a href="" class="white-text templatemo-sort-by">序号 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">读者姓名 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">读者ID<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">所读书籍名称<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">所读书籍编号 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">书籍种类 <span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">借阅时间<span class="caret"></span></a></td>
                    <td><a href="" class="white-text templatemo-sort-by">归还时间 <span class="caret"></span></a></td>  
                    <td>书籍所在书架</td>
                    <td>状态</td>
                    <td>操作</td>
                  </tr>
                </thead>
                <tbody>
	                <c:forEach var="item" items="${sessionScope.SHOWBORROWBOOK }">
			              <tr>
		                    <td>${item.b_ID }</td>
		                    <td>${item.r_name }</td>
		                    <td>${item.r_id }</td>
		                    <td>${item.b_name }</td>
		                    <td>${item.binfo_id }</td>
		                    <td>${item.t_name }</td>
		                    <td>${item.b_outTime }</td>
		                    <td>${item.b_backTime }</td>
		                    <td><a href="" class="templatemo-edit-btn">${item.b_location }</a></td>
		                    <td><a href="" class="templatemo-link">${item.b_state }</a></td>
		                    <c:choose>
		                    	<c:when test="${item.b_state=='预约中' }">
		                    		<td><a href="ChangeState?type=one&id=${item.binfo_id }">同意</a></td>
		                    	</c:when>
		                    	<c:when test="${item.b_state=='预约成功'||item.b_state=='可预约' }">
		                    		<td><a href="ChangeState?type=two&id=${item.binfo_id }&boid=${item.b_ID }&op=${USERBEAN.u_name }">借阅</button></td>
		                    	</c:when>
		                    	<c:when test="${item.b_state=='已借阅' }">
		                    		<td><a href="ChangeState?type=three&id=${item.binfo_id }&b_id=${item.b_ID }">归还</button></td>
		                    	</c:when>
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