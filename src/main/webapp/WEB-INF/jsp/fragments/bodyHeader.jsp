<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                    <li><a href="doctors">Doctors</a></li>
                    <li><a href="patients">Patients</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <%--<ul class="nav navbar-nav navbar-left">--%>
                    <li><a href="users">Users</a></li>
                    <li class="navbar-text">Logged as ${loggedUser}</li>
                    <sec:authorize access="isAuthenticated()">
                        <li class=""><a href="logout">logout</a></li>
                    </sec:authorize>
                        <jsp:include page="lang.jsp"/>
                </ul>
            </div>
        </nav>
    </div>
</header>