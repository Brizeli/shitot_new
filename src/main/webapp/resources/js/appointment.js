var editAppointmentWindow = $('#editAppointment');
var editAppointmentForm = $('#appointmentDetailsForm');
var appointmentsRestUrl = "rest/appointments";
var patientsRestUrl = "rest/patients";
function renderAppointmentInfo(data, type, appointment) {
    var res = '<a class="btn btn-xs btn-success" onclick="editAppointment(' + appointment.id + ')" title="Edit">Edit</a> ';
    res += '<a class="btn btn-xs btn-danger" onclick="deleteAppointment(' + appointment.id + ')" title="Delete">Delete</a>';
    res += '<br>Appointment Date: ' + appointment.appointmentDate;
    res += '<br>Apply Date: ' + appointment.applyDate;
    res += '<br>Payment amount: ' + appointment.paymentAmount;
    res += '<br>Payment Date: ' + appointment.paymentDate;
    res += '<br>Cheque number: ' + appointment.checkNumber;
    return res;
}
function renderAppointmentProblems(data, type, appointment) {
    var res = '<strong>Problems: </strong>';
    var problems = appointment.problems;
    for (var i = 0; i < problems.length; i++) {
        res += problems[i].name;
        if (i < problems.length - 1) res += ', ';
    }
    res += '<br><strong>Symptoms: </strong>';
    var symptoms = appointment.symptoms;
    for (var i = 0; i < symptoms.length; i++) {
        res += symptoms[i].name;
        if (i < symptoms.length - 1) res += ', ';
    }
    return res;
}
function renderAppointmentDoctors(data, type, appointment) {
    var res = '';
    if (appointment.doctor) {
        res += '<strong>Doctor: </strong>' + renderDoctorInfo(appointment.doctor);
        res += '<br><a class="btn btn-xs btn-success" href="doctors?doctorAlt=false&appointmentId=' + appointment.id + '">Change</a> ';
        res += '<a class="btn btn-xs btn-danger" onclick="removeDoctor(' + appointment.id + ',false)">Remove</a><br>  ';
    } else {
        res += "<strong>Doctor: </strong>";
        res += '<a class="btn btn-xs btn-primary" href="doctors?doctorAlt=false&appointmentId=' + appointment.id + '">Add</a><br> ';

    }
    if (appointment.alternativeDoctor) {
        res += "<strong>Another Doctor: </strong>" + renderDoctorInfo(appointment.alternativeDoctor);
        res += '<br><a class="btn btn-xs btn-success" href="doctors?doctorAlt=true&appointmentId=' + appointment.id + '">Change</a> ';
        res += '<a class="btn btn-xs btn-danger" onclick="removeDoctor(' + appointment.id + ',true)">Remove</a> ';
    } else {
        res += "<strong>Another Doctor: </strong>";
        res += '<a class="btn btn-xs btn-primary" href="doctors?doctorAlt=true&appointmentId=' + appointment.id + '">Add</a> ';
    }
    return res;
}

function renderDoctorInfo(doctor) {
    var result = doctor.fullName + '<br>' +
        '<a href="mailto:' + doctor.email + '">' + doctor.email + '</a><br>' +
        'Tel: ' + doctor.telNumber + '<br>';
    if (doctor.telHome) result += 'Home tel: ' + doctor.telHome + '<br>';
    if (doctor.homeAddress) result += 'Home address: ' + doctor.homeAddress;
    return result;
}
function removeDoctor(id, doctorAlt) {
    $.ajax({
        url: appointmentsRestUrl + "/" + id + "/" + doctorAlt,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function addAppointment(patientId) {
    $(".title", editAppointmentWindow).text("Add appointment for: " + $('#patient1').text());
    $(":text", editAppointmentForm).val('');
    $('#patientId').val(patientId);
    $('#applyDate').datepicker('update', new Date());
    $("option", editAppointmentForm).removeAttr('selected').prop('selected', false);
    $('#problems, #symptoms').multiselect('refresh');
    $("textarea", editAppointmentForm).val('');
    $('#id').val(null);
    $('.popover').popover('hide');
    editAppointmentWindow.modal({backdrop: 'static'});
}
function editAppointment(id) {
    $.get(appointmentsRestUrl + "/" + id, function (appointment) {
        $("option", editAppointmentForm).removeAttr('selected').prop('selected', false);
        $('#problems, #symptoms').multiselect('refresh');
        $.each(appointment, function (key, val) {
            switch (key) {
                case 'symptoms':
                    $.each(val, function (k, v) {
                        $("option:contains(" + v.name + ")", $("#symptoms")).prop("selected", true);
                    });
                    $('#symptoms').multiselect('refresh');
                    break;
                case'problems':
                    $.each(val, function (k, v) {
                        $("option:contains(" + v.name + ")", $("#problems")).prop("selected", true);
                    });
                    $('#problems').multiselect('refresh');
                    break;
                default:
                    $("[name='" + key + "']", editAppointmentForm).val(val);
            }
        });
        $(".title", editAppointmentWindow).text("Edit appointment for: " + $('#patient1').text());
        $("#addSpec").popover('hide');
        editAppointmentWindow.modal({backdrop: "static"});
    })
}
editAppointmentForm.submit(function () {
    $.post(appointmentsRestUrl, editAppointmentForm.serialize(), function () {
        editAppointmentWindow.modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
$(".addSpec").popover({
    html: true,
    trigger: 'manual',
    placement: 'bottom',
    content: function () {
        return $('#addspec').html();
    }
}).click(function () {
    $(this).popover('toggle');
    editAppointmentForm.on('keyup keypress', function (e) {
        if (e.keyCode == 13) {
            e.preventDefault();
            return false;
        }
    });
    $('input', $("#addSpecForm")).on('keyup', function (e) {
        if (e.keyCode == 13) {
            var value = $('input', $('#addSpecForm')).val();
            if (value.trim() != '') {
                $(this).parentsUntil('.form-group').parent().find('select').first().append($('<option selected>').text(value));
                $('#problems, #symptoms').multiselect('rebuild');
                $(".addSpec").popover('hide');
            }
        }
    });
    $('a', $("#addSpecForm")).click(function () {
        var value = $('input', $('#addSpecForm')).val();
        if (value.trim() != '') {
            $(this).parentsUntil('.form-group').parent().find('select').append($('<option selected>').text(value));
            $('#problems, #symptoms').multiselect('rebuild');
            $(".addSpec").popover('hide');
        }
    });
});
