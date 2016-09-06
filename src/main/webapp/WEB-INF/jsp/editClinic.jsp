<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editClinic">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title title"></h2>
            </div>
            <form class="form-horizontal" method="post" id="clinicDetailsForm">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <input type="text" hidden="hidden" name="doctorId" id="doctorId">
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="name"><spring:message code="clinics.name"/></label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="name" id="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="city"><spring:message code="clinics.city"/></label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="city" id="city" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="address"><spring:message code="clinics.address"/></label>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" name="address" id="address" required>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="pull-right">
                        <button type="submit" class="btn btn-primary"><spring:message code="app.buttons.save"/></button>
                        <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                            <spring:message code="app.buttons.cancel"/>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
