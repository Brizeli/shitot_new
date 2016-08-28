<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <h3>
        <a class="btn btn-sm btn-info" id="addAppointment" onclick="addAppointment(${patientId})"><spring:message code="apo.newApo"/></a>
    </h3>
    <h3><spring:message code="patient.patient"/>: <span id="patient1"></span></h3>
    <div class="view-box">
        <table class="table table-striped display" id="dataTable">
            <thead>
            <tr>
                <th><spring:message code="apo.info"/></th>
                <th><spring:message code="apo.problems"/></th>
                <th><spring:message code="app.doctors"/></th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="editAppointment.jsp"/>
<script type="text/javascript" src="resources/js/appointmentDatatables.js"></script>