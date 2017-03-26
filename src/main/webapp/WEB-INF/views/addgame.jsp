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
		Add name: <input type="text" name="name" /><br> 
		Add description: <input type="text" name="description" /><br> 
		Add genre: <input type="text" name="genre" /><br> 
		Add MSRP: <input type="text" name="msrp" /><br> 
		Add rating: <select name="rating"> 
			<option value="C">1. Early Childhood</option>
			<option value="E">2. Everyone</option>
			<option value="T">4. Teen</option>
			<option value="M">5. Mature 17+</option>
			<option value="A">5. Adults only 18+</option>
		</select><br>
		<button type="submit" value="Add Film" class="btn btn-default">Submit
			new game</button>
	</form>

</body>
</html>