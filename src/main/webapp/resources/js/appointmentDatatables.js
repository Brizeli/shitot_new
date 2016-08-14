
var table;
$(function () {
    table = $('#dataTableA').DataTable({
        ajax: {
            url: "rest/patients/appointment/"+$('#patientId').val(),
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
                "defaultContent": "",
                "render": renderAppointmentProblems
            },
            {
                "defaultContent": "",
                "render": renderAppointmentDoctors
            }
        ],
        ordering: false,
        initComplete: updateTable
    });
});

function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}
function updateTable() {
    $.get("rest/patients/appointment/"+$('#patientId').val(), updateTableByData)
}

