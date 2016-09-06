<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="editSlots">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title title"></h2>
            </div>
            <form class="form-horizontal" method="post" id="slotsDetailsForm">
                <div class="modal-body">
                    <input type="text" hidden="hidden" name="clinicId" id="clinicId">
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c0"><spring:message code="schedule.day0"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[0].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(0)"
                                   data-three-state="false" id="c0" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i0" name="slotsTo[0].intervals">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c1"><spring:message code="schedule.day1"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[1].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(1)"
                                   data-three-state="false" id="c1" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i1" name="slotsTo[1].intervals">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c2"><spring:message code="schedule.day2"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[2].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(2)"
                                   data-three-state="false" id="c2" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i2" name="slotsTo[2].intervals">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c3"><spring:message code="schedule.day3"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[3].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(3)"
                                   data-three-state="false" id="c3" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i3" name="slotsTo[3].intervals">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c4"><spring:message code="schedule.day4"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[4].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(4)"
                                   data-three-state="false" id="c4" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i4" name="slotsTo[4].intervals">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c5"><spring:message code="schedule.day5"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[5].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(5)"
                                   data-three-state="false" id="c5" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i5" name="slotsTo[5].intervals">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-3" for="c6"><spring:message code="schedule.day6"/></label>
                        <div class="col-xs-1 checkbox">
                            <input type="checkbox" name="slotsTo[6].workDay" data-theme="krajee-flatblue" onchange="checkBoxChange(6)"
                                   data-three-state="false" id="c6" data-toggle="checkbox-x" data-size="md">
                        </div>
                        <div class="col-xs-8">
                            <input class="form-control" type="text" disabled id="i6" name="slotsTo[6].intervals">
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