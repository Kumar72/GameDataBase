<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Vendor Dashboard</title>
</head>
<body>

	<form action="GetInventoryList.do" method="GET">
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
	<c:forEach items="${invlist}" var="inventory">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-4" id="gameinfo">
							<strong>Name:</strong> ${inventory.game.name}<br> 
							<strong>Description:</strong> ${inventory.game.description}<br> 
							<strong>Genre:</strong> ${inventory.game.genre}<br> 
							<strong>MSRP:</strong> ${inventory.price}<br> 
							<strong>Rating:</strong> ${inventory.game.rating}<br> 
							<strong>Vendor Name:</strong> ${inventory.vendorId}<br> 
							<strong>Status:</strong>${inventory.sold}<br>
							<strong>Quantity:</strong>${inventory.quantity}<br>
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
						<div class="form-group">
							<label class="control-label col-sm-2">Change Price:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="msrp" value="${game.msrp}">
								</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" value="Edit Price" class="btn btn-default">Submit Change</button>
							</div>
						</div>
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
