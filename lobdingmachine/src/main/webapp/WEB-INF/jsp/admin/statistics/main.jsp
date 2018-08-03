<!-- Styles -->
<style>
#chartdiv {
  width: 80%;
  height: 500px;
}	
</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>
<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>

<!-- Chart code -->
<script>
$(function(){
	var chart = AmCharts.makeChart( "chartdiv", {
		  "type": "serial",
		  "addClassNames": true,
		  "theme": "light",
		  "autoMargins": false,
		  "marginLeft": 100,
		  "marginRight": 8,
		  "marginTop": 10,
		  "marginBottom": 26,
		  "balloon": {
		    "adjustBorderColor": false,
		    "horizontalPadding": 10,
		    "verticalPadding": 8,
		    "color": "#ffffff"
		  },
		  "dataDateFormat": "YYYY-MM-DD HH",
		  "dataProvider": [],
		  "valueAxes": [ {
		    "axisAlpha": 0,
		    "position": "left"
		  } ],
		  "applyGapValue": 0,
		  "startDuration": 1,
		  "graphs": [ {
		    "id": "graph",
		    "balloonText": "<span style='font-size:12px;'>[[category]]<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
		    "bullet": "round",
		    "lineThickness": 3,
		    "bulletSize": 7,
		    "bulletBorderAlpha": 1,
		    "bulletColor": "#FFFFFF",
		    "useLineColorForBulletBorder": true,
		    "bulletBorderThickness": 3,
		    "fillAlphas": 0,
		    "lineAlpha": 1,
		    "title": "시간별 매출",
		    "valueField": "price",
		    "dashLengthField": "dashLengthLine"
		  } ],
		  "chartCursor": {
			    "categoryBalloonDateFormat": "JJ:NN, DD MMMM",
			    "cursorPosition": "mouse"
			  },
		  "categoryField": "date",
		  "categoryAxis": {
			  "parseDates" : true,
		      "minPeriod" : "hh",
		    "gridPosition": "start",
		    "axisAlpha": 0,
		    "tickLength": 0
		  },
		  "export": {
		    "enabled": true
		  },
		  "connect": false,
		} );

		function updateChart(day) {
			//ajax로 데이터를 받아와서 차트에 데이터를 업데이트 합니다.
			$.getJSON('${context}/admin/statistics/getData?day='+day, function (data) {
				chart.dataProvider = data;   
				chart.validateData();
			});
		}

		updateChart('2018-08-01');

		$("#show").click(function(e) {
			e.preventDefault();
			updateChart($("#day").val());
		});
});
</script>

<!-- HTML -->
<input type="text" id="day" value="2018-08-01"><input type="button" id="show" value="보기"/>
<div id="chartdiv"></div>			