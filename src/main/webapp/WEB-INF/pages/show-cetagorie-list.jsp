
<script>
	function submitData(){
			
		var file_data = $('#imageFile').prop('files')[0];   
		var formData = new FormData();                  
		formData.append('imageFile', file_data);
		
		var other_data = $('from').serializeArray();
		$.each(other_data,function(key,input){
			formData.append(input.name,input.value);
		});
		
		formData.append("tracker","insertCetagorie");
		
		$.ajax({
			type:"post",
			url:"cetagorie-service.php",
			data: formData,
			cache:false,
			contentType: false,
			processData: false,
			success: function(msg){
				alert(msg);
			}
		});
		return false;
	}
	
	$(".cetagorie-edit a").click(function() {
		var id = $(this).attr("value");
		var url = 'edit-cetagorie.php?id='+id;
		if(window.confirm("Are you sure?"))
			$("#main-body-admin").load(url);
		
		return true;
	});

    $("#deleteCetagori").click(function() {
        var id = $(this).attr("value");
        var url = 'edit-cetagorie.php?id='+id;
        if(window.confirm("Are you sure?"))
            $("#main-body-admin").load(url);
        return false;
    });
	
	$(".cetagorie-delete a").click(function() {
		var id = $(this).attr("value");
		var formData = new FormData();  
		formData.append("cetagorieId",id);
		formData.append("tracker","deleteCetagorie");
		//var url = 'edit-product.php?id='+id;
		 if(window.confirm("Are you sure?")) {
			$.ajax({
				type:"post",
				url:"cetagorie-service.php",
				data: formData,
				cache:false,
				contentType: false,
				processData: false,
				success: function(msg){
					if(window.confirm(msg)) {
						$("#main-body-admin").load("show-cetagorie-list.php");
					}	
				}
			});
		 }	
		return false;
	});

</script>


<div class="table-content" id="cetagorie-data"> 
	<table class="table table-inverse">
	  <thead>
		<tr>
		  <th>#</th>
		  <th>Name</th>
		  <th>Image</th>
		  <th>Gender</th>
		  <th>Description</th>
		  <th>Action</th>
		</tr>
	  </thead>
	  
	  <tbody>
		<?php foreach ($cetagorieList as $row) {	?>
			<tr>
				<th scope="row"></th>
				<td></td>
                <td></td>
				<td><img src="" height="50" width="50" alt="" ></td>
				<td></td>
				<td></td>
				<td>
					<div class="admin-action">
						<div class="cetagorie-edit">
							<a href="#main-body-admin" id="editCetagorie"  value="" >EDIT</a>
						</div>
						<div class="cetagorie-delete">
							<a href="#" id="deleteCetagorie" value="" >DELETE</a>
						</div>
					</div>				
				</td>
			</tr>
		<?php }?>
	  </tbody>
	</table>
</div>