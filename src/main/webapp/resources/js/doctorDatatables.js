/**
 * Created by DDNS on 02.08.2016.
 */
var table;
var editDoctorForm = $('#detailsForm');
$(function () {
    table = $('#dataTable').DataTable({
        ajax: {
            url: "rest/doctors",
            dataSrc: ""
        },
        dom: "lrtip",
        paging: false,
        // scrollY: 400,
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
                "defaultContent": "",
                "render": renderClinics
            },
            /*{
             "defaultContent": "",
             "render": renderCreateAppointment
             },*/
            {
                "defaultContent": "",
                "render": {}
            },
            {
                "defaultContent": "",
                "render": {}
            }
        ],
        ordering: false
    });
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
    $.get("rest/doctors/cities", function (cities) {
        $.each(cities, function (key, val) {
            $("#cities").append($('<option>').text(val));
        })
    });
    $.get("rest/doctors/targets", function (targets) {
        $.each(targets, function (key, val) {
            $("#target").append($('<option>').text(val.name))
        });
        $("#target").multiselect({
            allSelectedText: false
        });
    });
});
$("#namesearch").on('keyup', function () {
    table.columns(0).search(this.value).draw();
});
$("#professions").on('change', function () {
    getBySpecialty(this.value);
});
$("#qualifications").on('change', function () {
    getByQualification(this.value);
});
function getBySpecialty(name) {
    $.get("rest/doctors/by/?specialty=" + name, updateTableByData);
}
function getByQualification(name) {
    $.get("rest/doctors/by/?qualification=" + name, updateTableByData);
}
function updateTableByData(data) {
    table.clear().rows.add(data).draw();
}
function renderDoctorInfo(data, type, doctor) {
    if (type == 'display') {
        var result = '<h2><a onclick="editRow(' + doctor.id + ')" title="Edit">' + doctor.fullName + '</a></h2>' +
            '<a href="mailto:' + doctor.email + '">' + doctor.email + '</a><br>' +
            'Tel: ' + doctor.telNumber + '<br>';
        if (doctor.telHome) result += 'Home tel: ' + doctor.telHome + '<br>';
        if (doctor.homeAddress) result += 'Home address: ' + doctor.homeAddress;
        return result;
    }
    if (type == 'filter') {
        return doctor.fullName;
    }
    return "";
}
function renderSpecialization(data, type, doctor) {
    if (type == 'display') {
        var result = '<strong>Certificate: </strong>';
        if (doctor.certificate) result += doctor.certificate.name;
        result += '<br><strong>Profession: </strong>';
        var specialties = doctor.specialties;
        for (var i = 0; i < specialties.length; i++) {
            result += '<a onclick="getBySpecialty(\'' + specialties[i].name + '\')">' + specialties[i].name + '</a>';
            if (i < specialties.length - 1) result += ', ';
        }
        result += '<br><strong>Qualifications: </strong>';
        var qualifications = doctor.qualifications;
        for (i = 0; i < qualifications.length; i++) {
            result += '<a onclick="getByQualification(\'' + qualifications[i].name + '\')">' + qualifications[i].name + '</a>';
            if (i < qualifications.length - 1) result += ', ';
        }
        if (doctor.preferential) result += '<br><strong>Prefers: </strong>' + doctor.preferential;
        if (doctor.lections) result += '<br><strong>Reads lections: </strong>' + doctor.lections;
        result += '<br><strong>Target audience: </strong>';
        var target = doctor.targetAudiences;
        for (i = 0; i < target.length; i++) {
            result += target[i].name;
            if (i < target.length - 1) result += ', ';
        }
        if (doctor.comments) result += '<br><strong>Comments: </strong>' + doctor.comments;
        return result;
    }
    return "";
}
function renderClinics(data, type, doctor) {
    return "";
}
function renderCreateAppointment(data, type, doctor) {
    return "";
}
function add() {
    editDoctorForm.find(":text").val("");
    editDoctorForm.find("option").removeAttr("selected");
    $(".title").text("Add new doctor");
    $('#id').val(null);
    $('#editRow').modal({backdrop: 'static'});
}
function editRow(id) {
    $.get("rest/doctors/" + id, function (doctor) {
        editDoctorForm.find("option").removeAttr("selected");
        $.each(doctor, function (key, val) {
            if (key == 'specialties') {
                editDoctorForm.find("[name='specialty1']").val(val[0] ? val[0].name : '');
                editDoctorForm.find("[name='specialty2']").val(val[1] ? val[1].name : '');
            }
            if (key == 'targetAudiences') {
                $('option', $('#target')).removeAttr('selected').prop('selected', false);
                $.each(val, function (k, v) {
                    $("option:contains(" + v.name + ")", $("#target")).prop("selected", true);
                });
                $('#target').multiselect('refresh');
            }
            if (key == 'certificate') {
                editDoctorForm.find("[name='" + key + "']").val(val.name);
            }
            else editDoctorForm.find("[name='" + key + "']").val(val);
        });
        $(".title").text("Edit doctor");
        $('#editRow').modal({backdrop: 'static'});
    })
}
editDoctorForm.submit(function () {
    $.post("rest/doctors", editDoctorForm.serialize(), function () {
        $('#editRow').modal('hide');
        updateTable();
        successNoty('Saved');
    });
    return false;
});
function updateTable() {
    $.get("rest/doctors", updateTableByData)
}
