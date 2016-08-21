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
            $.get(patientsRestUrl + "/" + $('#patientId').val(), function (patient) {
                $('#patient1').text(patient.name + ' (Age: ' + patient.age + ', Tel: ' + patient.telNumber + ')');
            });
            $('.datepicker').datepicker({
                format: 'dd/mm/yyyy',
                todayBtn: 'linked',
                clearBtn: true,
                // language: 'he',
                autoclose: true,
                todayHighlight: true
            });
            fillOptions();
        }
    });
});
function fillOptions() {
    $.get(appointmentsRestUrl + "/symptoms", function (symptoms) {
        $.each(symptoms, function (key, val) {
            $("#symptoms").append($('<option>').text(val.name));
        });
        $("#symptoms").multiselect({
            // allSelectedText: false
        });
    });
    $.get(appointmentsRestUrl + "/problems", function (problems) {
        $.each(problems, function (key, val) {
            $("#problems").append($('<option>').text(val.name));
        });
        $("#problems").multiselect({
            allSelectedText: false
        });
    });
}

function updateTable() {
    $.get("rest/appointments/all/" + $('#patientId').val(), function (data) {
        table.clear().rows.add(data).draw();
    });
    fillOptions();
}

