
var table;
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: "rest/patients/",
            dataSrc: ""
        },
        dom: "lrtip",
        paging: false,
        // scrollY: 400,
        columns: [
            {
                "defaultContent": "",
                "render": renderAppointmentInfo
            },
            {
                "width": "10%","defaultContent": "",
                "render": renderAppointmentProblems
            },
            {
                "width": "20%",
                "defaultContent": "",
                "render": renderAppointmentDoctors
            },
            //{
            //    "width": "30%",
            // "defaultContent": "",
            // "render": renderButton
            // }
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
//$("#namesearch").on('keyup', function () {
//    table.columns(0).search(this.value).draw();
//});
//$("#telsearch").on('keyup', function () {
//    table.columns(2).search(this.value).draw();
//});
function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}
function updateTable() {
    //$.get("rest/doctors/certs", function (certs) {
    //    $.each(certs, function (key, val) {
    //        $("#certificates").append($('<option>').text(val.name));
    //    })
    //});
    //$.get("rest/doctors/specs", function (specs) {
    //    $.each(specs, function (key, val) {
    //        $(".professions").append($('<option>').text(val.name));
    //    })
    //});
    //$.get("rest/doctors/quals", function (quals) {
    //    $.each(quals, function (key, val) {
    //        $(".qualifications").append($('<option>').text(val.name));
    //    });
    //    $("#quals").multiselect({
    //        allSelectedText: false
    //    });
    //});
    //$.get("rest/clinics/cities", function (cities) {
    //    $.each(cities, function (key, val) {
    //        $("#cities").append($('<option>').text(val));
    //    })
    //});
    //$.get("rest/doctors/targets", function (targets) {
    //    $.each(targets, function (key, val) {
    //        $("#target").append($('<option>').text(val.name))
    //    });
    //    $("#target").multiselect({
    //        allSelectedText: false
    //    });
    //});
    //$.get("rest/doctors", updateTableByData)
}
