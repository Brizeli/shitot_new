var editAppointmentWindow = $('#editAppointment');
var editForm = $('.editForm');
var appointmentsRestUrl = 'rest/appointments';
var doctorsRestUrl = 'rest/doctors';
var table;
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: appointmentsRestUrl,
            dataSrc: ''
        },
        dom: 'lrtip',
        lengthMenu: [5, 10, 25, "All"],
        columns: [
            {
                defaultContent: '',
                render: function (data, type, row) {
                    return renderAppointmentInfo(row);
                }
            },
            {
                defaultContent: '',
                render: function (data, type, row) {
                    return renderPatientInfo(row);
                }
            },
            {
                defaultContent: '',
                render: function (data, type, row) {
                    return renderAppointmentProblems(row);
                }
            },
            {
                defaultContent: '',
                render: function (data, type, row) {
                    return renderAppointmentDoctors(row);
                }
            }
        ],
        initComplete: function () {
            $('.datepicker').datepicker({
                format: 'dd/mm/yyyy',
                todayBtn: 'linked',
                clearBtn: true,
                // language: 'he',
                autoclose: true,
                todayHighlight: true
            });
            fillOptions();
            $('.nav').find('.active').removeClass('active');
            $('.nav a[href="appointmentsClients"]').parent().addClass('active');
        }
    });
    $('#search').keyup(function () {
        table.search(this.value).draw();
    });
    $('#clearsearch').click(function () {
        $('#search').val('').trigger('keyup');
    });
});
function fillOptions() {
    $('select', $('.editForm')).empty();
    $('.doctors').append($('<option>'));
    $.get(appointmentsRestUrl + '/symptoms', function (symptoms) {
        $.each(symptoms, function (key, val) {
            $('#symptoms').append($('<option>').text(val.name));
        });
        $('#symptoms').multiselect({maxHeight: 300});
    });
    $.get(appointmentsRestUrl + '/problems', function (problems) {
        $.each(problems, function (key, val) {
            $('#problems').append($('<option>').text(val.name));
        });
        $('#problems').multiselect({maxHeight: 300});
    });
    $.get(doctorsRestUrl, function (doctors) {
        $.each(doctors, function (key, val) {
            $('.doctors').append($('<option>').text(val.fullName).val(val.id));
        });
    });
}
function updateTable() {
    $.get(appointmentsRestUrl, function (data) {
        table.clear().rows.add(data).draw();
        fillOptions();
    });
}
function renderAppointmentInfo(appointment) {
    var res = '<a class="btn btn-sm btn-info" onclick="editAppointment(' + appointment.id + ')">' + i18n['app.buttons.edit'] + '</a> ';
    res += '<br>' + i18n['apo.applyDate'] + ': ' + (appointment.applyDate ? appointment.applyDate : '');
    res += '<br>' + i18n['apo.apoDate'] + ': ' + (appointment.appointmentDate ? appointment.appointmentDate : '');
    res += '<br>' + i18n['apo.payAmount'] + ': ' + appointment.paymentAmount;
    res += '<br>' + i18n['apo.payDate'] + ': ' + (appointment.paymentDate ? appointment.paymentDate : '');
    res += '<br>' + i18n['apo.cheque'] + ': ' + appointment.checkNumber;
    return res;
}
function renderPatientInfo(appointment) {
    return '<br>' + i18n['patient.name'] + ': ' + (appointment.patName ? appointment.patName : '') +
        '<br>' + i18n['patient.age'] + ": " + (appointment.age ? appointment.age : '') +
        '<br>' + i18n['patient.tel'] + ": " + (appointment.telNumber ? appointment.telNumber : '');
}
function renderAppointmentProblems(appointment) {
    var res = '<strong>' + i18n['apo.problems'] + ': </strong>';
    var problems = appointment.problems;
    for (var i = 0; i < problems.length; i++) {
        res += problems[i].name;
        if (i < problems.length - 1) res += ', ';
    }
    res += '<br><strong>' + i18n['apo.symptoms'] + ': </strong>';
    var symptoms = appointment.symptoms;
    for (var i = 0; i < symptoms.length; i++) {
        res += symptoms[i].name;
        if (i < symptoms.length - 1) res += ', ';
    }
    return res;
}
function renderAppointmentDoctors(appointment) {
    var res = '';
    res += '<div  class="col-xs-6">';
    if (appointment.doctor) {
        res += '<strong>' + i18n['doctor.doctor'] + ': </strong>' + renderDoctorInfo(appointment.doctor);
        res += '<br><a class="btn btn-xs btn-success" href="doctors?doctorAlt=false&appointmentId=' + appointment.id + '">' + i18n['app.buttons.change'] + '</a> ';
        res += '<a class="btn btn-xs btn-danger" onclick="removeDoctor(' + appointment.id + ',false)">' + i18n['app.buttons.delete'] + '</a><br>  ';
    } else {
        res += '<strong>' + i18n['doctor.doctor'] + ': </strong>';
        res += '<a class="btn btn-xs btn-primary" href="doctors?doctorAlt=false&appointmentId=' + appointment.id + '">' + i18n['app.buttons.add'] + '</a><br> ';

    }
    res += '</div><div  class="col-xs-6">';
    if (appointment.alternativeDoctor) {
        res += '<strong>' + i18n['doctor.altdoctor'] + ': </strong>' + renderDoctorInfo(appointment.alternativeDoctor);
        res += '<br><a class="btn btn-xs btn-success" href="doctors?doctorAlt=true&appointmentId=' + appointment.id + '">' + i18n['app.buttons.change'] + '</a> ';
        res += '<a class="btn btn-xs btn-danger" onclick="removeDoctor(' + appointment.id + ',true)">' + i18n['app.buttons.delete'] + '</a> ';
    } else {
        res += '<strong>' + i18n['doctor.altdoctor'] + ': </strong>';
        res += '<a class="btn btn-xs btn-primary" href="doctors?doctorAlt=true&appointmentId=' + appointment.id + '">' + i18n['app.buttons.add'] + '</a> ';
    }
    res += '</div>';
    return res;
}
function renderDoctorInfo(doctor) {
    var result = doctor.fullName + '<br>' +
        '<a href="mailto:' + doctor.email + '">' + doctor.email + '</a><br>' +
        i18n['doctors.tel'] + ': ' + doctor.telNumber + '<br>';
    if (doctor.telHome) result += i18n['doctors.hometel'] + ': ' + doctor.telHome + '<br>';
    if (doctor.homeAddress) result += i18n['doctors.address'] + ': ' + doctor.homeAddress;
    return result;
}
function removeDoctor(id, doctorAlt) {
    $.ajax({
        url: appointmentsRestUrl + '/' + id + '/' + doctorAlt,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty(i18n['app.deleted']);
        }
    });
}
function addAppointment(patientId) {
    $('.title', editAppointmentWindow).text(i18n['apo.addapo']);
    $(':text', editForm).val('');
    $(':input', editForm).val('');
    $('#applyDate').datepicker('update', new Date());
    $('option', editForm).removeAttr('selected').prop('selected', false);
    $('[multiple]').multiselect('refresh');
    $('textarea', editForm).val('');
    $('#id').val(null);
    $('.popover').popover('hide');
    $('#deleteAppointment').hide();
    editAppointmentWindow.modal({backdrop: 'static'});
}
function editAppointment(id) {
    $(':text', editForm).val('');
    $.get(appointmentsRestUrl + '/' + id, function (appointment) {
        $('option', editForm).removeAttr('selected').prop('selected', false);
        $('[multiple]').multiselect('refresh');
        $.each(appointment, function (key, val) {
            switch (key) {
                case 'doctor':
                    $('option:contains(' + val.fullName + ')', $('#doctor')).prop('selected', true);
                    break;
                case 'alternativeDoctor':
                    $('option:contains(' + val.fullName + ')', $('#altdoctor')).prop('selected', true);
                    break;
                case 'symptoms':
                    $.each(val, function (k, v) {
                        $('option:contains(' + v.name + ')', $('#symptoms')).prop('selected', true);
                    });
                    $('#symptoms').multiselect('refresh');
                    break;
                case'problems':
                    $.each(val, function (k, v) {
                        $('option:contains(' + v.name + ')', $('#problems')).prop('selected', true);
                    });
                    $('#problems').multiselect('refresh');
                    break;
                default:
                    $('[name=\'' + key + '\']', editForm).val(val);
            }
        });
        $('.title', editAppointmentWindow).text(i18n['apo.editapo']);
        $('#addSpec').popover('hide');
        $('#deleteAppointment').click(function () {
            return deleteAppointment(id);
        }).show();
        editAppointmentWindow.modal({backdrop: 'static'});
    });
}
function deleteAppointment(id) {
    if (confirm('Are you sure?'))
        $.ajax({
            url: appointmentsRestUrl + '/' + id,
            type: 'DELETE',
            success: function () {
                updateTable();
                editAppointmentWindow.modal('hide');
                successNoty(i18n['app.deleted']);
            }
        });
}
editForm.submit(function () {
    $.post(appointmentsRestUrl, editForm.serialize(), function () {
        editAppointmentWindow.modal('hide');
        updateTable();
        successNoty(i18n['app.saved']);
    });
    return false;
});
