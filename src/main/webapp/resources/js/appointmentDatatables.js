var table;
$(function () {
    table = $('#dataTableA').DataTable({
        ajax: {
            url: "rest/appointments/all/" + $('#patientId').val(),
            dataSrc: ""
        },
        dom: "lrtip",
        paging: false,
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
            renderPatientInfo();
        }
    });
});

function updateTable() {
    $.get("rest/appointments/all/" + $('#patientId').val(), function (data) {
        table.clear().rows.add(data).draw();
    });
}

