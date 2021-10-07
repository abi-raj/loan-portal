<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="models.PlanType,operations.PlansDoa,java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Apply Loan</title>

<style>
body {
	margin: 0;
}

.main {
	display: flex;
	justify-content: center;
}

.container {
	display: inline-block;
	padding: 50px;
	margin: 5px;
	border-radius: 8px;
	box-shadow: 5px 10px 18px #888888;
}

.form-control label {
	display: block;
	margin-top: 5px;
}

.form-control input, .form-control textarea, .form-control select {
	margin-top: 10px;
	padding: 10px;
	border: 1px solid grey;
}

.form-control input[type="button"] {
	border: 0;
	color: white;
	background-color: blue;
	border-radius: 5px;
	cursor: pointer;
}
</style>
</head>

<body>
	<%
	ArrayList<PlanType> plans = PlansDoa.getAllPlans();
	%>
	<div class="main">
		<div class="container">
			<form action="ApplyLoan" method="post" id="form">

				<h1>Application Form</h1>
				<hr>
				<div class="form-control">
					<label for="plan">Plan Name</label> <select name="plan" id="plan">
						<%
						for (PlanType plan : plans) {
						%>
						<option value="<%=plan.getPlan_id()%>"><%=plan.getName()%></option>
						<%
						}
						%>
					</select>
				</div>
				<div class="form-control">
					<label for="loan">Loan Type</label> <select name="loan" id="loan">
						<option value="Education">Education Loan</option>
						<option value="Home">Home Loan</option>
						<option value="Bike">Bike Loan</option>
					</select>
				</div>
				<div class="form-control">
					<label for="pan">PAN</label> <input type="text" name="pan" id="pan"
						placeholder="PAN Number" />
				</div>
				<div class="form-control">
					<label for="amount">Amount</label> <input type="text" name="amount"
						id="amount" placeholder="Enter Amount" />
				</div>
				<div class="form-control">
					<label for="remarks">Remarks</label>
					<textarea type="text" name="remarks" id="remarks"
						placeholder="Your Reason"></textarea>

				</div>
				<div class="form-control">
					<input type="submit" value="Submit">
				</div>
			</form>


		</div>
	</div>

</body>

</html>