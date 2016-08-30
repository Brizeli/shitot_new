/**
 * Created by Next on 02.08.2016.
 */
$(function () {
    var lang = $('html').attr('lang');
    if (lang === 'iw') {
        $('#bsrtltag').attr('href','//cdn.rawgit.com/morteza/bootstrap-rtl/v3.3.4/dist/css/bootstrap-rtl.min.css');
        $('html').attr('dir', 'rtl');
        $('.dropdown-menu').css({right: 'auto', left: '0'});
        $('ul.navbar-right').removeClass('navbar-right').addClass('navbar-left');
        $('.pull-right').removeClass('pull-right').addClass('pull-left');
    }
});
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
    // debugger;
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + '<br>' + errorInfo.cause + '<br>' + errorInfo.details.join('<br>'),
        type: 'error',
        layout: 'center',
        // timeout: 2000
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
