<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">PMS</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="home-page">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="add-user-page">Add User</a></li>

			<li class="nav-item"><a class="nav-link" href="#">List Of
					User</a></li>

			<li class="nav-item"><a class="nav-link" href="add-product-page">Add
					Product</a></li>

			<li class="nav-item"><a class="nav-link" href="#">List Of
					Product</a></li>

			<li class="nav-item"><a class="nav-link" href="get-user-by-id?username=<%= session.getAttribute("username")%>"><%= session.getAttribute("username")%></a></li>


		</ul>
		
	</div>
</nav>