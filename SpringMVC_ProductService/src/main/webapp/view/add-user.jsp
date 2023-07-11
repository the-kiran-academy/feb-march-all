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

	<form action="add-user" method="post">

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
							<h3 class="register-heading">ADD USER</h3>
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="USER NAME *" name="userName" required="required" value="" />
									</div>
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="Last Name *" name="lastName" required="required" value="" />
									</div>
									<div class="form-group">
										<input type="password" class="form-control"
											placeholder="Password *" name="password" required="required" value="" />
									</div>

									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <input type="radio"
												name="gender" required="required" value="male"> <span> Male </span>
											</label> <label class="radio inline"> <input type="radio"
												name="gender" value="female"> <span>Female </span>
											</label>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input type="email" class="form-control"
											placeholder="Your Email *" name="mail" required="required" value="" />
									</div>
									<div class="form-group">
										<input type="text" min="10" max="10" name="phone" required="required"
											class="form-control" placeholder="Your Phone *" value="" />
									</div>
									<div class="form-group">
										<select class="form-control" name="question" required="required">
											<option class="hidden" selected disabled>Please
												select your Sequrity Question</option>
											<option>What is your Birth Year?</option>
											<option>What is Your old Phone Number</option>
											<option>What is your Pet Name?</option>
										</select>
									</div>
									<div class="form-group">
										<input type="text" class="form-control"
											placeholder="Enter Your Answer *" name="answer" required="required" value="" />
									</div>
									<input type="submit" class="btnRegister" value="Register" />
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