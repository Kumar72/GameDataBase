<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Vendor Dashboard</title>
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
		<div class="row dashboardheader">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="text-center">
					<h2>Vendor List of Games</h2>
				</div>
			</div>
			<div class="col-sm-2"></div>

		</div>
			<c:forEach items="${invlist}" var="inventory">
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8" id="gameinfo">
							<strong>Name:</strong> ${inventory.game.name}<br> 
							<strong>Description:</strong> ${inventory.game.description}<br> 
							<strong>Genre:</strong> ${inventory.game.genre}<br> 
							<strong>MSRP:</strong> ${inventory.game.msrp}<br> 
							<strong>Rating:</strong> ${inventory.game.rating}<br> 
							<strong>Vendor Name:</strong> ${inventory.vendorId}<br> 
							<strong>Status:</strong>${inventory.sold}<br>
							<strong>Quantity:</strong>${inventory.quantity}<br>
							<strong>MSRP:</strong> ${inventory.game.msrp}<br> 
							<strong>Vendor price:</strong> ${inventory.price}<br> 
					</div>
					<div class="col-sm-2"></div>
				</div>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-8">
						<form action="ChangePrice.do" method="POST">
	                        <div class="form-group">
	                            <label class="control-label col-sm-4">Change Vendor Price:</label>
	                                <div class="col-sm-6">
	                                    <input type="hidden" class="form-control" name="id"
	                                    value="${inventory.id}">
	                                    <input type="text" class="form-control" name="price"
	                                    value="${inventory.price}">
	                                </div>
	                            <button type="submit" value="Edit Vendor Price" class="btn btn-primary">Submit Changes</button>
	                        </div>
	                    </form>
					</div>
					<div class="col-sm-2"></div>
				</div>
			</c:forEach>
	</div>
</body>
</html>
