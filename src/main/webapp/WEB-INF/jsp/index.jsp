<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="${pageContext.response.locale}">
<jsp:include page="fragments/headTag.jsp"/>
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