
var editPatientForm = $('#patientDetailsForm');
var editPatientWindow = $('#editPatient');


//function renderPatientName(data, type, patient) {
//    if (type == 'display') {
//        return '<a onclick="editPatient(' + patient.id + ')" title="Edit">' + patient.name + '</a>';
//    }
//    if (type == 'filter') {
//        return patient.name;
//    }
//    return "";
//}
//function renderTelephone(data, type, patient) {
//    if (type == 'display') {
//        return  patient.telNumber;
//    }
//    if (type == 'filter') {
//        return patient.telNumber;
//    }
//    return "";
//}
//function renderPatientAge(data, type, patient) {
//    if (type == 'display') {
//        var res ="";
//        if(patient.age)res=patient.age;
//        return res;
//    }
//    if (type == 'filter') {
//        return patient.age;
//    }
//    return "";
//}
function renderButton(data, type, patient){
    var result="";
    result += '<a class="btn btn-xs btn-primary" onclick="editPatient(' + patient.id + ');">Edit</a> ';
    result += '<a class="btn btn-xs btn-danger" onclick="deletePatient(' + patient.id+ ');">Delete</a> ';
    result += '<a class="btn btn-xs btn-success" onclick="AppointmentWindow('+patient.id+');">Appointments</a>';
    return result;

}
function AppointmentWindow(patienId){
    window.location.href='patients/appointment/'+patienId;

}
function renderCreateAppointment(data, type, doctor) {
    return "";
}
function addPatient() {
    $(":input",editPatientForm).val("");
    $(".title", editPatientWindow).text("Add new patient");
    $('#id').val(null);
    $('#editPatient').modal({backdrop: 'static'});
}
function editPatient(id) {
    $.get("rest/patients/" + id, function (patient) {
        $.each(patient, function (key, val) {
            editPatientForm.find("[name='" + key + "']").val(val);
        });
        $(".title", editPatientWindow).text("Edit patient");
        $('#editPatient').modal({backdrop: 'static'});
    })
}
function showAppointments(patientId){

    $(location).href="patients/appointment/"+patientId;
}
editPatientForm.submit(function () {
    $.post("rest/patients", editPatientForm.serialize(), function () {
        $('#editPatient').modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
function deletePatient(patientId){
    $.ajax({
        url: "rest/patients/" + patientId + "/" ,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}
