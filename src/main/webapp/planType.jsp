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
<title>Loan Plans</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.body {
	box-sizing: border-box;
	margin: 0;
}

.row {
	display: flex;
	flex-direction: row;
	justify-content: space-evenly;
	width: 100%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	border-radius: 5px;
}

.form-control label {
	display: block;
	margin: 5px;
}

.form-control input {
	border: 2px solid #B0B0B0;
	border-radius: 4px;
	width: 70%;
	margin: 5px;
	border-radius: 5px;
	padding: 8px;
}

.add-plan button {
	padding: 10px;
	margin: 10px;
	border-radius: 4px;
	border: none;
	background-color: #1261A0;
	cursor: pointer;
	color: white;
}

.plans {
	/*  background-color: yellow; */
	width: 70%;
	padding: 20px;
	box-sizing: border-box;
	border-radius: 10px;
}

.add-plan {
	/* background-color: green;*/
	width: 30%;
	padding: 20px;
}

table, td, th {
	padding: 10px;
	border-collapse: collapse;
	border: 1px solid grey;
}

table {
	width: 100%;
}

.col-2 {
	width: 60%;
	font-weight: bold;
}

.col-3 {
	width: 20%;
	font-weight: bold;
}

.col-1 {
	width: 20%;
	font-weight: bold;
}

.edit, .delete {
	border: none;
	padding: 10px;
	color: white;
	border-radius: 5px;
	cursor: pointer;
	margin: 5px;
}

.edit {
	background-color: #1261A0;
}

.delete {
	background-color: red;
}
</style>
</head>

<body>

	<%
	ArrayList<PlanType> plans = PlansDoa.getAllPlans();
	%>
	<div class="row">

		<div class="plans">
			<h2>Plans</h2>
			<table>
				<thead>
					<tr>
						<td class="col-1">Name</td>
						<td class="col-2">Plan Details</td>
						<td class="col-3">Action</td>
					</tr>
				</thead>
				<tbody>
				
					<%
					for (PlanType plan:plans) {
					%>
					<tr>
						<td><%=plan.getName()%></td>
						<td>
							<div>
								<p>
									<b>Duration : </b><%=plan.getDuration() %>
								</p>
								<p>
									<b>Interest : </b><%=plan.getRate() %>
								</p>
								<p>
									<b>Penalty : </b><%=plan.getPenalty() %>
								</p>
							</div>
						</td>
						<td>
							<button class="edit">Edit</button>
							<button class="delete">Delete</button>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
		</div>

		<div class="add-plan">
			<h2>Add Plan</h2>
			<div class="form-control">
				<label for="planName">Plan Name (months) :</label> <input
					type="text" name="planName" id="planName" />
			</div>
			<div class="form-control">
				<label for="duration">Duration (months) :</label> <input
					type="number" name="duration" id="duration" />
			</div>
			<div class="form-control">
				<label for="interest">Interest rate :</label> <input type="number"
					name="interest" id="interest" />
			</div>
			<div class="form-control">
				<label for="penalty">Penalty rate :</label> <input type="number"
					name="penalty" id="penalty" />
			</div>
			<button onclick="savePlan()">Save Plan</button>
			<button onclick="clear()">Clear</button>
		</div>

	</div>


</body>

<script>
	function savePlan() {
		const planName = document.getElementById("planName");
		const duration = document.getElementById("duration");
		const interest = document.getElementById("interest");
		const penalty = document.getElementById("penalty");

		if (planName.value !== '' && duration.value !== ''
				&& interest.value !== '' && penalty !== '') {

			$.ajax({
				url : 'AddPlan',
				method : 'POST',
				data : {
					name : planName.value,
					duration : duration.value,
					interest : interest.value,
					penalty : penalty.value
				},
				success : function(data) {
					alert('Plan Added');
					location.reload();
				},
				error : function(xhr, status) {
					alert('Error Occurred');
				},
			});

		} else {
			alert("Fill all the values");
		}
	}

	function clear() {

	}
</script>

</html>