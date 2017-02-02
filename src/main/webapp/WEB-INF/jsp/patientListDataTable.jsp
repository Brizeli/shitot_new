<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <h3><spring:message code="app.patients"/>
        <a class="btn btn-sm btn-info" id="addPatient" onclick="addPatient()"><spring:message code="patient.newpatient"/></a>
    </h3>
    <div class="view-box">
        <div class="row">
            <div class="col-sm-6">
                <h5><spring:message code="patient.name"/></h5>
                <input class="form-control" type="text" id="namesearch">
            </div>
            <div class="col-sm-6">
                <h5><spring:message code="patient.tel"/></h5>
                <input class="form-control" type="text" id="telsearch">
            </div>
        </div>
        <table class="table table-striped display" id="dataTable">
            <thead>
            <tr>
                <th><spring:message code="patient.name"/></th>
                <th><spring:message code="patient.age"/></th>
                <th><spring:message code="patient.tel"/></th>
                <th></th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="includes/editPatient.jsp"/>
<script type="text/javascript" src="resources/js/patientDatatables.js"></script>