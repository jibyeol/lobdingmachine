<c:if test="${url != null }">추가된 URL : ${url }</c:if>
<form action="${context }/admin/image/upload" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
	파일 : <input type="file" name="multipartFile"><br>
	<input type="submit" name="업로드" value="제출">
</form>
<br><br>

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
				url : '${context}/admin/payment/get',
	            colModel: [
	            	{label:"idx", name : "idx", key:true, search:false},
	            	{label:"phoneNumber", name:"phoneNumber"},
	            	{label:"productName", name:"productName"},
	            	{label:"count", name:"count"},
	            	{label:"totalPrice", name:"totalPrice"},
	            	{label:"payDate", name:"payDateForString"},
	            ],
	            datatype: 'json',
	            pager : "#pager",
	            rowList: [5, 10, 30],
	            rowNum : 30,
	            styleUI: 'Bootstrap'
			});
			
			$('#grid').navGrid('#pager',
			       {edit: false, add: false, del: false, search: false, refresh: true, view: true, position: "left", cloneToTop: true},
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