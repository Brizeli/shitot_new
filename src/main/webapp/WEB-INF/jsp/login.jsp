<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<div class="container">
    <form action="spring_security_check" method="post">
        <dl>
            <dt>Name:</dt>
            <dd><input class="form-control" type="text" name="username"></dd>
        </dl>
        <dl>
            <dt>Password:</dt>
            <dd><input class="form-control" type="password" name="password"></dd>
        </dl>
        <button class="btn btn-primary" type="submit">Log In</button>
        <a class="btn btn-primary" onclick="reg()">Register</a>
    </form>
</div>
<div class="container">
    <c:if test="${error}">
        <div class="error">
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="message">
            ${message}
            <%--<fmt:message key="${message}"/>--%>
        </div>
    </c:if>
</div>
<div class="modal fade regForm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Register</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" action="register" id="regForm" autocomplete="off">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lgn">Login:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="newlogin" id="lgn" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="psw">Password:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="password" name="newpassword" id="psw" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary pull-right">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function reg() {
        $('#regForm')[0].reset();
        $('.regForm').modal();
    }
    //    $(function () {
    //        $('#regForm').submit(function () {
    //            $.post('url',
    //                    $(this).serialize(),
    //                    function (data, status) {
    //                        console.log(data + ", " + status);
    //                    });
    //            return false;
    //        })
    //    })
</script>