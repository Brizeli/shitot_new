/**
 * Created by DDNS on 02.08.2016.
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
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>" + jqXHR.responseJSON,
        type: 'error',
        layout: 'center'
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
$(document).ajaxError(function (event, jqXHR, options, jsExc) {
    failNoty(event, jqXHR, options, jsExc);
});