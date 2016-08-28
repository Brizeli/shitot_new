<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title><spring:message code="app.title"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" id="bsrtltag">
    <link rel="stylesheet" href="webjars/datatables/1.10.12/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="webjars/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css">
    <link rel="stylesheet" href="webjars/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker3.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="shortcut icon" href="resources/images/fav.png">
    <script type="text/javascript" src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
    <script type="text/javascript" src="webjars/jquery-ui/1.12.0/jquery-ui.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap-datepicker/1.6.1/locales/bootstrap-datepicker.he.min.js"></script>
    <script type="text/javascript" src="resources/js/jsUtils.js"></script>
    <script type="text/javascript"><jsp:include page="i18n.jsp"/></script>
</head>
