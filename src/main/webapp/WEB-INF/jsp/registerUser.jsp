<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="regUserWindow">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h3 class="modal-title">Register new user</h3>
            </div>
            <form class="form-horizontal editForm" method="post" action="register">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lgn">Login:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="newlogin" id="lgn" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="psw">Password:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="password" name="newpassword" id="psw" required/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="col-xs-12">
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