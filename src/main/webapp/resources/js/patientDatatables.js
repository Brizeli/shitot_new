
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
                data:"name"
            },
            {
                "width": "10%","defaultContent": "",
                data: "age"
            },
            {
                "width": "20%",
                "defaultContent": "",
                data: "telNumber"
            },
            {
                "width": "30%",
             "defaultContent": "",
             "render": renderButton
             }
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
$("#telsearch").on('keyup', function () {
    table.columns(2).search(this.value).draw();
});
function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}
function updateTable() {
    $.get("rest/patients/", updateTableByData)
}
