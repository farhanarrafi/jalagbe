
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
			
			formData.append("tracker","insertStory");
			
			$.ajax({
				type:"post",
				url:"Story-service.php",
				data: formData,
				cache:false,
				contentType: false,
				processData: false,
				success: function(html){
					$('#body').html(html);
				}
			});
			return false;
		}
		
		
		$(document).ready(function(){
			var date_input=$('input[name="date"]'); //our date input has the name "date"
			var container=$('.container form').length>0 ? $('.container form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
			})
		})
	</script>

	<div class="container">  
		<p id="body"></p>
	    <form id="contact" method="post">
			<h3>Upload a new story</h3>
			<fieldset>
				<input class="form-control" placeholder="Story title" name="storyTitle" type="text" required>
			</fieldset>
			<fieldset>
				<label class="control-label" for="date">Date</label>
				<input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
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
				<textarea class="form-control" placeholder="Main content" name="description" tabindex="5" required></textarea>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="submit" data-submit="...Sending" onclick="return submitData()">Submit</button>
			</fieldset>
			<fieldset>
				<button name="submit" type="reset" id="reset" >Reset</button>
			</fieldset>
			<p class="copyright">Designed by <a href="https://whiteconsole.com" target="_blank" title="WhiteConsole">WhiteConsole</a></p>
		</form>
	</div>

