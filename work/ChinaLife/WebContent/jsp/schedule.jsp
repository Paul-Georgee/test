<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
    <meta charset="UTF-8">
    <title>日程安排</title>
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap-paginator.min.js"></script>
    <script>
        var ops = {
            bootstrapMajorVersion:3,      //bootstrap版本
            currentPage:1,    //当前页码
            totalPages:12,    //总页数
            numberOfPages:5,  //页面上最多显示多少页码
            onPageClicked:function(e,ev,type,page){   // 页码点击事件
				
            }
        }
        $(function(){
            $("#pageUL").bootstrapPaginator(ops)
        })
    </script>
</head>
<body>
        <div style="height: 300px;width: 70%;margin: auto">
            <h1>日程安排</h1>
            <div style="margin: auto;height: 50px;width: 800px;"></div>
            <div style="margin: auto;height: 70px;width: 800px;">
                <form class="form-inline" role="form">
                    日程内容:
                    <div class="form-group">
                        <input type="text" class="form-control" >
                    </div>
                    开始时间:
                    <div class="form-group">
                        <input type="text" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            	</div>
            <div style="margin: auto;height: 230px;width: 800px;">
                <table class="table table-striped" style="text-align: center">
                    <tr>
                        <td>日程内容</td>
                        <td>日程时间</td>
                        <td>操作</td>
                    </tr>
                    <tr>
                        <td>开电脑</td>
                        <td>2017-08-29</td>
                        <td><a href="#">删除</a></td>
                    </tr>
                    <tr>
                        <td>开电脑</td>
                        <td>2017-08-29</td>
                        <td><a href="#">删除</a></td>
                    </tr>
                    <tr>
                        <td>开电脑</td>
                        <td>2017-08-29</td>
                        <td><a href="#">删除</a></td>
                    </tr>
                    <tr>
                        <td>开电脑</td>
                        <td>2017-08-29</td>
                        <td><a href="#">删除</a></td>
                    </tr>
                    <tr>
                        <td>开电脑</td>
                        <td>2017-08-29</td>
                        <td><a href="#">删除</a></td>
                    </tr>
                </table>
            </div>
            <div style="font-size:20px;text-align: center">
				<ul  id="pageUL"></ul>
			</div>
			
				<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
				  添加日程
				</button>
				<form action="#">
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">添加日程</h4>
				      </div>
				      <div class="modal-body">
				        	日程内容：<input type="text"><br><br><br>
				        	日程日期：<input type="text">
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        <button type="submit" class="btn btn-primary">添加</button>
				      </div>
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div>
				</form>
        </div>
</body>
</html>