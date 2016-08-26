/**
 * Created by Next on 06.08.2016.
 */
var editDoctorWindow = $('#editDoctorWindow');
var editForm = $('.editForm');
var doctorsRestUrl = 'rest/doctors';
var appointmentsRestUrl = 'rest/appointments';
function renderDoctorInfo(data, type, doctor) {
    var display = '<h2><a onclick="editDoctor(' + doctor.id + ')" title="Edit">' + doctor.fullName + '</a></h2>';
    display += '<a href="mailto:' + doctor.email + '">' + doctor.email + '</a><br>';
    if (doctor.telNumber)
        display += 'Tel: ' + doctor.telNumber + '<br>';
    if (doctor.telHome)
        display += 'Home tel: ' + doctor.telHome + '<br>';
    if (doctor.homeAddress)
        display += 'Home address: ' + doctor.homeAddress;
    if ($('#appointmentId').val() != '')
        display += '<br><a class="btn btn-xs btn-info" onclick="selectDoctor(' + doctor.id + ');">Select</a>';
    if (type == 'display')
        return display;
    if (type == 'filter')
        return doctor.fullName;
    return "";
}
function renderSpecialization(data, type, doctor) {
    var filter = '';
    var display = '<strong>Certificate: </strong>';
    if (doctor.certificate)
        display += doctor.certificate.name;
    display += '<br><strong>Profession: </strong>';
    var specialties = doctor.specialties;
    for (var i = 0; i < specialties.length; i++) {
        display += '<a onclick="getBySpecialty(\'' + specialties[i].name + '\')">' + specialties[i].name + '</a>';
        if (i < specialties.length - 1) display += ', ';
        filter += specialties[i].name + ' ';
    }
    display += '<br><strong>Qualifications: </strong>';
    var qualifications = doctor.qualifications;
    for (i = 0; i < qualifications.length; i++) {
        display += '<a onclick="getByQualification(\'' + qualifications[i].name + '\')">' + qualifications[i].name + '</a>';
        if (i < qualifications.length - 1) display += ', ';
        filter += qualifications[i].name;
    }
    if (doctor.preferential)
        display += '<br><strong>Prefers: </strong>' + doctor.preferential;
    if (doctor.lections)
        display += '<br><strong>Reads lections: </strong>' + doctor.lections;
    display += '<br><strong>Target audience: </strong>';
    var target = doctor.targetAudiences;
    for (i = 0; i < target.length; i++) {
        display += target[i].name;
        if (i < target.length - 1) display += ', ';
    }
    if (doctor.comments)
        display += '<br><strong>Comments: </strong>' + doctor.comments;
    if (type == 'display')
        return display;
    if (type == 'filter')
        return filter;
    return '';
}
function addDoctor() {
    $(':text', editForm).val('');
    $('option', editForm).removeAttr('selected').prop('selected', false);
    $('[multiple]').multiselect('refresh');
    $('.title', editDoctorWindow).text("Add new doctor");
    $('textarea', editForm).val('');
    $('#id').val(null);
    $('.popover').popover('hide');
    $('#sec').show();
    $('.modal-header a').hide();
    editDoctorWindow.modal({backdrop: 'static'});
}
function editDoctor(id) {
    $.get(doctorsRestUrl + '/' + id, function (doctor) {
        $('option', editForm).removeAttr('selected').prop('selected', false);
        $('[multiple]').multiselect('refresh');
        $('#sec').hide();
        $.each(doctor, function (key, val) {
            switch (key) {
                case 'specialties':
                    $('[name=\'specialty1\']', editForm).val(val[0] ? val[0].name : '');
                    $('[name=\'specialty2\']', editForm).val(val[1] ? val[1].name : '');
                    break;
                case 'targetAudiences':
                    $.each(val, function (k, v) {
                        $('option:contains(' + v.name + ')', $('#target')).prop('selected', true);
                    });
                    $('#target').multiselect('refresh');
                    break;
                case'qualifications':
                    $.each(val, function (k, v) {
                        $('option:contains(' + v.name + ')', $('#quals')).prop('selected', true);
                    });
                    $('#quals').multiselect('refresh');
                    break;
                case 'certificate':
                    $('[name=\'' + key + '\']', editForm).val(val.name);
                    break;
                default:
                    $('[name=\'' + key + '\']', editForm).val(val);
            }
        });
        $('.title', editDoctorWindow).text('Edit doctor');
        $('#addSpec').popover('hide');
        editDoctorWindow.modal({backdrop: 'static'});
        $('#deleteDoctor').click(function () {
            return deleteDoctor(id);
        }).show();
    })
}
function deleteDoctor(id) {
    if (confirm('Are you sure?'))
        $.ajax({
            url: doctorsRestUrl + '/' + id,
            type: 'DELETE',
            success: function () {
                updateTable();
                editDoctorWindow.modal('hide');
                successNoty('Deleted');
            }
        });
}
function selectDoctor(doctorId) {
    var appointmentId = $('#appointmentId').val();
    var doctorAlt = $('#doctorAlt').val();
    $.ajax({
        url: appointmentsRestUrl + '/' + appointmentId + '/' + doctorId + '/' + doctorAlt,
        type: 'POST',
        success: function () {
            history.back();
        }
    });
}
editForm.submit(function () {
    var formData = new FormData(editForm);
    $.post(doctorsRestUrl, editForm.serialize(), function () {
        editDoctorWindow.modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
function getBySpecialty(name) {
    $("#professions").val(name).trigger('change');
}
function getByQualification(name) {
    $('#qualifications').val(name).trigger('change');
}
function getByCity(name) {
    $('#cities').val(name).trigger('change');
}