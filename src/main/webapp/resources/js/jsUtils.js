/**
 * Created by Next on 02.08.2016.
 */
$(document).ajaxError(function (event, jqXHR, options, jsExc) {
    failNoty(event, jqXHR, options, jsExc);
});
$(function () {
    $('.nav li a').on('click', function() {
        $(this).parent().parent().find('.active').removeClass('active');
        $(this).parent().addClass('active');
    });
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
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + '<br>' + errorInfo.cause + '<br>' + errorInfo.details.join('<br>'),
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