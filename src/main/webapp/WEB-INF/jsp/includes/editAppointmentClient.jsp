<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal fade" id="editAppointment">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title title"></h3>
                <a class="btn btn-xs btn-danger" id="deleteAppointment"><spring:message code="common.delete"/></a>
            </div>
            <form class="form-horizontal editForm" method="post">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <div class="row">
                        <div class="col-xs-6" style="border-right: 1px solid grey">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="applyDate"><spring:message code="apo.applyDate"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="applyDate" id="applyDate">
                                </div>
                            </div>
                            <%--Apply date--%>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="appointmentDate"><spring:message
                                        code="apo.apoDate"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="appointmentDate" id="appointmentDate">
                                </div>
                            </div>
                            <%--Appointment date--%>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="paymentDate"><spring:message code="apo.payDate"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="paymentDate" id="paymentDate">
                                </div>
                            </div>
                            <%--Payment date--%>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="paymentAmount"><spring:message
                                        code="apo.payAmount"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="paymentAmount" id="paymentAmount">
                                </div>
                            </div>
                            <%--Payment amount--%>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="checkNumber"><spring:message code="apo.cheque"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control" name="checkNumber" id="checkNumber">
                                </div>
                            </div>
                            <%--Ceck number--%>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="description"><spring:message
                                        code="apo.description"/>:</label>
                                <div class="col-xs-8">
                                    <textarea class="form-control" name="Description" id="description"></textarea>
                                </div>
                            </div>
                            <%--Description--%>
                        </div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="patname"><spring:message code="patient.name"/>:</label>
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" name="patName" id="patname">
                                </div>
                            </div>
                            <%--Patient name--%>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="age"><spring:message code="patient.age"/>:</label>
                                <div class="col-xs-2">
                                    <input class="form-control" type="number" name="age" id="age">
                                </div>
                                <label class="control-label col-xs-3" for="telNumber"><spring:message code="patient.tel"/>:</label>
                                <div class="col-xs-5">
                                    <input class="form-control" type="text" name="telNumber" id="telNumber">
                                </div>
                            </div>
                            <%--Age and tel--%>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="pataddress"><spring:message code="clinics.address"/>:</label>
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" name="patAddress" id="pataddress">
                                </div>
                            </div>
                            <%--Patient address--%>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="referral"><spring:message code="patient.referral"/>:</label>
                                <div class="col-xs-10">
                                    <input class="form-control" type="text" name="referral" id="referral">
                                </div>
                            </div>
                            <%--Referral--%>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="problems"><spring:message code="apo.problems"/>: </label>
                                <div class="col-xs-10">
                                    <select class="form-control" name="problems" id="problems" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-10 col-xs-offset-2">
                                    <a class="addSpec"><spring:message code="apo.addproblem"/></a>
                                </div>
                            </div>
                            <%--Problems--%>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="symptoms"><spring:message code="apo.symptoms"/>:</label>
                                <div class="col-xs-10">
                                    <select class="form-control" name="symptoms" id="symptoms" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-10 col-xs-offset-2">
                                    <a class="addSpec"><spring:message code="apo.addsymptom"/></a>
                                </div>
                            </div>
                            <%--Symptoms--%>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="doctor"><spring:message code="doctor.doctor"/></label>
                                <div class="col-xs-8">
                                    <select class="form-control doctors" type="text" name="doctorId" id="doctor"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="altdoctor"><spring:message code="doctor.altdoctor"/></label>
                                <div class="col-xs-8">
                                    <select class="form-control doctors" type="text" name="altdoctorId" id="altdoctor"></select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-xs-12">
                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary"><spring:message code="app.buttons.save"/></button>
                            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true"><spring:message
                                    code="app.buttons.cancel"/></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>