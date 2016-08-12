/**
 * Created by DDNS on 06.08.2016.
 */
var editDoctorForm = $('#doctorDetailsForm');
var doctorsRestUrl = "rest/doctors";
function renderDoctorInfo(data, type, doctor) {
    if (type == 'display') {
        var result = '<h2><a onclick="editDoctor(' + doctor.id + ')" title="Edit">' + doctor.fullName + '</a></h2>' +
            '<a href="mailto:' + doctor.email + '">' + doctor.email + '</a><br>' +
            'Tel: ' + doctor.telNumber + '<br>';
        if (doctor.telHome) result += 'Home tel: ' + doctor.telHome + '<br>';
        if (doctor.homeAddress) result += 'Home address: ' + doctor.homeAddress;
        return result;
    }
    if (type == 'filter') {
        return doctor.fullName;
    }
    return "";
}
function renderSpecialization(data, type, doctor) {
    var filter = '';
    var display = '<strong>Certificate: </strong>';
    if (doctor.certificate) display += doctor.certificate.name;
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
    if (doctor.preferential) display += '<br><strong>Prefers: </strong>' + doctor.preferential;
    if (doctor.lections) display += '<br><strong>Reads lections: </strong>' + doctor.lections;
    display += '<br><strong>Target audience: </strong>';
    var target = doctor.targetAudiences;
    for (i = 0; i < target.length; i++) {
        display += target[i].name;
        if (i < target.length - 1) display += ', ';
    }
    if (doctor.comments) display += '<br><strong>Comments: </strong>' + doctor.comments;
    if (type == 'display') {
        return display;
    }
    if (type == 'filter') {
        return filter;
    }
    return "";
}
function addDoctor() {
    $(":text", editDoctorForm).empty();
    $("option", editDoctorForm).removeAttr("selected");
    $(".title", $("#editDoctor")).text("Add new doctor");
    $("textarea", editDoctorForm).empty();
    $('#id').val(null);
    $('#editDoctor').modal({backdrop: 'static'});
}
function editDoctor(id) {
    $.get(doctorsRestUrl + "/" + id, function (doctor) {
        console.log($("option", editDoctorForm));
        $("option", editDoctorForm).removeAttr('selected').prop('selected', false);
        $('#target, #quals').multiselect('refresh');
        $("#sec").hide();
        $.each(doctor, function (key, val) {
            switch (key) {
                case 'specialties':
                    $("[name='specialty1']", editDoctorForm).val(val[0] ? val[0].name : '');
                    $("[name='specialty2']", editDoctorForm).val(val[1] ? val[1].name : '');
                    break;
                case 'targetAudiences':
                    $.each(val, function (k, v) {
                        $("option:contains(" + v.name + ")", $("#target")).prop("selected", true);
                    });
                    $('#target').multiselect('refresh');
                    break;
                case'qualifications':
                    $.each(val, function (k, v) {
                        $("option:contains(" + v.name + ")", $("#quals")).prop("selected", true);
                    });
                    $('#quals').multiselect('refresh');
                    break;
                case 'certificate':
                    $("[name='" + key + "']", editDoctorForm).val(val.name);
                    break;
                default:
                    $("[name='" + key + "']", editDoctorForm).val(val);
            }
        });
        $(".title", $("#editDoctor")).text("Edit doctor");
        $("#editDoctor").modal({backdrop: "static"});
    })
}
editDoctorForm.submit(function () {
    $.post(doctorsRestUrl, editDoctorForm.serialize(), function () {
        $('#editDoctor').modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
$("#addSpecForm").submit(function () {
    $('#addSpec').modal('hide');
});
