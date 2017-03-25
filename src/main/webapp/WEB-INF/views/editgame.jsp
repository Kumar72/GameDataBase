<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Game</title>
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

<div class="container">
		<div class="text-center">
			<h2>Edit Game</h2>
		</div>
		<form class="form-horizontal" action="EditGame.do" method="POST" name="bs"> <!-- name? -->
		<input type="hidden" name="id" value="${game.id}">
			<div class="form-group">
				<label class="control-label col-sm-2">Edit title:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name"
						value="${game.name}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Edit description:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="description"
						value="${game.description}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Edit genre:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="genre"
						value="${game.genre}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Edit MSRP:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="msrp"
						value="${game.msrp}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Edit rating</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="abv"
						value="${currentBeer.abv}">
				</div>
			</div>
			<div>
			Add rating: <select name="rating">
						    <option value="C">1. Early Childhood</option>
						    <option value="E">2. Everyone</option>
						    <option value="T">3. Teen</option>
						    <option value="M">4. Mature</option>
						    <option value="A">5. Adult</option>
			  			</select><br>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" value="Edit Game" class="btn btn-default">Submit Changes</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>