
var table;
$(function () {
    table = $('#dataTableA').DataTable({
        ajax: {
            url: "rest/appointments/all/"+$('#patientId').val(),
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
        initComplete: function () {
            
        }
    });
});

function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}
function updateTable() {
    $.get("rest/appointments/all/"+$('#patientId').val(), updateTableByData)
}

