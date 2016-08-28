<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="modal fade" id="editPatient">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title title"></h2>
            </div>
            <form class="form-horizontal editForm" method="post">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="name"><spring:message code="patient.name"/>:</label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="name" id="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="age"><spring:message code="patient.age"/>:</label>
                        <div class="col-xs-8">
                            <input class="form-control" type="number" name="age" id="age">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="telNumber"><spring:message code="patient.tel"/>:</label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="telNumber" id="telNumber" required>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="pull-right">
                        <button type="submit" class="btn btn-primary"><spring:message code="app.buttons.save"/></button>
                        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true"><spring:message code="app.buttons.cancel"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
