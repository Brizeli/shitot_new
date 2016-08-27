<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="${pageContext.response.locale}">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=9">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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
</html>