<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Game Database</title>
</head>
<body>

	<form action="getGame.do" method="GET">
		<input type="text" name="name"> <input type=submit
			value="Get Game Information By Name">
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
	<form action="addGame.do" method="POST">
		Add name: <input type="text" name="name" /><br> 
		Add description: <input type="text" name="description" /><br> 
		Add genre: <input type="text" name="genre" /><br> 
		Add MSRP: <input type="text" name="MSRP" /><br> 
		Add rating: <select name="rating">
			<option value="C">1. Early Childhood</option>
			<option value="E">2. Everyone</option>
			<option value="T">4. Teen</option>
			<option value="M">5. Mature 17+</option>
			<option value="A">5. Adults only 18+</option>
		</select><br>
		<button type="submit" value="Add Film" class="btn btn-default">Submit new game</button>
	</form>
</body>
</html>
