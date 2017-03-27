<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Developer Dashboard</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="dashboard.css">
</head>
<body>
			
	<div class="container-fluid">
		<div class="row developerlist">
			<div class="col-sm-3"></div>

			<div class="col-sm-1 text-center vertical-align">
				<form action="index.html">
					<button type="submit" class="btn btn-default">Home</button>
				</form>
			</div>
			<div class="col-sm-4 text-center">
				<h2>Game List</h2>
			</div>
			<div class="col-sm-1 text-center vertical-align">
				<form action="addform.do" method="POST">
					<button type="submit" class="btn btn-default">Add a Game</button>
				</form>
			</div>
			<div class="col-sm-3"></div>
		</div>
			<c:forEach items="${gamelist}" var="game">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-4" id="gameinfo">
							<strong>Title:</strong> ${game.name}<br> 
							<strong>Description:</strong> ${game.description}<br> 
							<strong>Genre:</strong> ${game.genre}<br> 
							<strong>MSRP: </strong> ${game.msrp}<br> <br>
							<strong>Rating:</strong> ${game.rating}<br>
							<strong>Status:</strong><!-- placeholder for sold status --><br> <br>
					</div>
					<div class="col-sm-2 text-center">
						<!-- placeholder for game photo -->
						<%-- <div id="gamepic">
							<img class="resize img-responsive center-block" src="${game.picURL}"/>
						</div> --%>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<div class="row text-center">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<form action="editform.do" method="POST">
							<button type="submit" name="id" value="${game.id}"
							class="btn btn-primary">Edit Game</button>
						</form>
					</div>
					<div class="col-sm-2">
						<form action="DeleteGame.do" method="POST">
							<button type="submit" name="id" value="${game.id}"								
							class="btn btn-danger">Delete Game</button>
						</form>
					</div>
					<div class="col-sm-4"></div>
				</div>
			</c:forEach>
	</div>

</body>
</html>