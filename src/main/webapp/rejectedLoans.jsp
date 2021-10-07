<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList,operations.AppDoa,models.LoanModel"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rejected Loans</title>

    <style>
        body {
            margin: 0;

        }

        .loans {
           
            width: 100%;
            padding: 10px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 5px;
        }

        .approve {
            border: 0;
            padding: 8px;
            border-radius: 5px;
            color: white;
            background-color: green;
            cursor: pointer;
            margin:3px;
        }
        .pending {
            border: 0;
            padding: 8px;
            border-radius: 5px;
            color: black;
            background-color: yellow;
            cursor: pointer;
            margin:3px;
        }

        table,
        th,
        td {
            border-collapse: collapse;
            border: 1px solid grey;
            padding: 10px;

        }

        table {
            margin-left: 50px;

            width: 80%;
        }
        thead tr{
            font-weight: bold;
        }
    </style>
</head>


<body>
   <%
	ArrayList<LoanModel> loans = AppDoa.getApplicationsByStatus("rejected");
	%>
	<div>

		<div class="loans">
			<h2>Approved Loans</h2>
			<table>
				<thead>
					<tr>
						<td class="col-1">S.No</td>
						<td class="col-2">Memeber details</td>
						<td class="col-3">Plan Details</td>
						<td class="col-4">Status</td>
						<td class="col-5">Action</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (LoanModel loan : loans) {
					%>

					<tr>
						<td>1</td>
						<td>
							<p>
								<b>Name : </b><%=loan.getU_name()%></p>
							<p>
								<b>Phone : </b><%=loan.getU_phone()%></p>
							<p>
								<b>Email : </b><%=loan.getU_name()%></p>
						</td>
						<td>
							<div>
								<p>
									<b>Name : </b><%=loan.getP_name()%></p>
								<p>
									<b>Duration : </b><%=loan.getP_dur()%></p>
								<p>
									<b>Interest : </b><%=loan.getP_rate()%></p>

							</div>
						</td>
						<td><%=loan.getStatus()%></td>
                        <td>
                            <button class="approve">Approve</button>
                            <button class="pending">Move to Pending</button>

                        </td>
                    </tr>

<%} %>

                </tbody>
            </table>
        </div>
    </div>
</body>

</html>