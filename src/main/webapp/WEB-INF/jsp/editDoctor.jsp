<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editDoctorWindow">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title title"></h2>
                <a class="btn btn-xs btn-danger" id="deleteDoctor"><spring:message code="common.delete"/></a>
            </div>
            <form class="form-horizontal editForm" enctype="multipart/form-data" method="post">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="name"><spring:message code="doctors.name"/></label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="fullName" id="name" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="email"><spring:message code="doctors.email"/></label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="email" id="email" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="telNumber"><spring:message code="doctors.tel"/></label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="telNumber" id="telNumber">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="telHome"><spring:message code="doctors.hometel"/></label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="telHome" id="telHome">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="homeAddress">
                                    <spring:message code="doctors.address"/>
                                </label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="homeAddress" id="homeAddress">
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="prefer"><spring:message code="doctors.prefers"/></label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="preferential" id="prefer">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4"><spring:message code="doctors.profession"/></label>
                                <div class="col-xs-4">
                                    <select class="form-control professions" type="text" name="specialty1"></select>
                                </div>
                                <div class="col-xs-4">
                                    <select class="form-control professions" type="text" name="specialty2"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="addSpec"><spring:message code="doctors.addprofession"/></a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4"><spring:message code="doctors.target"/></label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="targetAudiences" id="target" multiple="multiple"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="addSpec"><spring:message code="doctors.addtarget"/></a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4"><spring:message code="doctors.qualification"/></label>
                                <div class="col-xs-8">
                                    <select class="form-control qualifications" name="qualifications" id="quals"
                                            multiple="multiple"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="addSpec"><spring:message code="doctors.addqualification"/></a>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4"><spring:message code="doctors.certificate"/></label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="certificate" id="certificates"></select>
                                </div>
                                <div class="col-xs-8 col-xs-offset-4">
                                    <a class="addSpec"><spring:message code="doctors.addcertificate"/></a>
                                    <input type="file" name="file">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12" style="padding-top: 15px">
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="lections"><spring:message code="doctors.lections"/></label>
                                <div class="col-xs-10">
                                    <textarea class="form-control" name="lections" id="lections"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="comments"><spring:message code="doctors.comments"/></label>
                                <div class="col-xs-10">
                                    <textarea class="form-control" name="comments" id="comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-xs-8">
                        <div class="row" id="sec">
                            <label class="control-label col-xs-3" for="login"><spring:message code="app.login"/></label>
                            <div class="col-xs-3">
                                <input class="form-control" type="text" name="login" id="login" required>
                            </div>
                            <label class="control-label col-xs-2" for="password"><spring:message code="app.password"/></label>
                            <div class="col-xs-3">
                                <input class="form-control" type="text" name="password" id="password" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-4">
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
