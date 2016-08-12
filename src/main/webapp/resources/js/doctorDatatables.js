/**
 * Created by DDNS on 02.08.2016.
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
$("#professions").on('change', function () {
    table.columns(1).search(this.value == 'All' ? '' : this.value).draw();
    // getBySpecialty(this.value);
});
$("#qualifications").on('change', function () {
    table.columns(1).search(this.value == 'All' ? '' : this.value).draw();
    // getByQualification(this.value);
});
$("#cities").on('change', function () {
    table.columns(2).search(this.value == 'All' ? '' : this.value).draw();
    // getByCity(this.value);
});
$('a[data-slots]').hover(function () {
    console.log($(this));
});
// function getBySpecialty(name) {
//     $.get("rest/doctors/by/?specialty=" + name, updateTableByData);
// }
// function getByQualification(name) {
//     $.get("rest/doctors/by/?qualification=" + name, updateTableByData);
// }
// function getByCity(name) {
//     $.get("rest/doctors/by/?city=" + name, updateTableByData);
// }
function initTable() {
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
    $('[data-slots]').each(function () {
        $(this).popover({
            title: 'Open hours',
            trigger: 'focus',
            content: function () {
                var slots = $(this).data('slots');
                var res = '<table>';
                $.each(slots, function (ind, slot) {
                    res += '<tr><td>' + daysOfWeek[slot.dayOfWeek] + ': </td><td>' + slot.intervals + '</td></tr>';
                });
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
}
