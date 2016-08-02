/**
 * Created by DDNS on 02.08.2016.
 */
$(function () {
    $('#dataTable').DataTable({
        ajax: {
            url: "rest/doctors",
            dataSrc: ""
        },
        paging: false,
        // scrollY: 400,
        columns: [
            {
                "defaultContent": "",
                "render": renderDoctorInfo
            },
            {
                "defaultContent": "",
                "render": renderSpecialization
            },
            {
                "defaultContent": "",
                "render": renderClinics
            },
            {
                "defaultContent": "",
                "render": renderCreateAppointment
            },
            {
                "defaultContent": "",
                "render": {}
            },
            {
                "defaultContent": "",
                "render": {}
            }
        ],
        ordering: false
    });
});
function renderSpecialization(data, type, doctor) {
    return "";
}
function renderClinics(data, type, doctor) {
    return "";
}
function renderCreateAppointment(data, type, doctor) {
    return "";
}
function renderDoctorInfo(data, type, doctor) {
    debugger;
    console.log(data);
    console.log(type);
    console.log(doctor);
    if (type == 'display') {
        return '<h2><a onclick="editRow(' + doctor.id + ')" title="Edit">' + doctor.fullName + '</a></h2>' +
        '<a href="mailto:' + doctor.email + '">' + doctor.email + '</a><br>' +
        'Tel: ' + doctor.telNumber + '<br>' +
        (doctor.telHome) ? 'Home tel: ' + doctor.telHome + '<br>' : '' +
        (doctor.homeAddress) ? 'Home address: ' + doctor.homeAddress + '<br>' : '';
    }
    return "";
}
function editRow(id) {
    $.get("rest/doctors/" + id, function (doctor) {
        $.each(doctor, function (key, val) {
            form.find("input[name='" + key + "']").val(val);
        });
        $('#editRow').modal();
    })
}
var form = $('#detailsForm');
function update(id) {
    $.get("rest/doctors/" + id, function (data) {
        $.each(data, function (key, value) {
            form.find("[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    })
}