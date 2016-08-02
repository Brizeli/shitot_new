<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Doctors</h2>
<div class="view-box">
    <a class="btn btn-sm btn-info" id="addDoctor" onclick="add()">New doctor</a>
    <hr>
    <table class="table table-striped display" id="dataTable">
        <thead>
        <tr>
            <th>Info</th>
            <th>Specializations</th>
            <th>Clinics</th>
            <th>Create appointment</th>
            <th>1</th>
            <th>2</th>
        </tr>
        </thead>
    </table>
</div>
<jsp:include page="editDoctor.jsp"/>
<script type="text/javascript" src="resources/js/doctorDatatables.js"></script>