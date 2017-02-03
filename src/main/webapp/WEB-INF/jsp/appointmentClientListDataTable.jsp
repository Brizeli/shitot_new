<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <h3>
        <a class="btn btn-sm btn-info" id="addAppointment" onclick="addAppointment(${patientId})"><spring:message
                code="apo.newApo"/></a>
    </h3>
    <div class="row searchrow col-xs-6">
        <%--<div class="col-xs-2"><label class="control-label"><spring:message code="common.search"/></label></div>--%>
        <div class="col-xs-6"><input class="form-control" type="text" id="search"></div>
        <div class="col-xs-1">
            <a class="btn btn-default" id="clearsearch">&times; <spring:message code="app.buttons.clear"/> </a>
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="view-box">
            <table class="table table-striped display" id="dataTable">
                <thead>
                <tr>
                    <th><spring:message code="apo.info"/></th>
                    <th><spring:message code="patient.patient"/></th>
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