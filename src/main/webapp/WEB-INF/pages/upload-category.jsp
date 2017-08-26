
<body>
	<script>
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
                    //alert(data)
                    console.log("SUCCESS : ", data);
                    if(confirm("Do you wan't to upload another category?")){
                        $('#main-body-admin').load('/category/add');
                    } else {
                        document.getElementById("contact").reset(); // temporary
                        //call dashboard
                    }

                },
                error: function (e) {
                    alert(e);
                    //$("#result").text(e.responseText);
                    console.log("ERROR : ", e);

                }
            });
        }
	</script>

	<div class="container">
	    <form id="contact" method="post" enctype="multipart/form-data">
			<h3>Upload a new cetagorie</h3>
			<fieldset>
				<input class="form-control" placeholder="Cetagorie name" name="categoryName" type="text" required>
			</fieldset>
			<%--<fieldset>--%>
				<%--<label >Select gender</label>--%>
				  <%--<select class="form-control" name="gender" required>--%>
					<%--<option value="Male">Male</option>--%>
					<%--<option value="Female">Female</option>--%>
				  <%--</select>--%>
			<%--</fieldset>--%>
			<%--<div class="imageupload panel panel-default">--%>
				<%--<div class="panel-heading clearfix">--%>
					<%--<h6 class="panel-title pull-left">Upload Image</h6>--%>
				<%--</div>--%>
				<%--<div class="file-tab panel-body">--%>
					<%--<label class="btn btn-default btn-file">--%>
						<%--<span>Browse</span>--%>
						<%--<input type="file" name="files">--%>
					<%--</label>--%>
					<%--<button type="button" class="btn btn-default">Remove</button>--%>
				<%--</div>--%>
			<%--</div>--%>
			<fieldset>
				<input type="file" name="files" multiple>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="btnSubmit" data-submit="...Sending" >Submit</button>
			</fieldset>
			<fieldset>
				<button name="submit" type="reset" id="reset" >Reset</button>
			</fieldset>
			<p class="copyright">Designed by <a href="https://whiteconsole.com" target="_blank" title="WhiteConsole">WhiteConsole</a></p>
		</form>
	</div>
</body>
