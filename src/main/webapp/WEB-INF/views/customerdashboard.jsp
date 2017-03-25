<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Dashboard</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="">
</head>
<body>

<form action="getGame.do" method="GET">
		<input type="text" name="name"> <input type=submit
			value="Get Game Information By Keyword">
	</form>
	<c:if test="${! empty game}">
		Name: <strong>${game.name}</strong><br>
		Description: <strong>${game.description}</strong><br>
		Genre: <strong>${game.genre}</strong><br>
		MSRP: <strong>${game.msrp}</strong><br>
		Rating: <strong>${game.rating}</strong>
		<br>
	</c:if>
	<hr>
	<c:forEach items="${gamelist}" var="game">
	<h1>hello</h1>
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-4" id="gameinfo">
							<strong>Title:</strong> ${game.name}<br> 
							<strong>Description:</strong> ${game.description}<br> 
							<strong>Genre:</strong> ${game.genre}<br> 
							<strong>MSRP:</strong>${game.msrp}<br> <br>
							<strong>Rating:</strong>${game.rating}<br>
							<strong>Status:</strong><!-- placeholder for sold status --><br> <br>
					</div>
					<div class="col-sm-2 text-center">
					<!-- placeholder for game photo -->
						<%-- <div id="beerpic">
							<img class="resize img-responsive center-block" src="${beer.picURL}"/>
						</div> --%>
					</div>
					<div class="col-sm-3"></div>
				</div>
				<div class="row text-center">
					<div class="col-sm-4"></div>
					<div class="col-sm-2">
						<form action="BuyGame.do" method="POST">
							<button type="submit" name="id" value="${inventory}"								
							class="btn btn-primary">Buy Game</button>
						</form>
					</div>
					<div class="col-sm-2">
						<%-- <form action="DeleteBeer.do" method="POST">
							<button type="submit" name="name" value="${beer.name}"								
							class="btn btn-danger">Delete Beer</button>
						</form> --%>
					</div>
					<div class="col-sm-4"></div>
				</div>
			</c:forEach>

</body>
</html>