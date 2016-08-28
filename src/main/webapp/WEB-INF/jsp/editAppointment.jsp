<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal fade" id="editAppointment">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title title"></h3>
            </div>
            <form class="form-horizontal editForm" method="post">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <input id="patientId" hidden="hidden" name="patientId" value="${patientId}"/>
                    <div class="row">
                        <div class="col-xs-6" style="border-right: 1px solid grey">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="applyDate"><spring:message code="apo.applyDate"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="applyDate" id="applyDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="appointmentDate"><spring:message code="apo.apoDate"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="appointmentDate" id="appointmentDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="paymentDate"><spring:message code="apo.payDate"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="paymentDate" id="paymentDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="paymentAmount"><spring:message code="apo.payAmount"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="paymentAmount" id="paymentAmount">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="checkNumber"><spring:message code="apo.cheque"/>: </label>
                                <div class="col-xs-8">
                                    <input class="form-control" name="checkNumber" id="checkNumber">
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="problems"><spring:message code="apo.problems"/>: </label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="problems" id="problems" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="addSpec"><spring:message code="apo.addproblem"/></a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="symptoms"><spring:message code="apo.symptoms"/></label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="symptoms" id="symptoms" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="addSpec"><spring:message code="apo.addsymptom"/></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12" style="padding-top: 15px">
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="description"><spring:message code="apo.description"/>:</label>
                                <div class="col-xs-10">
                                    <textarea class="form-control" name="Description" id="description"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-xs-12">
                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary"><spring:message code="app.buttons.save"/></button>
                            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true"><spring:message code="app.buttons.cancel"/></button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>