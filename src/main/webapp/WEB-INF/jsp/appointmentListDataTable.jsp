<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <h3>Appointment
        <a class="btn btn-sm btn-info" id="addDoctor" onclick="addAppointment()">New Appointment</a>

    </h3>
    <h2>Patient <span id="patient"></span></h2>
    <div class="view-box">
        <table class="table table-striped display" id="dataTable">
            <thead>
            <tr>
                <th>Info</th>
                <th>Problems</th>
                <th>Doctor</th>
                <%--<th>Create appointment</th>--%>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="editAppointment.jsp"/>
<script type="text/javascript" src="resources/js/appointmentDatatables.js"></script>
<script type="text/javascript" src="resources/js/appointment.js"></script>