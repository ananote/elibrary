<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>elibrary</title>

<link href="${baseURL}/css/redmond/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
<link href="${baseURL}/js/jtable/themes/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />

<script src="${baseURL}/js/jquery-1.6.4.min.js" type="text/javascript"></script>
<script src="${baseURL}/js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
<script src="${baseURL}/js/jtable/jquery.jtable.js" type="text/javascript"></script>
<script src="${baseURL}/js/jtable/external/json2.js" type="text/javascript"></script>

</head>
