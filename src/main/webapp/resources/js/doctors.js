$(function () {
    updateTable();
    $('#selectable').selectable();
});
function updateTable() {
    $.get("rest/doctors", updateTableByData)
}
function getBySpecialty(name) {
    $.get("rest/doctors/by/?specialty=" + name, updateTableByData)
}
function getByQualification(name) {
    $.get("rest/doctors/by/?qualification=" + name, updateTableByData)
}
function updateTableByData(doctorList) {
    var table = $('.doctorlist');
    table.empty();
    for (var d in doctorList) {
        var doctor = doctorList[d];
        var row = $('<div class="doctorInfo">');
        row.append('<h3><a onclick="editRow(' + doctor.id + ')" title="Edit">' + doctor.fullName + '</a></h3>');
        row.append($('<a href="mailto:' + doctor.email + '">').text(doctor.email));
        row.append('<br>Tel: ' + doctor.telNumber);
        if (doctor.telHome)
            row.append('<br>Home tel: ' + doctor.telHome);
        if (doctor.homeAddress)
            row.append('<br>Home address: ' + doctor.homeAddress);
        if (doctor.lections)
            row.append('<br>Lections: ' + doctor.lections);
        row.append('<br>Specialties: ');
        var specialties = doctor.specialties;
        for (var i = 0; i < specialties.length; i++) {
            row.append('<a onclick="getBySpecialty(\'' + specialties[i].name + '\')">' + specialties[i].name + '</a>');
            if (i < specialties.length - 1) row.append(', ');
        }
        row.append('<br>Certificate: ');
        if (doctor.certificate)
            row.append(doctor.certificate.name);
        row.append('<br>Qualifications: ');
        var qualifications = doctor.qualifications;
        for (var i = 0; i < qualifications.length; i++) {
            row.append('<a onclick="getByQualification(\'' + qualifications[i].name + '\')">' + qualifications[i].name + '</a>');
            if (i < qualifications.length - 1) row.append(', ');
        }
        if (doctor.comments)
            row.append('<br>Comments: ' + doctor.comments);
        row.appendTo(table);
    }
}
var form = $('#detailsForm');
function editRow(id) {
    $.get("rest/doctors/" + id, function (doctor) {
        $.each(doctor, function (key, val) {
            form.find("input[name='" + key + "']").val(val);
        });
        $('#editRow').modal();
    })
}
form.submit(function () {
    $.post("rest/doctors", form.serialize(), function () {
        $('#editRow').modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
function editSpecialties(id) {
    $.get("rest/doctors/specs", function (specs) {
        console.log(specs);
        $.each(specs, function (key, val) {
            $('#specList').append($('<li class="ui-widget-content">').text(val.name));
        });
        $('#editSpecs').modal();
    })
}