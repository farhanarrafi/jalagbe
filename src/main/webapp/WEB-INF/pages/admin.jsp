<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"> </meta>
		<meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel='stylesheet' type='text/css' href='//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="crossorigin="anonymous"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
		<%--<link href="../static-resources/css/admin.css" rel="stylesheet">--%>
		<%--<link href="../static-resources/css/bootstrap-imageupload.css" rel="stylesheet">--%>
		
		<%--<script src="../static-resources/js/bootstrap-imageupload.js"></script>--%>

        <link href="<c:url value='/resources/css/admin.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/bootstrap-imageupload.css'/>" rel="stylesheet">

        <script src="<c:url value='/resources/js/bootstrap-imageupload.js'/>"></script>
		<style>
			
			
		</style>
		
		<script type="text/javascript">
            function load_cetagorie_list() {
                $('#main-body-admin').load('');
            }

            function load_upload_cetagorie() {
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
									<a href="#"href ="#" onclick="load_cetagorie_list()">
										Show Cetagorie list
									</a>
								</li>
								<li>
									<a href ="#" onclick="load_upload_cetagorie()">
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
								<li>
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