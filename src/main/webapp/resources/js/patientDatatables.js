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
                data: 'age',
                searching: false
            },
            {
                data: 'telNumber'
            },
            {
                defaultContent: '',
                render: function (data, type, row) {
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
    result += '<a class="btn btn-xs btn-primary" onclick="editPatient(' + patient.id + ');">'+i18n['app.buttons.edit']+'</a> ';
    result += '<a class="btn btn-xs btn-danger" onclick="deletePatient(' + patient.id + ');">'+i18n['app.buttons.delete']+'</a> ';
    result += '<a class="btn btn-xs btn-success" href="appointments?id=' + patient.id + '">'+i18n['app.buttons.appointments']+'</a>';
    return result;
}
function addPatient() {
    $(':input', editForm).val('');
    $('.title', editPatientWindow).text(i18n['patient.addnew']);
    $('#id').val(null);
    $('#editPatient').modal({backdrop: 'static'});
}
function editPatient(id) {
    $.get(patientsRestUrl + '/' + id, function (patient) {
        $.each(patient, function (key, val) {
            editForm.find('[name=\'' + key + '\']').val(val);
        });
        $('.title', editPatientWindow).text(i18n['patient.edit']);
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
    if (confirm('Are you sure?'))
        $.ajax({
            url: patientsRestUrl + '/' + patientId,
            type: 'DELETE',
            success: function () {
                updateTable();
                successNoty('Deleted');
            }
        });
}
