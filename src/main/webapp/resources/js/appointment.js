var editAppointmentForm = $('#appointmentDetailsForm');
$(document).ready(renderPatientInfo);
function renderAppointmentInfo(data, type, appointment) {
    var res = '<a class="btn btn-xs btn-success" onclick="editAppointment(' + appointment.id + ')" title="Edit">Edit</a> ';
    res += '<a class="btn btn-xs btn-danger" onclick="deleteAppointment(' + appointment.id + ')" title="Delete">Delete</a>';
    res += '<br>Appointment Date:' + appointment.appointmentDate;
    res += '<br>Apply Date:' + appointment.applyDate;
    res += '<br>Payment amount:' + appointment.paymentAmount;
    res += '<br>Payment Date:' + appointment.paymentDate;
    return res;
}
function renderAppointmentProblems(data, type, appointment){
    var res ='<strong>Problems: </strong>';
    var problems=appointment.problems;
    for (var i = 0; i < problems.length; i++) {
        res +=  problems[i].name;
        if (i < problems.length - 1) res += ', ';
    };
    res+='<br><strong>Symptoms: </strong>';
    var symptoms=appointment.symptoms;
    for (var i = 0; i < symptoms.length; i++) {
        res +=  symptoms[i].name;
        if (i < symptoms.length - 1) res += ', ';
    };
    return res;
}
function renderPatientInfo(){
    var patientId=$('#patientId').val();
    var res1="";
    $.get("rest/patients/"+patientId, function (patient) {
        res1+=patient.name+' (Age: '+patient.age+', Tel: '+patient.telNumber+')';
        $('#patient1').html(res1);
    });

}
function renderAppointmentDoctors(data, type, appointment) {
    var res ='';
    if(appointment.doctor){
        res+='<strong>Doctor: </strong>'+renderDoctorInfo(appointment.doctor);
        res += '<br><a class="btn btn-xs btn-success" onclick="changeDoctor(' + appointment.id + ',\'change\',\'Doctor\')">Change</a> ';
        res += '<a class="btn btn-xs btn-danger" onclick="changeDoctor(' + appointment.id+ ',\'remove\',\'Doctor\')">Remove</a><br>  ';
    }else{
        res+="<strong>Doctor: </strong>";
        res += '<a class="btn btn-xs btn-primary" onclick="changeDoctor(' + appointment.id+ ',\'add\',\'Doctor\')">Add</a><br> ';

    }
    if(appointment.alternativeDoctor){
        res+="<strong>Another Doctor: </strong>"+renderDoctorInfo(appointment.alternativeDoctor);
        res += '<br><a class="btn btn-xs btn-success" onclick="changeDoctor(' + appointment.id + ',\'change\',\'AltDoctor\')">Change</a> ';
        res += '<a class="btn btn-xs btn-danger" onclick="changeDoctor(' + appointment.id+ ',\'remove\',\'AltDoctor\')">Remove</a> ';
    }else{
        res+="<strong>Another Doctor: </strong>";
        res += '<a class="btn btn-xs btn-primary" onclick="changeDoctor(' + appointment.id+ ',\'add\',\'AltDoctor\')">Add</a> ';
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
function changeDoctor(id,type,doctorAlt){
    //window.location.href='patients/appointment/'+patienId;
    if(type=="remove") {
        $.ajax({
            url: "rest/patients/appointment/"+doctorAlt+"/" + id + "/",
            type: 'DELETE',
            success: function () {
                updateTable();
                successNoty('Deleted');
            }
        });
    }else{
        $.ajax({
            url: "patients/appointment/doctorList/params/"+id+"/"+doctorAlt,
            type: 'POST',
            success: function(){
                window.location.href='patients/appointment/doctorList';
            }
        });


    }
}

function addAppointment() {

}
function editAppointment(id) {

}
editAppointmentForm.submit(function () {

    return false;
});

