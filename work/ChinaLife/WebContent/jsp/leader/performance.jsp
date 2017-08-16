<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门报表</title>

    <link rel="stylesheet" href="css/project-style.css"/>
    <link rel="stylesheet" href="/ChinaLife/assets/css/main.css" />
    <link rel="stylesheet" href="/ChinaLife/bootstrap-3.2.0-dist/css/bootstrap.css">
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/jquery-1.7.min.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/bootstrap.js"></script>
    <script src="/ChinaLife/bootstrap-3.2.0-dist/js/highcharts.js"></script>

<!-- 	<script src="/ChinaLife/laydate/laydate.js"></script> -->

    <style>
        .divTitle{
            font-family: "华文彩云";
        }
        .divInp{
            width: 600px;
            height:30px;
        }
        .inp-form-div{
            width:150px;
            margin-right:0px;
            margin-left: 10px;
        }
        .inp-name{
            width:80px;
            margin-right:0px;
            margin-left: 40px;
            text-align: right;
        }
        .inp_add{
            margin: auto;
        }
        .modal{
            margin-top:120px;
        }
    </style>
   
    
</head>
<body>
<div class="content">
    <div id="div1" class="divTitle"><h2>部门报表</h2></div>
    <div id="div2" class="divInp">
        <form id="f1" action="">
<!--             <div class="inp-name pull-left ">
                <label>
                    <input type="radio" name="optionsRadios" id="1" value="option1" checked>
                    最近三个月
                </label>
            </div>

            <div class="inp-name pull-left ">
                <label>
                    <input type="radio" name="optionsRadios" id="2" value="option1" checked>
                    最近一季度
                </label>
            </div> -->

            <div class="inp-name pull-left">
                <label class="lab_Name control-label">时间段:</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="inp input-sm" type="text" name="start"  id="start"  placeholder="格式：1111-01-01"/>
            </div>
            <div class="pull-left" style="margin-left: 5px;" >
                <label class="lab_Name control-label">~</label>
            </div>
            <div class="inp-form-div pull-left">
                <input class="inp input-sm" type="text" name="end"  id="end" placeholder="格式：1111-01-01"/>
            </div>
            <div class="inp-name pull-left">
                <button id="btn" type="button" class="btn_refer btn btn-primary btn-sm">查询</button>
            </div>
        </form>

    </div>
    <div id="container" style="min-width: 400px; height: 400px; margin: 0 auto"></div>


</div>
</body>

<script type="text/javascript">

/* 	;!function(){
	    laydate({
	      	elem: '#demo'
	    })
	}(); */	  


    $(document).ready(function () {

        var options =  {
            chart: {  //图表类型
                type: 'column'
            },
            title: { //主标题
                text: ''
            },
            subtitle: { //副标题
                text: ''
            },
            xAxis: { //横坐标
                categories: [],
                title: {
                    text: '所有险种 ' //横坐标标题
                }
            },
            yAxis: { //纵坐标
                min: 0,
                title: {
                    text: ' (单)数' //纵坐标标题
                }
            },

            tooltip: {//鼠标移上提示信息

                headerFormat: '<span style="font-size:20px">{point.key}</span><table>',
                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.0f} 单</b></td></tr>',
                footerFormat: '</table>',
                shared: true,
                useHTML: true,
                percentageDecimals: 0
            }
        };

        function getData(){
            $.post("/ChinaLife/state/findAll.do",$("#f1").serialize(),
                	function(info){    	
 //               	alert(JSON.stringify(info));
 //  					alert(info);             	
 //               	alert(info.jsonArray);
 //               	alert(info.title);

					var array = new Array(info.insName.length);
					for(var i=0 ;i<info.insName.length;i++){
						var ins = info.insName[i];
						var data = info.insNum[i];
	//					alert(data);
						var jsonObject = {'name':ins,'data':data};
						array[i] = jsonObject;
					}
					                                         
                    //标题
                    options.title.text=  '所有部门业务报表';
                    //副标题
//                  options.subtitle.text= "95部、96部、97部";

                    options.series = array
                      
                    options.xAxis.categories=info.title;
                	$('#container').highcharts(options);                       
   
                },"json"); 
        }

        function testDate(){
            var reg1 = /^\d{4}-([1][0-2]|[0][0-9]){1}-([0-2][0-9]|[3][0-1]){1}$/;
            var reg2 = /^\S{1,}$/;
            if((reg1.test($("#start").val()) || !reg2.test($("#start").val()))&&(reg1.test($("#end").val()) || !reg2.test($("#end").val()))){
//            	if(reg1.test($("#start").val()) || !reg2.test($("#start").val())){	
//                alert("匹配！！");
                	getData();
            }else{
                alert("时间格式错误！！");
            }
        }

        $("#btn").click(function(){
 //       	getData();
 			testDate();
        });
        
        $(function(){    	
        	getData();
        });
        
    });

</script>


</html>