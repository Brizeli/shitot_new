var patientsRestUrl = 'rest/patients';
var editForm = $('.editForm');
var editPatientWindow = $('#editPatient');
var table;
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: patientsRestUrl,
            dataSrc: ''
        },
        dom: 'lrtip',
        paging: false,
        columns: [
            {
                data: 'name'
            },
            {
                // "width": "10%",
                data: 'age',
                searching: false
            },
            {
                // "width": "20%",
                data: 'telNumber'
            },
            {
                // "width": "30%",
                'defaultContent': '',
                'render': function (data, type, row) {
                    return renderButtons(row);
                }
            }
        ],
        ordering: false,
        initComplete: function () {
            $('.nav').find('.active').removeClass('active');
            $('.nav a[href="patients"]').parent().addClass('active');
        }
    });
    $('#namesearch').on('keyup', function () {
        table.columns(0).search(this.value).draw();
    });
    $('#telsearch').on('keyup', function () {
        table.columns(2).search(this.value).draw();
    });
});
function updateTable() {
    $.get(patientsRestUrl, function (data) {
        table.clear().rows.add(data).draw()
    });
}
function renderButtons(patient) {
    var result = '';
    result += '<a class="btn btn-xs btn-primary" onclick="editPatient(' + patient.id + ');">Edit</a> ';
    result += '<a class="btn btn-xs btn-danger" onclick="deletePatient(' + patient.id + ');">Delete</a> ';
    result += '<a class="btn btn-xs btn-success" href="appointments?id=' + patient.id + '">Appointments</a>';
    return result;
}
function addPatient() {
    $(':input', editForm).val('');
    $('.title', editPatientWindow).text('Add new patient');
    $('#id').val(null);
    $('#editPatient').modal({backdrop: 'static'});
}
function editPatient(id) {
    $.get(patientsRestUrl + '/' + id, function (patient) {
        $.each(patient, function (key, val) {
            editForm.find('[name=\'' + key + '\']').val(val);
        });
        $('.title', editPatientWindow).text('Edit patient');
        editPatientWindow.modal({backdrop: 'static'});
    })
}
editForm.submit(function () {
    $.post(patientsRestUrl, editForm.serialize(), function () {
        editPatientWindow.modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
function deletePatient(patientId) {
    $.ajax({
        url: patientsRestUrl + '/' + patientId,
        type: 'DELETE',
        success: function () {
            updateTable();
            successNoty('Deleted');
        }
    });
}
