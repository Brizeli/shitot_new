<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editAppointment">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title title"></h3>
            </div>
            <form class="form-horizontal" method="post" id="appointmentDetailsForm">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <input id="patientId" hidden="hidden" name="patientId" value="${patientId}"/>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="applyDate">Apply date:</label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="applyDate" id="applyDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="appointmentDate">Appointment date:</label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="appointmentDate" id="appointmentDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="paymentDate">Payment date:</label>
                                <div class="col-xs-8">
                                    <input class="form-control datepicker" name="paymentDate" id="paymentDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="paymentAmount">Payment amount:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="paymentAmount" id="paymentAmount">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="checkNumber">Cheque number:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" name="checkNumber" id="checkNumber">
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6" style="border-left: 1px solid grey">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="problems">Problems:</label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="problems" id="problems" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="btn btn-xs btn-default addSpec">Add problem</a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="symptoms">Symptoms:</label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="symptoms" id="symptoms" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="btn btn-xs btn-default addSpec">Add symptom</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12" style="padding-top: 15px">
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="description">Description:</label>
                                <div class="col-xs-10">
                                    <textarea class="form-control" name="Description" id="description"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="form-group">
                        <div class="col-xs-12">
                            <div class="pull-right">
                                <button type="submit" class="btn btn-primary">Save</button>
                                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="hide" id="addspec">
    <div class="input-group" id="addSpecForm">
        <input class="form-control" type="text">
        <span class="input-group-btn">
            <a class="btn btn-primary">Add</a>
        </span>
    </div>
</div>