<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="AddGame.do" method="POST">
		<fieldset>
			<legend>Create A New Game</legend>
		Add name: <input type="text" name="name" /><br> 
		Description: <textarea name="description" row="7" cols="50"></textarea><br>
		Add genre: <input type="text" name="genre" /><br> 
		Add MSRP: <input type="number" name="msrp" min="0.00"  max="99.99" step="10.00"/><br> 
		Add rating: <select name="rating"> 
			<option value="C">1. Early Childhood</option>
			<option value="E">2. Everyone</option>
			<option value="T">4. Teen</option>
			<option value="M">5. Mature 17+</option>
			<option value="A">5. Adults only 18+</option>
		</select><br>
		<button type="submit" value="Add Film" class="btn btn-default">Submit
			new game</button>
		</fieldset>
	</form>

</body>
</html>