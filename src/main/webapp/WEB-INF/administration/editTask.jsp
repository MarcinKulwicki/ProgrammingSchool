<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Administration</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:import url="../fragments/header.jsp"/>
<c:import url="../fragments/headerAdmin.jsp"/>
<form method="get">
    <h1></h1>
    <h4>Search Task</h4>
    <input type="number" name="id" placeholder="id task">
    <h1></h1>
    <button type="submit" class="btn btn-info">Search</button>
</form>

<form method="post">
    <h1></h1>
    <h4>Edit Task</h4>
    <div class="form-row">
        <div class="form-group">
            <input type="number" placeholder="id" class="form-control" value="${task.id}" name="id">
        </div>
        <div class="form-group">
            <input type="text" placeholder="User id" class="form-control" value="${task.userId}" name="userId">
        </div>
        <div class="form-group">
            <input type="text" placeholder="Task id" class="form-control" value="${task.taskId}" name="taskId">
        </div>
        <div class="form-group">
            <input type="text" placeholder="Task name" class="form-control" value="${task.taskName}" name="taskName">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group">
            <input type="text" placeholder="Task answer" class="form-control" value="${task.taskAnswer}" name="taskAnswer">
        </div>
    </div>
    <h1></h1>
    <button type="submit" class="btn btn-info">Edit</button>
</form>


<c:import url="../fragments/footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>
