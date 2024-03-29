<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="models.CountModel,operations.AppDoa"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Admin</title>

<style>
body {
	margin: 0 auto;
}

.heading {
	display: flex;
	flex-direction: column;
	align-items: center;
	background-color: black;
	color: white;
}

.components {
	display: flex;
	flex-direction: row;
	justify-content: center;
}

.card {
	width: 200px;
	height: 50%;
	background-color: white;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	border-radius: 10px;
	cursor: pointer;
	margin: 30px 20px;
}

.card div h1 {
	text-align: center;
}
.card div img{
width:100%;
height:100px;
object-fit: cover;
}
.card:hover {
	transform: scale(1.05);
}

.container {
	text-align: center;
}
</style>


</head>

<body>
	<div class="heading">
		<h1>Welcome, Admin</h1>

	</div>
	<%
	CountModel count = AppDoa.getDashCounts();
	%>
	<div class="components">


		<div class="card" >
			<div>
				<h1><%=count.getTotal()%></h1>
			</div>
			<div class="container">
				<p>Total Loans</p>
			</div>
		</div>


		<div class="card"   onclick="location.href='approvedLoans.jsp'">
			<div>
				<h1 style="color: green"><%=count.getAccepted()%></h1>
			</div>
			<div class="container">
				<p>Approved Requests</p>
			</div>
		</div>

		<div class="card"   onclick="location.href='pendingLoans.jsp'">
			<div>
				<h1 style="color: pink"><%=count.getPending()%></h1>
			</div>
			<div class="container">
				<p>Pending Requests</p>
			</div>
		</div>

		<div class="card"   onclick="location.href='rejectedLoans.jsp'">
			<div>
				<h1 style="color: red"><%=count.getRejected()%></h1>
			</div>
			<div class="container">
				<p>Rejected Requests</p>
			</div>
		</div>
		<div class="card"  onclick="location.href='planType.jsp'">
			<div>
				<img src="https://media.wired.com/photos/5a0a38c1d07f6824ff44221b/master/w_2560%2Cc_limit/twitterlists-TA.jpg"/>
			</div>
			<div class="container">
				<p>Loan Types</p>
			</div>
		</div>
	</div>

</body>

</html>