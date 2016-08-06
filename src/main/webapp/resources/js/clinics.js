/**
 * Created by DDNS on 06.08.2016.
 */
var editClinicForm = $("#editClinic");
function renderClinics(data, type, doctor) {
    var clinics = doctor.clinics;
    if (type == 'display') {
        var result = '';
        for (var i = 0; i < clinics.length; i++) {
            result += i + 1 + '. ' + ((clinics[i].name != '') ? '<strong>' + clinics[i].name : '</strong>') + '<br>';
            result += '<strong>City: </strong>' + '<a onclick="getByCity(\'' + clinics[i].city + '\')">' + clinics[i].city + '</a><br>';
            result += '<strong>Address: </strong>' + clinics[i].address + '<br>';
            result += '<a class="btn btn-xs btn-primary" onclick="editClinic(' + clinics[i].id + ',\'' + doctor.fullName + '\');">Edit</a> ';
            result += '<a class="btn btn-xs btn-success" onclick="showSlots(' + clinics[i].id + ');">Schedule</a> ';
            result += '<a class="btn btn-xs btn-danger" onclick="deleteClinic(' + clinics[i].id + ');">Delete</a>';
            if (i < clinics.length) result += '<br><br>';
        }
        if (clinics.length <= 2) result += '<a class="btn btn-sm btn-default" onclick="addClinic(' + doctor.id + ');">Add clinic</a>';
        return result;
    }
    if (type == 'filter') {
        var s = '';
        for (var i = 0; i < clinics.length; i++) {
            s += clinics[i].city + " ";
        }
        console.log(s);
        return s;
    }
    return "";
}
function editClinic(id, doctorName) {
    $.get("rest/clinics/" + id, function (clinic) {
        $.each(clinic, function (key, val) {
            editClinicForm.find("[name='" + key + "']").val(val)
        });
        $(".title", editClinicForm).text("Edit clinic for doctor " + doctorName);
        $('#editClinic').modal({backdrop: 'static'});
    })
}
editClinicForm.submit(function () {
    $.post("rest/clinics",editClinicForm.serialize(),function () {
        $('#editClinic').modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});