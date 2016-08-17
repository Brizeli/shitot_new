<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <h3>
        <a class="btn btn-sm btn-info" id="addDoctor" onclick="addAppointment()">New Appointment</a>
    </h3>
    <input id="patientId" type="hidden" value="${patientId}" />
    <h3>Patient: <span id="patient1"></span></h3>
    <div class="view-box">
        <table class="table table-striped display" id="dataTableA">
            <thead>
            <tr>
                <th>Info</th>
                <th>Problems</th>
                <th>Doctors</th>
                <%--<th>Create appointment</th>--%>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="editAppointment.jsp"/>
<script type="text/javascript" src="resources/js/appointmentDatatables.js"></script>
<script type="text/javascript" src="resources/js/appointment.js"></script>