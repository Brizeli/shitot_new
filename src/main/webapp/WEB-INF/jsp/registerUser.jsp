<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="regUserWindow">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title"><spring:message code="users.register"/></h3>
            </div>
            <form class="form-horizontal editForm" method="post" action="register">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lgn"><spring:message code="app.login"/></label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="newlogin" id="lgn" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="psw"><spring:message code="app.password"/></label>
                        <div class="col-xs-9">
                            <input class="form-control" type="password" name="newpassword" id="psw" required/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-xs-12">
                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary"><spring:message code="app.buttons.save"/></button>
                            <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">
                                <spring:message code="app.buttons.cancel"/>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>