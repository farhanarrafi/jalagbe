
<body>
	<script>
		var $imageupload = $('.imageupload');
		$imageupload.imageupload();


		$(".reset").click(function() {
			document.getElementById("contact").reset();
		});

		function submitData(){

            var data = {}
            data["categoryName"] = $("#categoryName").val();
            data["parentId"] = $("#domain").val();
            data["imageUrl"] = $("#imageUrl").val();

            $("#btn-save").prop("disabled", true);

            $.ajax({
                type: "POST",
                contentType: "application/json",
                url: "/category/add",
                data: JSON.stringify(data),
                dataType: 'json',
                cache: false,
                timeout: 600000,
                success: function (msg) {
                    var json = "<h4>Ajax Response</h4><pre>"
                        + JSON.stringify(msg, null, 4) + "</pre>";
                    $('#feedback').html(json);

                    console.log("SUCCESS : ", msg);
                    $("#btn-search").prop("disabled", false);

                },
                error: function (e) {

                    var json = "<h4>Ajax Response</h4><pre>"
                        + e.responseText + "</pre>";
                    $('#feedback').html(json);

                    console.log("ERROR : ", e);
                    $("#btn-search").prop("disabled", false);

                }
            });

			return false;
		}
	</script>

	<div class="container">
		<p id="feedback"></p>
	    <form id="contact" method="post">
			<h3>Upload a new cetagorie</h3>
			<fieldset>
				<input class="form-control" placeholder="Cetagorie name" name="cetagorieName" type="text" required>
			</fieldset>
			<fieldset>
				<label >Select gender</label>
				  <select class="form-control" name="gender" required>
					<option value="Male">Male</option>
					<option value="Female">Female</option>
				  </select>
			</fieldset>
			<div class="imageupload panel panel-default">
				<div class="panel-heading clearfix">
					<h6 class="panel-title pull-left">Upload Image</h6>
				</div>
				<div class="file-tab panel-body">
					<label class="btn btn-default btn-file">
						<span>Browse</span>
						<!-- The file is stored here. -->
						<input type="file" name="imageFile" id="imageFile">
					</label>
					<button type="button" class="btn btn-default">Remove</button>
				</div>
			</div>
			<fieldset>
				<button name="submit" type="submit" id="submit" data-submit="...Sending" onclick="return submitData()">Submit</button>
			</fieldset>
			<fieldset>
				<button name="submit" type="reset" id="reset" >Reset</button>
			</fieldset>
			<p class="copyright">Designed by <a href="https://whiteconsole.com" target="_blank" title="WhiteConsole">WhiteConsole</a></p>
		</form>
	</div>
</body>
