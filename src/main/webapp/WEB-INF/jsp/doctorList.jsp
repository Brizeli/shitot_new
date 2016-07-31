<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .doctorlist {
        border: 1px solid black;
        border-radius: 8px;
        overflow: auto;
        box-shadow: 0 0 10px inset;
    }

    .doctorInfo {
        border-bottom: 1px solid sandybrown;
    }

    a {
        cursor: pointer;
    }
</style>
<h2>Doctors <a class="btn btn-default" id="addDoctor" onclick="add()">New doctor</a></h2>
<div class="view-box">
    <div class="container doctorlist"></div>
</div>
<jsp:include page="fragments/editDoctor.jsp"/>
<div class="modal fade" id="editSpecs">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Specialties</h2>
            </div>
            <div class="modal-body">
                <ul id="specList"></ul>
            </div>
        </div>
    </div>
</div>
<script src="resources/js/doctors.js"></script>
