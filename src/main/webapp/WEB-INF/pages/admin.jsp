<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		<meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>

		<link rel='stylesheet' type='text/css' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'/>

		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"/>

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

		<script type="text/javascript"
				src="<c:url value='/resources/js/bootstrap-imageupload.js'/>"></script>

        <script type="text/javascript"
                src="<c:url value='/resources/js/jalagbe.js'/>"></script>

		<link href="<c:url value='/resources/css/admin.css'/>"
			  rel="stylesheet">
		<link href="<c:url value='/resources/css/bootstrap-imageupload.css'/>"
			  rel="stylesheet">

		<script>
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

		</script>

	</head>
	<body>
		<div class="row">
			<div class="col-xs-3">
				<div class="sidebar">
					<ul class="sidebar-nav">
						<li class="sidebar-brand">
							<a href="#">
								Dtex fasion Ltd
							</a>
						</li>
						<li>
							<a href="#">Dashboard</a>
						</li>
						<li>
							<h5>CETAGORIE</h5>
							<ul class="sidebar-sub-ul">
								<li>
									<a href ="#" onclick="load_category_list()">
										Show Cetagorie list
									</a>
								</li>
								<li >
									<a href ="#" onclick="load_upload_category()">
										Upload categorie
									</a>	
								</li>
							</ul>
						</li>
						<li>
							<h5>PRODUCT</h5>
							<ul class="sidebar-sub-ul">
								<li>
									<a href="#" onclick="load_product_list()">
										Show product list
									</a>
								</li>
								<li id="load">
									<a href ="#" onclick="load_upload_product()">
										Upload product
									</a>
								</li>
							</ul>
						</li>
						
						<li>
							<h5>STORIES</h5>
							<ul class="sidebar-sub-ul">
								<li>
									<a href="#" onclick="load_story_list()">
										Show story list
									</a>
								</li>
								<li>
									<a href ="#" onclick="load_upload_story()">
										Upload story
									</a>
								</li>
							</ul>
						</li>
						
						<li>
							<h5>EMPLOYEE</h5>
							<ul class="sidebar-sub-ul">
								<li>
									<a href="#">
										Show employee list
									</a>
								</li>
								<li>
									<a href ="#" onclick="load_upload_story()">
										Add a new employee
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="col-xs-9">
				<div id="main-body-admin">					
					
				</div>
			</div>
		</div>
	</body>
</html>