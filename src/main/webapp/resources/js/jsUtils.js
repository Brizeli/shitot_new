/**
 * Created by Next on 02.08.2016.
 */
$(function () {
    var lang = $('html').attr('lang');
    if (lang === 'iw') {
        $('#bsrtltag').attr('href','https://cdnjs.cloudflare.com/ajax/libs/bootstrap-rtl/3.2.0-rc2/css/bootstrap-rtl.min.css');
        $('html').attr('dir', 'rtl');
        $('ul.navbar-right').removeClass('navbar-right').addClass('navbar-left');
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
$('.addSpec').popover({
    html: true,
    trigger: 'manual',
    placement: 'bottom',
    content: function () {
        return $('#addspec').html();
    }
}).click(function () {
    $(this).popover('toggle');
    $('.editForm').on('keyup keypress', function (e) {
        if (e.keyCode == 13) {
            e.preventDefault();
            return false;
        }
    });
    $('input', $('#addSpecForm')).on('keyup', function (e) {
        if (e.keyCode == 13) addSpec(this);
    });
    $('a', $('#addSpecForm')).click(function () {
        addSpec(this)
    });
    function addSpec(el) {
        var value = $('input', $('#addSpecForm')).val();
        if (value.trim() != '') {
            $(el).parentsUntil('.form-group').parent().find('select').first().append($('<option selected>').text(value));
            $('[multiple]').multiselect('rebuild');
            $('.addSpec').popover('hide');
        }
    }
});