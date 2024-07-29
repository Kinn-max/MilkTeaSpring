<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<link rel="icon page" type="jpg" href="../img/the_end.jpg">

	<link rel="stylesheet" href="../admin/css/admin.css">
	<link rel="stylesheet" href="../css/main.css">
	<link rel="stylesheet" href="../css/category.css">
	<link rel="stylesheet" href="../Fonsomeone/fontawesome-free-6.2.0/css/all.min.css">
</head>
<body class="no-skin">
	<!-- header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->

    <div class=" admin_padding">

		<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->

		<dec:body/>

		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->
	</div>

		<script src="../admin/js/style.js"></script>
<%--		<script src="../js/category.js"></script>--%>
</body>
</html>