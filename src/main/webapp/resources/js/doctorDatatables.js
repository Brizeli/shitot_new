/**
 * Created by Next on 02.08.2016.
 */
var table;
var lng = $('html').attr('lang');
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: 'rest/doctors',
            dataSrc: ''
        },
        dom: 'lrtip',
        paging: false,
        columnDefs: [
            {width: '20%', targets: [0, 2]}
        ],
        columns: [
            {
                defaultContent: '',
                render: renderDoctorInfo
            },
            {
                defaultContent: '',
                render: renderSpecialization
            },
            {
                defaultContent: '',
                render: renderClinics
            }
        ],
        ordering: false,
        initComplete: initTable
    });
    $('#namesearch').keyup(function () {
        table.columns(0).search(this.value).draw();
    });
    $('#professions, #qualifications').change(function () {
        table.columns(1).search(this.value == 'All' ? '' : this.value).draw();
    });
    $('#cities').change(function () {
        table.columns(2).search(this.value == 'All' ? '' : this.value).draw();
    });
    $('#clearsearch').click(function () {
        $('select', $('.searchrow')).val('All').trigger('change');
        $('#namesearch').val('').trigger('keyup');
    });
});
function fillSearch() {
    $('#certificates, .professions, .qualifications, #cities, #target').empty();
    $('.professions, .qualifications, #cities', $('.searchrow'))
        .append($('<option>').text('All'));
    $('#certificates, .professions', editForm)
        .append($('<option>'));
    $.get(doctorsRestUrl + '/certs', function (certs) {
        $.each(certs, function (key, val) {
            $('#certificates').append($('<option>').text(val.name));
        });
    });
    $.get(doctorsRestUrl + '/specs', function (specs) {
        $.each(specs, function (key, val) {
            $('.professions').append($('<option>').text(val.name));
        });
    });
    $.get(doctorsRestUrl + '/quals', function (quals) {
        $.each(quals, function (key, val) {
            $('.qualifications').append($('<option>').text(val.name));
        });
        $('#quals').multiselect({maxHeight: 300});
    });
    $.get(doctorsRestUrl + '/targets', function (targets) {
        $.each(targets, function (key, val) {
            $('#target').append($('<option>').text(val.name))
        });
        $('#target').multiselect({maxHeight: 300});
    });
    $.get(clinicsRestUrl + '/cities', function (cities) {
        $.each(cities, function (key, val) {
            $('#cities').append($('<option>').text(val));
        });
    });
}
function initPopovers() {
    $('[data-slots]').popover({
        title: lng == 'en' ? 'Open hours' : 'שעות קבלה',
        trigger: 'focus',
        content: function () {
            var daysOfWeek = {
                'en': ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
                'iw': ['ראשון', 'שני', 'שלישי', 'רביעי', 'חמישי', 'שישי', 'שבת']
            };
            var slots = $(this).data('slots');
            var res = '<table>';
            for (var i = 0; i < daysOfWeek[lng].length; i++) {
                res += '<tr><td>' + daysOfWeek[lng][i] + ': </td><td>';
                var intervals = 'Not set';
                $.each(slots, function (ind, slot) {
                    if (slot.dayOfWeek == i) {
                        var intls = slot.intervals.trim();
                        if (intls != '') intervals = intls;
                    }
                });
                res += intervals + '</td></tr>';
            }
            res += '</table>';
            return res;
        },
        placement: lng == 'en' ? 'left' : 'right',
        html: true
    });
    $('[data-toggle="popover"]').popover({
        trigger: 'focus',
        content: function () {
            var s = atob($(this).data('file'));
            // console.log(s);
            return '<img src="' + s + '" width="500px">';
        },
        html: true,
        container: 'body'
    });
    $('#file').change(function () {
        var reader = new FileReader();
        reader.onload = function () {
            $('[name="file"]').val(this.result);
        };
        reader.readAsDataURL(this.files[0]);
    });
    $('.addSpec').popover({
        html: true,
        trigger: 'manual',
        placement: 'bottom',
        content: function () {
            return $('#addspec').html();
        }
    }).click(function () {
        $(this).popover('toggle');
        $('.editForm').on('keyup keypress', function (e) {
            if (e.keyCode == 13) {
                e.preventDefault();
                return false;
            }
        });
        $('input', $('#addSpecForm')).on('keyup', function (e) {
            if (e.keyCode == 13) addSpec(this);
        });
        $('a', $('#addSpecForm')).click(function () {
            addSpec(this)
        });
        function addSpec(el) {
            var value = $('input', $('#addSpecForm')).val();
            if (value.trim() != '') {
                $(el).parentsUntil('.form-group').parent().find('select').first().append($('<option selected>').text(value));
                $('[multiple]').multiselect('rebuild');
                $('.addSpec').popover('hide');
            }
        }
    });
}
function initTable() {
    fillSearch();
    initPopovers();
    $('.nav').find('.active').removeClass('active');
    $('.nav a[href="doctors"]').parent().addClass('active');
}
function updateTable() {
    $.get(doctorsRestUrl, function (data) {
        table.clear().rows.add(data).draw();
        initPopovers();
        fillSearch();
    });
}
