<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Edit doctor</h2>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="detailsForm">
                    <input type="text" hidden="hidden" name="id" id="id">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="name">Name:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="fullName" id="name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="email">Email:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="email" name="email" id="email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="telNumber">Tel number:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="telNumber" id="telNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="telHome">Home tel:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="telHome" id="telHome">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="homeAddress">Home address:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="homeAddress" id="homeAddress">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="prefer">Prefferencies:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="preferential" id="prefer">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="lections">Lections:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="lections" id="lections">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="comments">Comments:</label>
                        <div class="col-xs-9">
                            <input class="form-control" type="text" name="comments" id="comments">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>