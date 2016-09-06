<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container-fluid">
    <h3><spring:message code="app.doctors"/>
        <a class="btn btn-sm btn-info" id="addDoctor" onclick="addDoctor()"><spring:message code="doctors.buttons.add"/></a>
    </h3>
    <input type="hidden" value="${doctorAlt}" id="doctorAlt">
    <input type="hidden" value="${appointmentId}" id="appointmentId">
    <div class="view-box">
        <div class="row searchrow">
            <div class="col-sm-11">
                <div class="col-sm-3">
                    <h5><spring:message code="doctors.name"/></h5>
                    <input class="form-control" type="text" id="namesearch">
                </div>
                <div class="col-sm-3">
                    <h5><spring:message code="doctors.profession"/></h5>
                    <select class="form-control professions" id="professions"></select>
                </div>
                <div class="col-sm-3">
                    <h5><spring:message code="doctors.qualification"/></h5>
                    <select class="form-control qualifications" id="qualifications"></select>
                </div>
                <div class="col-sm-3">
                    <h5><spring:message code="clinics.city"/> </h5>
                    <select class="form-control" id="cities"></select>
                </div>
            </div>
            <div class="col-sm-1">
                <h5>&nbsp;</h5>
                <a class="btn btn-default" id="clearsearch">&times; <spring:message code="app.buttons.clear"/> </a>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped display" id="dataTable">
                <thead>
                <tr>
                    <th><spring:message code="doctors.info"/> </th>
                    <th><spring:message code="doctors.specializations"/> </th>
                    <th><spring:message code="doctors.clinics"/> </th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<jsp:include page="editDoctor.jsp"/>
<jsp:include page="editClinic.jsp"/>
<jsp:include page="editSlots.jsp"/>
<script type="text/javascript" src="resources/js/doctorDatatables.js"></script>
<script type="text/javascript" src="resources/js/doctors.js"></script>
<script type="text/javascript" src="resources/js/clinics.js"></script>