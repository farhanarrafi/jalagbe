function load_category_list() {
    $('#main-body-admin').load('');
}

function load_upload_category() {
    $('#main-body-admin').load('/category/add');
}

function load_product_list() {
    $('#main-body-admin').load('/pages/temp.jsp');
}
function load_upload_product() {
    $('#main-body-admin').load('/product/add');
}

function load_story_list() {
    $('#main-body-admin').load('temp.jsp');
}
function load_upload_story() {
    $('#main-body-admin').load('upload-story.jsp');
}
function edit_cetagorie() {
    var id = $(this).attr("value");
    var url = //'edit-cetagorie.php?id='+id;
        $("#main-body-admin").load(url);
    return true;
}

$("#cetagorie-data a").click(function() {
    var id = $(this).attr("value");
    var url = //'products.php?id='+id;
        $("#main-body-admin").load(url);
    return false;
});


//upload add category

$(".reset").click(function() {
    document.getElementById("contact").reset();
});

$(document).ready(function () {
    $("#btnSubmit").click(function (event) {
        event.preventDefault();
        if(confirm("Are you sure")){
            fire_ajax_submit();
        }
    });
});

function fire_ajax_submit() {
    var data = new FormData($("#contact")[0]);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/category/save",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
            alert(data)
            $('#main-body-admin').load('/category/add');
            //$("#result").text(data);
            console.log("SUCCESS : ", data);

        },
        error: function (e) {
            alert(e);
            //$("#result").text(e.responseText);
            console.log("ERROR : ", e);

        }
    });
}