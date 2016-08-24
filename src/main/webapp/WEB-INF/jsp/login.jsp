<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<div class="container">
    <br>
    <form class="form-horizontal" action="spring_security_check" method="post">
        <div class="form-group">
            <label class="control-label col-xs-2">Login:</label>
            <div class="col-xs-10">
                <input class="form-control" type="text" name="username">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Password:</label>
            <div class="col-xs-10">
                <input class="form-control" type="password" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button class="btn btn-primary" type="submit">Log In</button>
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
