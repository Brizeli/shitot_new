var editAppointmentForm = $('#appointmentDetailsForm');
$(function () {
    renderPatientInfo();
});
function renderAppointmentInfo(data, type, appointment) {
    var res = '<a class="btn btn-xs btn-success" onclick="editAppointment(' + appointment.id + ')" title="Edit">Edit</a> ';
    res += '<a class="btn btn-xs btn-danger" onclick="deleteAppointment(' + appointment.id + ')" title="Delete">Delete</a>';
    res += '<br>Appointment Date:' + appointment.appointmentDate;
    res += '<br>Apply Date:' + appointment.applyDate;
    res += '<br>Payment amount:' + appointment.paymentAmount;
    res += '<br>Payment Date:' + appointment.paymentDate;
    return res;
}
function renderAppointmentProblems(data, type, appointment) {
    var res = '<strong>Problems: </strong>';
    var problems = appointment.problems;
    for (var i = 0; i < problems.length; i++) {
        res += problems[i].name;
        if (i < problems.length - 1) res += ', ';
    }
    ;
    res += '<br><strong>Symptoms: </strong>';
    var symptoms = appointment.symptoms;
    for (var i = 0; i < symptoms.length; i++) {
        res += symptoms[i].name;
        if (i < symptoms.length - 1) res += ', ';
    }
    ;
    return res;
}
function renderPatientInfo() {
    var patientId = $('#patientId').val();
    $.get("rest/patients/" + patientId, function (patient) {
        $('#patient1').text(patient.name + ' (Age: ' + patient.age + ', Tel: ' + patient.telNumber + ')');
    });

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

function renderDoctorInfo(doctorA) {
    var result = doctorA.fullName + '<br>' +
        '<a href="mailto:' + doctorA.email + '">' + doctorA.email + '</a><br>' +
        'Tel: ' + doctorA.telNumber + '<br>';
    if (doctorA.telHome) result += 'Home tel: ' + doctorA.telHome + '<br>';
    if (doctorA.homeAddress) result += 'Home address: ' + doctorA.homeAddress;
    return result;
}
function removeDoctor(id, doctorAlt) {
    $.ajax({
        url: "rest/appointments/" + id + "/" + doctorAlt,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}

function addAppointment() {

}
function editAppointment(id) {

}
editAppointmentForm.submit(function () {

    return false;
});

