<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title><tiles:insertAttribute name="title"/></title>
<tiles:insertAttribute name="header"/>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<tiles:insertAttribute name="navigation"/>
	<div class="content-wrapper">
    	<div class="container-fluid">
			<tiles:insertAttribute name="body"/>
		</div>
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>