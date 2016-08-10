
var editAppointmentForm = $('#appointmentDetailsForm');

function renderAppointmentInfo(data, type, appointment) {
    if (type == 'display') {
        var res= '<a class="btn btn-xs btn-primary" onclick="editAppointment(' + appointment.id + ')" title="Edit">Edit</a>';
        res+='<br>Appointment Date:'+appointment.appointmentDate;
        res+='<br>Apply Date:'+appointment.applyDate;
        res+='<br>Payment amount:'+appointment.paymentAmount;
        res+='<br>Payment Date:'+appointment.paymentDate;
        return res;
    }
    if (type == 'filter') {
        //return appointment.name;
    }
    return "";
}
function renderTelephone(data, type, patient) {
    if (type == 'display') {
        return  patient.telNumber;
    }
    if (type == 'filter') {
        return patient.telNumber;
    }
    return "";
}
function renderPatientAge(data, type, patient) {
    if (type == 'display') {
        var res ="";
        if(patient.age)res=patient.age;
        return res;
    }
    if (type == 'filter') {
        return patient.age;
    }
    return "";
}
function renderButton(data, type, patient){
    var result="";
    result += '<a class="btn btn-xs btn-primary" onclick="editPatient(' + patient.id + ');">Edit</a> ';
    result += '<a class="btn btn-xs btn-danger" onclick="deletePatient(' + patient.id+ ');">Delete</a> ';
    result += '<a class="btn btn-xs btn-success" onclick="showAppointments(' + patient.id+ ');">Appointments</a> ';
    return result;

}
function renderCreateAppointment(data, type, doctor) {
    return "";
}
function addPatient() {
    $(":text",editPatientForm).empty();
    //editDoctorForm.find("option").removeAttr("selected");
    $(".title", $("#editPatient")).text("Add new patient");
    $("textarea",editPatientForm).empty();
    $('#id').val(null);
    $('#editPatient').modal({backdrop: 'static'});
}
function editDoctor(id) {
    //$.get("rest/doctors/" + id, function (doctor) {
    //    editDoctorForm.find("option").removeAttr("selected");
    //    $.each(doctor, function (key, val) {
    //        if (key == 'specialties') {
    //            editDoctorForm.find("[name='specialty1']").val(val[0] ? val[0].name : '');
    //            editDoctorForm.find("[name='specialty2']").val(val[1] ? val[1].name : '');
    //        }
    //        if (key == 'targetAudiences') {
    //            $('option', $('#target')).removeAttr('selected').prop('selected', false);
    //            $.each(val, function (k, v) {
    //                $("option:contains(" + v.name + ")", $("#target")).prop("selected", true);
    //            });
    //            $('#target').multiselect('refresh');
    //        }
    //        if (key == 'certificate') {
    //            editDoctorForm.find("[name='" + key + "']").val(val.name);
    //        }
    //        else editDoctorForm.find("[name='" + key + "']").val(val);
    //    });
    //    $(".title", editDoctorForm).text("Edit doctor");
    //    $('#editDoctor').modal({backdrop: 'static'});
    //})
}
editDoctorForm.submit(function () {
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
