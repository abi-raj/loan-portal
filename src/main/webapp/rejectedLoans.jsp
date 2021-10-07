<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
    <div>

        <div class="loans">
            <h2>Rejected Loans</h2>
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
                    <tr>
                        <td>1</td>
                        <td>
                            <p><b>Name : </b>12</p>
                            <p><b>Phone : </b>10</p>
                            <p><b>Email : </b>10</p>
                        </td>
                        <td>
                            <div>
                                <p><b>Duration : </b>12</p>
                                <p><b>Interest : </b>10</p>
                                <p><b>Penalty : </b>10</p>
                            </div>
                        </td>
                        <td>Rejected</td>
                        <td>
                            <button class="approve">Approve</button>
                            <button class="pending">Move to Pending</button>

                        </td>
                    </tr>



                </tbody>
            </table>
        </div>
    </div>
</body>

</html>