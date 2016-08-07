<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editDoctor">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title title"></h2>
            </div>
            <form class="form-horizontal" method="post" id="doctorDetailsForm">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="id" id="id">

                    <div class="row">
                        <div class="col-xs-6" style="border-right: 1px solid grey">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="name">Name:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="fullName" id="name" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="email">Email:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="email" id="email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="telNumber">Tel number:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="telNumber" id="telNumber">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="telHome">Home tel:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="telHome" id="telHome">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="homeAddress">Home address:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="homeAddress" id="homeAddress">
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="control-label col-xs-4" for="prefer">Prefferencies:</label>
                                <div class="col-xs-8">
                                    <input class="form-control" type="text" name="preferential" id="prefer">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">Professions:</label>
                                <div class="col-xs-4">
                                    <select class="form-control professions" type="text" name="specialty1">
                                        <option></option>
                                    </select>
                                </div>
                                <div class="col-xs-4">
                                    <select class="form-control professions" type="text" name="specialty2">
                                        <option></option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">Target audience:</label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="targetAudiences" id="target" multiple="multiple"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">Qualifications:</label>
                                <div class="col-xs-8">
                                    <select class="form-control qualifications" name="qualifications" id="quals"
                                            multiple="multiple"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-4">Certificate:</label>
                                <div class="col-xs-8">
                                    <select class="form-control" name="certificate" id="certificates">
                                        <option></option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12" style="padding-top: 15px">
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="lections">Lections:</label>
                                <div class="col-xs-10">
                                    <textarea class="form-control" name="lections" id="lections"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="comments">Comments:</label>
                                <div class="col-xs-10">
                                    <textarea class="form-control" name="comments" id="comments"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="form-group">
                        <label class="control-label col-xs-2" for="login">Login:</label>
                        <div class="col-xs-2">
                            <input class="form-control" type="text" name="login" id="login" required>
                        </div>
                        <label class="control-label col-xs-2" for="password">Password:</label>
                        <div class="col-xs-2">
                            <input class="form-control" type="text" name="password" id="password" required>
                        </div>
                        <div class="col-xs-4">
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