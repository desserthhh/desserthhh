<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>不同年龄段的男女会员月消费柱状图</title>
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
	            text: '不同年龄段的男女会员月消费柱状图'
	        },
	        xAxis: {
	            categories: [
	                '10-20',
	                '20-30',
	                '30-40',
	                '40-50',
	                '50-60',
	                '60-70'
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '消费金融'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f}人</b></td></tr>',
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
	            name: 'Male',
	            data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0]

	        }, {
	            name: 'Female',
	            data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5]

	        }]
	    });
	});				
	</script>
</head>
<body>
	<div id="container" style="min-width:700px;height:400px"></div>
</body>
</html>