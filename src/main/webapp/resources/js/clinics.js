/**
 * Created by Next on 06.08.2016.
 */
var clinicsRestUrl = 'rest/clinics';
var editClinicWindow = $('#editClinic');
var editClinicForm = $('#clinicDetailsForm');
var daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
function renderClinics(data, type, doctor) {
    var clinics = doctor.clinics;
    var result = '';
    var filter = '';
    for (var i = 0; i < clinics.length; i++) {
        result += i + 1 + '. ' + ((clinics[i].name != '') ? '<strong>' + clinics[i].name + '</strong>' : '') + '<br>';
        result += '<strong>City: </strong>' + '<a onclick="getByCity(\'' + clinics[i].city + '\')">' + clinics[i].city + '</a><br>';
        result += '<strong>Address: </strong>' + clinics[i].address + '<br>';
        result += '<a class="btn btn-xs btn-primary" onclick="editClinic(' + clinics[i].id + ',' + doctor.id + ',\'' + doctor.fullName + '\');">Edit</a> ';
        result += '<a tabindex="0" class="btn btn-xs btn-success" data-slots=\'' + JSON.stringify(clinics[i].slots) + '\'>Schedule</a> ';
        result += '<a class="btn btn-xs btn-danger" onclick="deleteClinic(' + clinics[i].id + ',' + doctor.id + ');">Delete</a>';
        if (i < clinics.length) result += '<br><br>';
        filter += clinics[i].city + ' ';
    }
    if (clinics.length < 2)
        result += '<a class="btn btn-sm btn-default" onclick="addClinic(' + doctor.id + ',\'' + doctor.fullName + '\');">Add clinic</a>';
    if (type == 'display')
        return result;
    if (type == 'filter')
        return filter;
    return '';
}
function editClinic(id, doctorId, doctorName) {
    $.get(clinicsRestUrl + '/' + id + '/' + doctorId, function (clinic) {
        $.each(clinic, function (key, val) {
            editClinicForm.find('[name=\'' + key + '\']').val(val)
        });
        $('#doctorId', editClinicForm).val(doctorId);
        $('.title', editClinicWindow).text('Edit clinic for doctor ' + doctorName);
        editClinicWindow.modal({backdrop: 'static'});
    })
}
function addClinic(doctorId, doctorName) {
    editClinicForm.find(':text').val('');
    $('.title', editClinicWindow).text('Add new clinic for ' + doctorName);
    $('#id', editClinicForm).val(null);
    $('#doctorId', editClinicForm).val(doctorId);
    editClinicWindow.modal({backdrop: 'static'});
}
function deleteClinic(id, doctorId) {
    $.ajax({
        url: clinicsRestUrl + "/" + id + "/" + doctorId,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}
editClinicForm.submit(function () {
    $.post(clinicsRestUrl, editClinicForm.serialize(), function () {
        editClinicWindow.modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});