<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Login</title>
<style>
body {
	font-size: 1.2rem;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	margin: 0;
}

.container {
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
	width: 400px;
}

h2 {
	text-align: center;
	margin: 0 0 20px;
}

.form-control {
	margin-bottom: 10px;
	padding-bottom: 10px;
}

.form-control label {
	display: block;
	margin-bottom: 5px;
}

.form-control input {
	border: 2px solid #f0f0f0;
	border-radius: 4px;
	display: block;
	width: 100%;
	padding: 10px;
	font-size: 14px;
}

.form-control input[type="submit"] {
	margin-top: 15px;
}

.form-control input[type="submit"]:hover {
	background-color: blue;
	cursor: pointer;
	color: white;
}
</style>
</head>

<body>
	<div>
		<form action="home.html" method="post" id="form">
			<h2>Customer Login</h2>
			<div class="form-control">
				<label for="email">Email : </label> <input type="email" id="email"
					name="email" />
			</div>
			<div class="form-control">
				<label for="password"> Password : </label><input type="password"
					id="password" name="password" />
				<div class="form-control">
					<input type="submit" onclick="return val()" value="Submit">
				</div>
		</form>
	</div>
</body>
<script>
	function val() {

		const email = document.getElementById("email");
		const password = document.getElementById("password");
		console.log(email.value, password.value);
		if (email.value === "admin@gmail.com" && password.value === "admin") {
			return true;
		}
		return false;
	}
</script>
</html>