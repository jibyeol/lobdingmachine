
<div class="row">
   <div class="col-xs-12">
       <div id="productList" style="float: left;">
           <table id="grid"></table>
           <div id="pager"></div>
       </div>
   </div>
</div>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.2/css/ui.jqgrid.min.css">
<link rel="stylesheet" href="${context }/lib/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.2/jquery.jqgrid.min.js"></script>
<script src="${context }/lib/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>


<script>
	$(function(){
		$(document).ready(function myfunction() {
			
			$("#grid").jqGrid({
				url : '${context}/admin/member/getData',
				editurl : '${context}/admin/member/edit',
	            colModel: [
	            	{label:"idx", name : "idx", key:true, search:false},
	            	{label:"name", name:"name", editable:true},
	            	{label:"rrn", name:"rrn", editable:true},
	            	{label:"skinType", name:"skinType", editable:true, edittype:"select", search:false
	            		, editoptions:{value:{1:'건성',2:'복합성',3:'지성'}}},
		            {label:"rank", name:"rank", editable:true, edittype:"select", search:false
		            	, editoptions:{value:{'SILVER':'SILVER', 'GOLD':'GOLD', 'VIP':'VIP'}}},
	            	{label:"point", name:"point", search:false, editable: true},
	            	{label:"phoneNumber", name:"phoneNumber", search:false, editable: true}
	            ],
	            datatype: 'json',
	            pager : "#pager",
	            rowList: [5, 10, 30],
	            rowNum : 10,
	            styleUI: 'Bootstrap'
			});
			
			$('#grid').navGrid('#pager',
			       {edit: true, add: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: true},
			       {
			           editCaption: "edit"
			           , closeAfterEdit: true
			           , errorTextFormat: function (data) {
			               return 'Error: ' + data.responseText
			           },
			           beforeShowForm: function(form) { $('#userId', form).attr('readonly','readonly'); }
			       },
			       {
			           closeAfterAdd: true,
			           recreateForm: true,
			           errorTextFormat: function (data) {
			               return 'Error: ' + data.responseText
			           },
			           beforeShowForm: function(form) { $('#userId', form).removeAttr('readonly'); }
			       },
			       {
			           errorTextFormat: function (data) {
			               return 'Error: ' + data.responseText
			           }
			       },
			       {
			    	   sopt : ['cn'],
			    	   odata : ['contains']
			       });
			
		});
		
	});
</script>