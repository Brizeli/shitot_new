<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editPatient">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title title"></h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="patientDetailsForm">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="name">Patient name:</label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="name" id="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="age">Age:</label>
                        <div class="col-xs-8">
                            <input class="form-control" type="number" name="age" id="age">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="tel">Telephone:</label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="tel" id="tel" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="form-group">
                            <div class="pull-right">
                                <button type="submit" class="btn btn-primary">Save</button>
                                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
