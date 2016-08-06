<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body>
    <div class="container-fluid wrapper">
        <jsp:include page="fragments/bodyHeader.jsp"/>
        <div class="row content">
            <jsp:include page="${page}.jsp"/>
        </div>
        <jsp:include page="fragments/pageFooter.jsp"/>
    </div>
</body>