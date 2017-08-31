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
        document.getElementById("productForm").reset();
    });

    //        $(document).ready(function () {
    //            $("#btnSubmit").click(function (event) {
    //                event.preventDefault();
    //               if(confirm("Are you sure")){
    //                    fire_ajax_submit();
    //               }
    //            });
    //        });

    $("#productForm").submit(function(event) {
        event.preventDefault();
    }).validate({
        rules: {
            categoryId:"required",
            productName: {required: true,
                minlength:3,
                maxlength: 20},
            files:"required",
            originalPrice:{
                required: true,
                number: true,
                min: 1
            },
            quantity:{
                required: true,
                number: true,
                min: 1
            },
            feature:"required",
            availability:"required"
        },
        messages: {
            categoryId: "Please enter a category",
            productName:{required : "Please enter the name",
                alphabetsnspace: "Please Enter Only Letters",
                maxlength:"You can write maximum 20 characters"
            },
            originalPrice: {required : "Please enter the original price",
                number: "Please Enter Only Numbers",
                min:"Quantity must be garter than 0"
            },
            quantity:{required : "Please enter the quantity",
                number: "Please Enter Only Numbers",
                min:"Quantity must be garter than 0"
            },
            feature: "status is required",
            availability: "availability is required",
            files:"Please add at least one image for this product"
        },
        submitHandler: function(form) {
            if(confirm("Are you sure")){
                fire_ajax_submit();
            }
        }
    });

    function fire_ajax_submit() {
        var data = new FormData($("#productForm")[0]);

        $.ajax({
            type: "POST",
            enctype: 'multipart/from-data',
            url: "/product/save",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                //alert(data)
                console.log("SUCCESS : ", data);
                if(confirm(data + "\n\nDo you wan't to upload another one?")){
                    $('#main-body-admin').load('/product/add');
                } else {
                    document.getElementById("productForm").reset(); // temporary
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
			<h3 class="title">Add a new Product</h3>
			<hr />
		</div>
	</div>
	<div class="main-form main-center">
		<form class="form-horizontal" id="productForm" method="post" enctype="multipart/form-data">

			<div class="form-group">
				<label for="categoryId" class="cols-sm-2 control-label">Category</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
						<select class="form-control" name="categoryId" id="categoryId">
							<option value="">Select a category</option>
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.id}">${category.categoryName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="productName" class="cols-sm-2 control-label">Product Name</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
						<input type="text" class="form-control" name="productName" id="productName"  placeholder="Enter a product name"/>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="originalPrice" class="cols-sm-2 control-label">Original price</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon">*<i class="fa fa-user fa" aria-hidden="true"></i></span>
						<input type="text" class="form-control" name="originalPrice" id="originalPrice"  placeholder="Enter original price"/>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="discountPrice" class="cols-sm-2 control-label">Discount price</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
						<input type="text" class="form-control" name="discountPrice" id="discountPrice"  placeholder="Enter discount price"/>
					</div>
				</div>
			</div>

            <div class="form-group">
                <label for="description" class="cols-sm-2 control-label">Product description</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="textarea" class="form-control" name="description" id="description"  placeholder="Enter product description"/>
                    </div>
                </div>
            </div>

			<div class="form-group">
				<label for="quantity" class="cols-sm-2 control-label">Quantity</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
						<input type="text" class="form-control" name="quantity" id="quantity"  placeholder="Enter quantity"/>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="feature" class="cols-sm-2 control-label">Status</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
						<select class="form-control" name="feature" id="feature">
                            <option value="">Select feature</option>
                            <option value="new">New</option>
							<option value="discount">Discount</option>
						</select>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="availability" class="cols-sm-2 control-label">Availability</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
						<select class="form-control" name="availability" id="availability">
							<option value="">Select availability</option>
							<option value="0">Available</option>
							<option value="1">Not available</option>
						</select>
					</div>
				</div>
			</div>


			<div class="form-group">
				<label for="imageFile" class="cols-sm-2 control-label">Category Image</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
						<input  class="form-control" type="file" name="files" id="imageFile" multiple>
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
