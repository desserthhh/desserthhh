<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>各电影上座率柱状图</title>
	<link href='../images/logo.png' rel="shortcut icon" type="image/x-icon" media="screen"/>
	<script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script> 
	<script type="text/javascript" src="../js/highcharts/highcharts.js"></script> 
	<script type="text/javascript" src="../js/highcharts/exporting.js"></script> 
	<script type="text/javascript">
	$(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '各电影上座率柱状图'
	        },
	        xAxis: {
	            categories: [
	                '王牌特工',
	                '灰姑娘',
	                '咱们结婚吧',
	                '战狼',
	                '速度与激情7'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '上座率'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '上座率',
	            data: [0.49, 0.7, 0.2, 0.3, 0.8]

	        }]
	    });
	});				
	</script>
</head>
<body>
	<div id="container" style="min-width:700px;height:400px"></div>
</body>
</html>