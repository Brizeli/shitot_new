<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <h3>Doctors
        <a class="btn btn-sm btn-info" id="addDoctor" onclick="addDoctor()">New doctor</a>
    </h3>
    <input type="hidden" value="${doctorAlt}" id="doctorAlt">
    <input type="hidden" value="${appointmentId}" id="appointmentId">
    <div class="view-box">
        <div class="row searchrow">
            <div class="col-sm-11">
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
            <div class="col-sm-1">
                <h5>&nbsp;</h5>
                <a class="btn btn-default" id="clearsearch">&times; Clear</a>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped display" style="width: 100%;" id="dataTable">
                <thead>
                <tr>
                    <th>Info</th>
                    <th>Specializations</th>
                    <th>Clinics</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<jsp:include page="editDoctor.jsp"/>
<jsp:include page="editClinic.jsp"/>
<script type="text/javascript" src="resources/js/doctorDatatables.js"></script>
<script type="text/javascript" src="resources/js/doctors.js"></script>
<script type="text/javascript" src="resources/js/clinics.js"></script>