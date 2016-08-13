/**
 * Created by Next on 02.08.2016.
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
                "width": "25%",
                "defaultContent": "",
                "render": renderClinics
            }
        ],
        ordering: false,
        initComplete: initTable
    });
});
$("#namesearch").on('keyup', function () {
    table.columns(0).search(this.value).draw();
});
$("#professions, #qualifications").on('change', function () {
    table.columns(1).search(this.value == 'All' ? '' : this.value).draw();
});
$("#cities").on('change', function () {
    table.columns(2).search(this.value == 'All' ? '' : this.value).draw();
});
$('#clearsearch').click(function () {
    $('select', $('.searchrow')).val('All').trigger('change');
    $('#namesearch').val('').trigger('keyup');
});
function fillSearch() {
    $("#cetificates, .professions, .qualifications, #cities, #target")
        .empty();
    $(".professions, .qualifications, #cities", $('.searchrow'))
        .append($('<option>').text('All'));
    $("#cetificates, .professions", editDoctorForm)
        .append($('<option>'));
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
    $.get("rest/doctors/targets", function (targets) {
        $.each(targets, function (key, val) {
            $("#target").append($('<option>').text(val.name))
        });
        $("#target").multiselect({
            allSelectedText: false
        });
    });
    $.get("rest/clinics/cities", function (cities) {
        $.each(cities, function (key, val) {
            $("#cities").append($('<option>').text(val));
        })
    });
}
function initTable() {
    fillSearch();
    $('[data-slots]').each(function () {
        $(this).popover({
            title: 'Open hours',
            trigger: 'focus',
            content: function () {
                var slots = $(this).data('slots');
                var res = '<table>';
                for (var i = 0; i < daysOfWeek.length; i++) {
                    res += '<tr><td>' + daysOfWeek[i] + ': </td><td>';
                    $.each(slots, function (ind, slot) {
                        if (slot.dayOfWeek == i) res += slot.intervals;
                    });
                    res += '</td></tr>';
                }
                res += '</table>';
                return res;
            },
            placement: 'left',
            html: true
        });
    });
}
function updateTable() {
    $.get("rest/doctors", function (data) {
        table.clear().rows.add(data).draw();
    });
    fillSearch();
}
