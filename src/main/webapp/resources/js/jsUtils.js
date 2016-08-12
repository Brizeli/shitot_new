/**
 * Created by Next on 02.08.2016.
 */
$(document).ajaxError(function (event, jqXHR, options, jsExc) {
    failNoty(event, jqXHR, options, jsExc);
});
var failedNote;
function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}
function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    console.log(jqXHR.responseText);
    debugger;
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>" + jqXHR.responseJSON.cause + "<br>" + jqXHR.responseJSON.detail,
        type: 'error',
        layout: 'center',
        timeout: 2000
    });
}
function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'center',
        timeout: 1000
    });
}