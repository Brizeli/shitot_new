<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h3><spring:message code="app.users"/>
        <a class="btn btn-sm btn-info" id="addUser" onclick="addUser()"><spring:message code="users.register"/></a>
    </h3>
    <div class="view-box">
        <table class="table table-striped display" id="dataTable">
            <thead>
            <tr>
                <th><spring:message code="app.login"/> </th>
                <th><spring:message code="users.enabled"/> </th>
                <th></th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="registerUser.jsp"/>
<script type="text/javascript" src="resources/js/userDatatables.js"></script>