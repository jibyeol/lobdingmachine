<c:if test="${url != null }">추가된 URL : ${url }</c:if>
<form action="${context }/admin/image/upload" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
	파일 : <input type="file" name="multipartFile"><br>
	<input type="submit" name="업로드" value="제출">
</form>
