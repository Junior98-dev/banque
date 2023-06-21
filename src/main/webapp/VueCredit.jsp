<%@page import="web.CreditModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	CreditModel model =(CreditModel)request.getAttribute("creditModel");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crédit bancaire</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="CSS/style.css" />
</head>
<body>
	<p></p>
	<div class="container">
	<div class="row justify-content-center">
	<div class="col-sm-6">
		<div class="card">
			<div class="card bg-primary text-white">
  				<div class="card-header"><h2 class="text-center">Simulation de crédit</h2></div>
  			</div>
  			<div class="card-body">
  				<form action="calculeMensualite.do" method="post">
  					<div class="form-group">
  						<label class="control-label">Montant</label>
  						<input class="form-control" type="text" name="montant" value="<%= model.getMontant()%>">
  					</div>
  					<div class="form-group">
  						<label class="control-label">Taux</label>
  						<input class="form-control" type="text" name="taux" value="<%= model.getTaux()%>">
  					</div>
  					<div class="form-group">
  						<label class="control-label">Durée</label>
  						<input class="form-control" type="text" name="duree" value="<%= model.getDuree()%>">
  					</div><br>
  					<button type="submit" class="btn btn-danger">Calculer</button>		
  				</form>
  				
  				<div>
					Mensualité =<%=(model.getMensualite())%>
				</div>
  			</div>
		</div>
	</div>
	</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>