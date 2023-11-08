<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Escolher Destino - Mundo Alem</title>
    <link rel="stylesheet" type="text/css" href="../css/estilo.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<body>
<div class="bg-primary bg-gradient">
    
      <!--Conteúdo 1-->
      <div class="text-nav titulo">
        <h2>Escolha o seu destino</h2>
      </div>
      <div class="row p-3">
        <div class="form-container">
          <form action="/MundoAlem/requisitarViagem" method="post">
          	<div class="form-group">
              <label for="name">Destino:</label>
              
              <select id="destinosOp" name="destinosOp" onchange="atualizarValorTotal()">
          			<p:forEach items="${destOp}" var="dest">
          				<option value="${dest.idDestino}" name="opDest" data-valor="${dest.valorDestino}">${dest.nomeDestino}</option>
          			</p:forEach>
          	  </select>              
            </div>
            <div class="form-group">
              <label for="date">Data de Ida (insira no formato dd-mm-yyyy):</label>
              <input type="text" id="dateida" name="dataIda" required>
            </div>
            <div class="form-group">
              <label for="date">Data de Volta (insira no formato dd-mm-yyyy):</label>
              <input type="text" id="datevolta" name="dataVolta" required>
            </div>
          </form>
        </div>
      </div>
      <!--Rodapé-->
      
       <!--Conteúdo 2-->
      <div class="text-nav titulo">
        <h2>Forma de pagamento</h2>
      </div>
      <div class="row p-3">
        <div class="form-container">
          <form >
          	<div class="form-group">
          		<label for="formaPag">Escolha a forma de pagamento: </label>
          			<select id="formaPag" name="tipoPag">
          				<p:forEach items="${tiposPag}" var="tipo">
          					<option value="${tipo.idTipo}">${tipo.descricao}</option>
          				</p:forEach>
          			</select>
          	</div>
            <div class="form-group">
              <label for="valor">Valor Total:</label>
              <p:forEach items="${destEsc}" var="dEsc">
              	<input type="text" id="valorTotal" name="valor" required readonly>
              </p:forEach>
            </div>
            <script>
			function atualizarValorTotal() {
			    var selectDestinos = document.getElementById("destinosOp");
			    var selectedOption = selectDestinos.options[selectDestinos.selectedIndex];
			    var valorDestino = selectedOption.getAttribute("data-valor");
			
			    var inputValorTotal = document.getElementById("valorTotal");
			    inputValorTotal.value = valorDestino;
			}
			
			window.addEventListener("load", function() {
			    atualizarValorTotal();
			});
			</script>
            <div class="form-group">
			    <label for="valor">Parcelas:</label>
			    <select id="qtdParcelas" name="parcelas">
			        <script>
			            for (var i = 1; i <= 24; i++) {
			                var option = document.createElement("option");
			                option.value = i;
			                option.text = i;
			                document.getElementById("qtdParcelas").appendChild(option);
			            }
			        </script>
   			 	</select>
   			 	
			<div class="form-group">
			    <label for="valor">Valor Parcelado:</label>
			    <input type="text" id="valorParcelado" name="valorParcela" required readonly>
			</div>
			
			<script>
			    function atualizarValorParcelado() {
			        var quantidade = document.getElementById("qtdParcelas").value;
			        var valorTotal = document.getElementById("valorTotal").value; // Recupera o valor total da variável JSP
			        var valorParcelado = valorTotal / quantidade;
			
			        document.getElementById("valorParcelado").value = valorParcelado;
			    }
			
			    document.getElementById("qtdParcelas").addEventListener("change", atualizarValorParcelado);
			    atualizarValorParcelado();
			</script>

            <div class="form-group">
              <label for="name">Data (entre com o formato dd-mm-yyyy):</label>
              <input type="text" id="dataVenc" name="dataVenc" value="<%=java.time.LocalDate.now()%>" required readonly>
            </div>
            <button type="submit" id="salvarInfo" name="salvarInfo" class="btn btn-success" >Salvar Informações</button>
            
          </form>
        </div>
      </div>
      <!--Rodapé-->
      <div class="estilo-rodape text-nav">
       <footer>
          MundoAlém
          <div class="d-flex justify-content-center">
            <div class="col-md-1">
              <img src="../midia/facebook.jpg" width="30px" height="30px" title="logo do facebook">
            </div>
            <div class="col-md-1">
              <img src="../midia/linkedin.png" width="30px" height="30px" title="logo do LinkedIn">
            </div>
            <div class="col-md-1">
              <img src="../midia/instagram.jpg" width="30px" height="30px" title="logo do Instagram">
            </div>
          </div>
        </footer>

      </div>
    </div>
    <!--fim do rodapé-->
    </div>

</body>
</html>