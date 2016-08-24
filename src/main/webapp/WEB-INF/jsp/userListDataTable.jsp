<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h3>Users
        <a class="btn btn-sm btn-info" id="addUser" onclick="addUser()">Register new user</a>
    </h3>
    <div class="view-box">
        <table class="table table-striped display" style="width: 100%" id="dataTable">
            <thead>
            <tr>
                <th>Login</th>
                <th>Enabled</th>
                <th>Appointments</th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="registerUser.jsp"/>
<script type="text/javascript" src="resources/js/userDatatables.js"></script>