<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="/css/adduser.css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body style="background-image: linear-gradient(red, yellow)">

<jsp:include page="menu.jsp" />
	<form action="add-product" method="post">

		<div class="container register">
			<div class="row">
				<div class="col-md-3 register-left">
					<img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
					<h3>Welcome</h3>
					<p>You are 30 seconds away from earning your own money!</p>
					
				</div>
				<div class="col-md-9 register-right">

					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<h3 class="register-heading">ADD PRODUCT</h3>
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="PRODUCT NAME *" name="productName" value="" required="required"/>
									</div>
									<div class="form-group">
										<input type="number" min="1" class="form-control"
											placeholder="PRODUCT PRICE *" name="productPrice" value="" required="required"/>
									</div>
									<div class="form-group">
										<input type="number" min="1" class="form-control"
											placeholder="PRODUCT QTY *" name="productQTY" value="" required="required"/>
									</div>

								</div>
								<div class="col-md-6">
									
									<div class="form-group">
										<input type="number" min="1" name="categoryId"
											class="form-control" placeholder="CATEGORY ID *" value=""  required="required"/>
									</div>
									
									<div class="form-group">
										<input type="number" min="1" name="supplierId"
											class="form-control" placeholder="SUPPLIER ID *" value="" required="required"/>
									</div>
									
									<input type="submit" class="btnRegister" value="ADD PRODUCT" />
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</form>
	<jsp:include page="footer.jsp" />
	
</body>
</html>