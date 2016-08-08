/**
 * Created by DDNS on 02.08.2016.
 */
var table;
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: "rest/doctors",
            dataSrc: ""
        },
        dom: "lrtip",
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
                "width": "20%",
                "defaultContent": "",
                "render": renderClinics
            }
            /*{
             "defaultContent": "",
             "render": renderCreateAppointment
             },*/
            /*{
             "defaultContent": "",
             "render": {}
             },
             {
             "defaultContent": "",
             "render": {}
             }*/
        ],
        ordering: false,
        initComplete: updateTable
    });

});
$("#namesearch").on('keyup', function () {
    table.columns(0).search(this.value).draw();
});
$("#professions").on('change', function () {
    getBySpecialty(this.value);
});
$("#qualifications").on('change', function () {
    getByQualification(this.value);
});
$("#cities").on('change', function () {
    table.columns(2).search(this.value == 'All' ? "" : this.value).draw();
    // getByCity(this.value);
});
function getBySpecialty(name) {
    $.get("rest/doctors/by/?specialty=" + name, updateTableByData);
}
function getByQualification(name) {
    $.get("rest/doctors/by/?qualification=" + name, updateTableByData);
}
function getByCity(name) {
    $.get("rest/doctors/by/?city=" + name, updateTableByData);
}
function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}
function updateTable() {
    $.get("rest/doctors/certs", function (certs) {
        $.each(certs, function (key, val) {
            $("#certificates").append($('<option>').text(val.name));
        })
    });
    $.get("rest/doctors/specs", function (specs) {
        $.each(specs, function (key, val) {
            $(".professions").append($('<option>').text(val.name));
        })
    });
    $.get("rest/doctors/quals", function (quals) {
        $.each(quals, function (key, val) {
            $(".qualifications").append($('<option>').text(val.name));
        });
        $("#quals").multiselect({
            allSelectedText: false
        });
    });
    $.get("rest/clinics/cities", function (cities) {
        $.each(cities, function (key, val) {
            $("#cities").append($('<option>').text(val));
        })
    });
    $.get("rest/doctors/targets", function (targets) {
        $.each(targets, function (key, val) {
            $("#target").append($('<option>').text(val.name))
        });
        $("#target").multiselect({
            allSelectedText: false
        });
    });
    $.get("rest/doctors", updateTableByData)
}
