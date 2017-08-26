
<body>
	<script>
		var $imageupload = $('.imageupload');
		$imageupload.imageupload();
	

		$(".reset").click(function() {			
			document.getElementById("contact").reset(); 
		});
		
		function submitData(){
			
			var file_data = $('#imageFile').prop('files')[0];   
			var formData = new FormData();                  
			formData.append('imageFile', file_data);
			
			var other_data = $('form').serializeArray();
			$.each(other_data,function(key,input){
				formData.append(input.name,input.value);
			});			
			
			var isValidData = true;
			for (var key in formData) {
				if(formData[key] == null || formData[key] == ""){
					isValidData = false;
					break;
				}
			}
			
			formData.append("tracker","insertProduct");

			if(isValidData) {
				$.ajax({
					type:"post",
					url:"Product-service.php",
					data: formData,
					cache:false,
					contentType: false,
					processData: false,
					success: function(){
						alert("inserted");
					}
				});
			} else {
				alert('input fields must not be empty!');
			}
			return false;
		}
	</script>

	<div class="container">  
		<p id="body"></p>
	    <form id="contact" method="post">
			<h3>Upload new product</h3>
			<fieldset>
				<?php 
					require("cetagorie-service.php");
					$cetagorieService = new CetagorieService();
					$cetagories = $cetagorieService->getCetagorieList("uploadProduct");
				?>
				<label >Select Cetagorie</label>
				<select class="form-control" name="cetagorieId" required>
					<?php 
						foreach ($cetagories as $row) {	?>	
							<option value="<?php echo $row['ID'];?>"><?php echo $row['NAME'];?></option>
					<?php } ?>	
				</select>				
			</fieldset>
			<fieldset>
				<input class="form-control" placeholder="Product name" name="productName" type="text" required>
			</fieldset>
			<fieldset>
				<input class="form-control" placeholder="Product status" name="productCode" type="text" required>
			</fieldset>
			<fieldset>
				<input class="form-control" placeholder="Quantity" name="quantity" type="text" required>
			</fieldset>
			<fieldset>
				<input class="form-control" placeholder="Size" name="size" type="text" required>
			</fieldset>
			<fieldset>
				<input class="form-control" placeholder="Colour" name="colour" type="text" required>
			</fieldset>
			<fieldset>
				<input class="form-control" placeholder="Status" name="status" type="text" required>
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
