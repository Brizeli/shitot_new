<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid">
    <h3>Doctors
        <a class="btn btn-sm btn-info" id="addDoctor" onclick="addDoctor()">New doctor</a>
    </h3>
    <div class="view-box">
        <div class="row">
            <div class="col-sm-3">
                <h5>Name</h5>
                <input class="form-control" type="text" id="namesearch">
            </div>
            <div class="col-sm-3">
                <h5>Profession</h5>
                <select class="form-control professions" id="professions">
                    <option>All</option>
                </select>
            </div>
            <div class="col-sm-3">
                <h5>Qualification</h5>
                <select class="form-control qualifications" id="qualifications">
                    <option>All</option>
                </select>
            </div>
            <div class="col-sm-3">
                <h5>City</h5>
                <select class="form-control" id="cities">
                    <option>All</option>
                </select>
            </div>
        </div>
        <table class="table table-striped display" id="dataTable">
            <thead>
            <tr>
                <th>Info</th>
                <th>Specializations</th>
                <th>Clinics</th>
                <%--<th>Create appointment</th>--%>
            </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="editDoctor.jsp"/>
<jsp:include page="editClinic.jsp"/>
<script type="text/javascript" src="resources/js/doctorDatatables.js"></script>
<script type="text/javascript" src="resources/js/doctors.js"></script>
<script type="text/javascript" src="resources/js/clinics.js"></script>