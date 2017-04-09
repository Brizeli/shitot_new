<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <h3>
        <a class="btn btn-sm btn-info" id="addAppointment" onclick="addAppointment(${patientId})"><spring:message
                code="patient.addnew"/></a>
    </h3>
    <div class="searchrow col-xs-4">
        <%--<div class="col-xs-2"><label class="control-label"><spring:message code="common.search"/></label></div>--%>
        <div class="col-xs-6"><input class="form-control" type="text" id="search"></div>
        <div class="col-xs-1">
            <a class="btn btn-default" id="clearsearch">&times; <spring:message code="app.buttons.clear"/> </a>
        </div>
    </div>
    <form method="post" class="col-xs-8" id="filter">
        <div class="form-group">
            <label class="control-label col-xs-2" for="startDate">From Date:</label>
            <div class="col-xs-2">
                <input class="form-control datepicker" name="startDate" id="startDate">
            </div>
            <label class="control-label col-xs-2" for="endDate">To Date:</label>
            <div class="col-xs-2">
                <input class="form-control datepicker" name="endDate" id="endDate">
            </div>
            <div class="col-xs-4">
                <button type="submit" class="btn btn-primary"><spring:message code="common.filter"/></button>
            </div>
        </div>
    </form>
    <br>
    <br>
    <div class="row">
        <div class="view-box">
            <table class="table table-striped display" id="dataTable">
                <thead>
                <tr>
                    <th><spring:message code="patient.patient"/></th>
                    <th><spring:message code="patient.persInfo"/></th>
                    <th><spring:message code="apo.problems"/></th>
                    <th><spring:message code="app.doctors"/></th>
                </tr>
                </thead>
            </table>
        </div>
    </div>

</div>
<jsp:include page="includes/editAppointmentClient.jsp"/>
<script type="text/javascript" src="resources/js/appointmentClientDatatables.js"></script>