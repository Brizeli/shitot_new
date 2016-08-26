<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
    <br>
    <form class="form-horizontal" action="spring_security_check" method="post">
        <div class="form-group row">
            <label class="control-label col-xs-2"><spring:message code="app.login"/>:</label>
            <div class="col-xs-2">
                <input class="form-control" type="text" name="username">
            </div>
        </div>
        <div class="form-group row">
            <label class="control-label col-xs-2"><spring:message code="app.password"/>:</label>
            <div class="col-xs-2">
                <input class="form-control" type="password" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-2">
                <button class="btn btn-primary" type="submit"><spring:message code="app.buttons.login"/></button>
            </div>
        </div>
        <%--<a class="btn btn-primary" onclick="reg()">Register</a>--%>
    </form>
</div>
<div class="container-fluid">
    <c:if test="${error}">
        <div class="error">
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="message">
                ${message}
        </div>
    </c:if>
</div>
        <%--$('#regForm')[0].reset();--%>
