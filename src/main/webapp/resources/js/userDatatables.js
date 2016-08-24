/**
 * Created by Next on 23.08.2016.
 */
var usersRestUrl = 'rest/users';
var editForm = $('.editForm');
var editUserWindow = $('#regUserWindow');
var table;
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: usersRestUrl,
            dataSrc: ''
        },
        paging: false,
        columns: [
            {
                data: 'login'
            },
            {
                data: 'enabled',
                render: function (data, type, row) {
                    return type == 'display' ? '<input type="checkbox" ' + (data ? 'checked' : '') + ' onclick="enable($(this),' + row.id + ');"/>' : data;
                }
            },
            {
                defaultContent: '',
                render: function (data, type, row) {
                    return type == 'display' ? renderAppointments(row) : '';
                }
            },
            {
                defaultContent: '',
                render: function (data, type, row) {
                    return type == 'display' ? renderButtons(row) : '';
                }
            }
        ],
        createdRow: function (row, data, dataIndex) {
            if (!data.enabled) {
                $(row).css("text-decoration", "line-through");
            }
        },
        ordering: false,
        initComplete: function () {
            $('.nav').find('.active').removeClass('active');
            $('.nav a[href="users"]').parent().addClass('active');
        }
    })
    ;
});
function updateTable() {
    $.get(usersRestUrl, function (data) {
        table.clear().rows.add(data).draw()
    });
}
function renderAppointments(user) {
    // return '<a class="btn btn-xs btn-success" href="appointments?id=' + user.id + '">Appointments</a>';
    return '<a class="btn btn-xs btn-success">Appointments</a>';
}
function renderButtons(user) {
    var result = '';
    // result += '<a class="btn btn-xs btn-primary" onclick="editUser(' + user.id + ');">Edit</a> ';
    result += '<a class="btn btn-xs btn-danger" onclick="deleteUser(' + user.id + ');">Delete</a> ';
    return result;
}
function addUser() {
    editUserWindow.modal({backdrop: 'static'});
}
function enable(chkbox, id) {
    var enabled = chkbox.is(":checked");
    chkbox.closest('tr').css("text-decoration", enabled ? "none" : "line-through");
    $.ajax({
        url: usersRestUrl + '/' + id,
        type: 'POST',
        data: 'enabled=' + enabled,
        success: function () {
            successNoty(enabled ? 'Enabled' : 'Disabled');
        }
    });
}
// function editUser(id) {
//     $.get(usersRestUrl + '/' + id, function (user) {
//         $.each(user, function (key, val) {
//             editForm.find('[name=\'' + key + '\']').val(val);
//         });
//         $('.title', regUserWindow).text('Edit user');
//         editUserWindow.modal({backdrop: 'static'});
//     })
// }
editForm.submit(function () {
    $.post(usersRestUrl, editForm.serialize(), function () {
        editUserWindow.modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
function deleteUser(id) {
    if (confirm("Are you sure?"))
        $.ajax({
            url: usersRestUrl + '/' + id,
            type: 'DELETE',
            success: function () {
                updateTable();
                successNoty('Deleted');
            }
        });
}
