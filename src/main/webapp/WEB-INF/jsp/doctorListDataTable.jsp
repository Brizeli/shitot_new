<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>Doctors
        <a class="btn btn-sm btn-info" id="addDoctor" onclick="add()">New doctor</a>
    </h2>
    <div class="view-box">
        <div class="panel panel-default">
            <%--<div class="panel-heading">Search</div>--%>
            <div class="panel-body">
                <div class="col-sm-3">
                    <h4>Name</h4>
                    <input class="form-control" type="text" id="namesearch">
                </div>
                <div class="col-sm-3">
                    <h4>Profession</h4>
                    <select class="form-control" id="professions">
                        <option>All</option>
                    </select>
                </div>
                <div class="col-sm-3">
                    <h4>Qualification</h4>
                    <select class="form-control" id="qualifications">
                        <option>All</option>
                    </select>
                </div>
            </div>
        </div>
        <table class="table table-striped display" id="dataTable">
            <thead>
            <tr>
                <th>Info</th>
                <th>Specializations</th>
                <th>Clinics</th>
                <%--<th>Create appointment</th>--%>
                <th>1</th>
                <th>2</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="editDoctor.jsp"/>
<script type="text/javascript" src="resources/js/doctorDatatables.js"></script>