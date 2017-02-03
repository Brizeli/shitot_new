<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header>
    <div class="row">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">
                        <img alt="Brand" src="resources/images/logo4.png" height="50px">
                    </a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="doctors"><spring:message code="app.doctors"/></a></li>
                    <%--<li><a href="patients"><spring:message code="app.patients"/></a></li>--%>
                    <li><a href="appointmentsClients"><spring:message code="app.buttons.appointments"/></a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="users"><spring:message code="app.users"/> </a></li>
                    <sec:authorize access="isAuthenticated()">
                        <li class="navbar-text"><spring:message code="app.logged"/> ${loggedUser}</li>
                        <li class=""><a href="logout"><spring:message code="app.logout"/> </a></li>
                    </sec:authorize>
                    <jsp:include page="lang.jsp"/>
                </ul>
            </div>
        </nav>
    </div>
</header>