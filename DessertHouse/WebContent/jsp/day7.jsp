<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>近7日购票人数折线图</title>
	<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
	<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
	<script type="text/javascript" src="../js/highcharts/highcharts.js"></script> 
	<script type="text/javascript" src="../js/highcharts/exporting.js"></script> 
	<script type="text/javascript">
	$(function () {
	    $('#container').highcharts({
	        title: {
	            text: '近7日购票人数折线图',
	            x: -20 //center
	        },
	        xAxis: {
	            categories: ['7天前', '6天前', '5天前', '4天前', '3天前', '2天前','1天前']
	        },
	        yAxis: {
	            title: {
	                text: '购票人数'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        tooltip: {
	            valueSuffix: '人'
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'right',
	            verticalAlign: 'middle',
	            borderWidth: 0
	        },
	        series: [{
	            name: '购票人数',
	            data: [97, 68, 88, 67, 107, 100, 100]
	        }]
	    });
	});
	</script>
</head>
<body>
	<div id="container" style="min-width:700px;height:400px"></div>
</body>
</html>