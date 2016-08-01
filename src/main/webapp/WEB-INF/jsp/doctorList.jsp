<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Doctors</h2>
<div class="view-box">
    <a class="btn btn-default" id="addDoctor" onclick="add()">New doctor</a>
    <hr>
    <table class="table table-striped" id="dataTable">
        <thead>
        <tr>
            <th>Name</th>
            <th>Specialties</th>
            <th>Tel number</th>
            <th>Target audience</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${doctorList}" var="doctor">
            <jsp:useBean id="doctor" class="com.shitot.model.Doctor"/>
            <tr>
                <td>${doctor.name}</td>
                <td><%=StringUtils.collectionToCommaDelimitedString(doctor.getSpecialties())%>
                </td>
                <td>${doctor.telNumber}</td>
                <td><%=StringUtils.collectionToCommaDelimitedString(doctor.getTargetAudiences())%>
                </td>
                    <%--<td><a class="btn btn-success btn-xs" href="doctors/update?id=${doctor.id}">Update</a></td>--%>
                <td><a class="btn btn-success btn-xs" onclick="update(${doctor.id})">Update</a></td>
                <td><a class="btn btn-danger btn-xs" href="doctors/delete?id=${doctor.id}">Delete</a></td>
                <td><a href="viewDoctorSchedule?id=${doctor.id}">View Schedule</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">${doctor.id==0?"Add new doctor":"Edit doctor"}</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="doctors" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" name="id" id="id" value="${doctor.id}">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="name">Name:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="name" id="name" required value="${doctor.name}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="login">Login:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="login" id="login" required value="${doctor.login}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="password">Password:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="password" id="password" required value="${doctor.password}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="email">Email:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="email" name="email" id="email" value="${doctor.email}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="telNumber">Tel number:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="telNumber" id="telNumber" value="${doctor.telNumber}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="telAdditional">Additional tel:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="telAdditional" id="telAdditional"
                                   value="${doctor.telHome}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="spec1">Primary specialty:</label>
                        <div class="col-xs-9">
                            <select class="form-control" name="specialty1" id="spec1" value="${specialty1}">
                                <option></option>
                                <c:forEach items="${specialtyList}" var="s">
                                    <option ${s==specialty1?'selected':''}>${s}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="spec2">Optional specialty:</label>
                        <div class="col-xs-9">
                            <select class="form-control" name="specialty2" id="spec2" value="${specialty2}">
                                <option></option>
                                <c:forEach items="${specialtyList}" var="s">
                                    <option ${s==specialty2?'selected':''}>${s}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="target">Target audience:</label>
                        <div class="col-xs-9">
                            <fieldset id="target">
                                <c:forEach items="${targetAudienceList}" var="t">
                                    <label>
                                        <input type="checkbox" name="target"
                                               value="${t}" ${doctor.targetAudiences.contains(t)?'checked="checked"':''}/>${t}
                                    </label>
                                </c:forEach>
                            </fieldset>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="prefer">Prefferencies:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="preferential" id="prefer" value="${doctor.preferential}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="expert">Expert in:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="expert" id="expert"
                                   value="${doctor.qualifications}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="certif">Certification:</label>
                        <div class="col-xs-9">
                            <select class="form-control" name="certificate" id="certif" value="${doctor.certificate}">
                                <option></option>
                                <c:forEach items="${certificateList}" var="c">
                                    <option ${c==doctor.certificate?'selected':''}>${c}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lections">Lections:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="lections" id="lections" value="${doctor.lections}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="comments">Comments:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="comments" id="comments" value="${doctor.comments}"/>
                        </div>
                    </div>
                    <button type="submit">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#dataTable').DataTable({
            paging: false,
            scrollY: 400,
            /*columns: [
             {data: "name"},
             {data:"specialties"},
             {data:"telNumber"},
             {}
             ]*/
            ordering: true
        });
        $('#addDoctor').click(function () {
            $('#id').val(0);
            $('#editRow').modal();
        });
        $('#detailsForm').submit(function () {

        });
    });
    var form = $('#detailsForm');
    function update(id) {
        $.get("rest/doctors/" + id, function (data) {
            $.each(data, function (key, value) {
                form.find("[name='"+key+"']").val(value);
            });
            $('#editRow').modal();
        })
    }
</script>