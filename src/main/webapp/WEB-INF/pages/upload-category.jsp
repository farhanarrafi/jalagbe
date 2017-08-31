<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>

    <style>
        .error {
            color:#FB3A3A;
            font-weight:bold;
        }
    </style>
	<script>
		$(".reset").click(function() {
			document.getElementById("categoryForm").reset();
		});

//        $(document).ready(function () {
//            $("#btnSubmit").click(function (event) {
//                event.preventDefault();
//               if(confirm("Are you sure")){
//                    fire_ajax_submit();
//               }
//            });
//        });

        $("#categoryForm").submit(function(event) {
            event.preventDefault();
        }).validate({
            rules: {
                categoryName: "required",
                files:"required"

            },
            messages: {
                categoryName: "Please enter a unique category name",
                files:"Please add an image for this category"
            },
            submitHandler: function(form) {
                if(confirm("Are you sure")){
                    fire_ajax_submit();
                }
            }
        });

        function fire_ajax_submit() {
            var data = new FormData($("#categoryForm")[0]);

            $.ajax({
                type: "POST",
                enctype: 'multipart/from-data',
                url: "/category/save",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    //alert(data)
                    console.log("SUCCESS : ", data);
                    if(confirm(data + "\n\nDo you wan't to upload another one?")){
                        $('#main-body-admin').load('/category/add');
                    } else {
                        document.getElementById("categoryForm").reset(); // temporary
                        //call dashboard
                    }
                },
                error: function (e) {
                    alert(e.responseText);
                    //$("#result").text(e.responseText);
                    console.log("ERROR : ", e);
                }
            });
        }
	</script>

	<div class="container-fluid">
        <div class="panel-heading">
            <div class="panel-title text-center">
                <h3 class="title">Add a new Category</h3>
                <hr />
            </div>
        </div>
        <div class="main-form main-center">
            <form class="form-horizontal" id="categoryForm" method="post" enctype="multipart/form-data">

                <div class="form-group">
                    <label for="categoryName" class="cols-sm-2 control-label">Category Name</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" name="categoryName" id="categoryName"  placeholder="Enter an unique Category"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="parentId" class="cols-sm-2 control-label">Parent Category</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                            <select class="form-control" name="parentId" id="parentId">
                                <option value="notSelected">Select a parent category</option>
                                <c:forEach var="category" items="${categoryList}">
                                    <option value="${category.id}">${category.categoryName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="imageFile" class="cols-sm-2 control-label">Category Image</label>
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                            <input  class="form-control" type="file" name="file" id="imageFile" multiple>
                        </div>
                    </div>
                </div>

                <div class="form-group ">
                    <button id="btnSubmit" type="submit" name="submit" class="btn btn-primary btn-lg btn-block submit-button">Submit</button>
                </div>

                <div class="form-group ">
                    <button  id="reset" name="reset" type="reset" class="btn btn-lg btn-block reset-button">Reset</button>
                </div>
            </form>
        </div>
	</div>
</body>
