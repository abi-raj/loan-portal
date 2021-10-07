<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,operations.AppDoa,models.ApplicationModel"  %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Home</title>

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
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 10px;
            cursor: pointer;
            margin-top: 75px;
            margin-right:20px;


        }

        .card div h1 {
            text-align: center;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .container {

            text-align: center;

        }

        .apply-loan {
            float: right;
            margin: 5px 50px 10px;
        }

        .apply-loan button {
            border: 0;
            padding: 8px;
            color: white;
            background-color: green;
            cursor: pointer;
            border-radius: 5px;
        }
        .tag{
            margin-top: 5px;
        }
    </style>


</head>

<body>
<% ArrayList<ApplicationModel> apps = AppDoa.getApplicationByUser(1); %>
    <div class="heading">
        <h1>
            Welcome, Name
        </h1>

    </div>

    <div class="apply-loan">
        <button onclick="location.href='applyLoan.jsp'">Apply a Loan</button>
    </div>
    <div class="tag"><h1>Applied Loans</h1></div>
    <div class="components">





       
<%for(ApplicationModel app:apps){ %>
       
        <div class="card" >
            <div>
                <h1 style="color:green"><%=app.getStatus() %></h1>
            </div>
            <div class="container">
                <p>
                    <%=app.getLoan_type() %>
                </p>
                <p>Rs.<%=app.getAmount() %></p>
                <p><%=app.getPan() %></p>
            </div>
        </div>
        
<% } %>


    </div>

</body>

</html>