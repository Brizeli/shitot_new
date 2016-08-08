<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
    <!--    <div class="row">
        <h1>
            <a href="${pageContext.request.contextPath}">SHITOT ORG</a>
            <img src="resources/images/logo4.png" align="right"/>
        </h1>
    </div>-->
    <%--<hr>--%>
    <div class="row">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">
                        <img alt="Brand" src="resources/images/logo4.png" height="50px">
                    </a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Add <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="addPatientForm">Create new patient</a></li>
                            <li><a href="addSymptomForm">Create new symptom</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Get <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="doctors">Get all doctors</a></li>
                            <li><a href="patients">Get all patients</a></li>
                        </ul>
                    </li>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="navbar-text">Logged as ${loggedUser}</li>
                    <sec:authorize access="isAuthenticated()">
                        <li class=""><a href="logout">logout</a></li>
                    </sec:authorize></ul>
            </div>
        </nav>
    </div>
</header>