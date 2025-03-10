<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CashTrack - Gestión de Ingresos y Gastos</title>
    <style>
        .resultados {
            margin-top: 20px;
            font-size: 16px;
        }
        .resultadoIngreso {
            color: green;
        }
        .resultadoGasto {
            color: red;
        }
        .saldoNegativo {
            color: red;
        }
        .saldoPositivo {
            color: green;
        }
    </style>
</head>
<body>
    <h1>Bienvenido a CashTrack</h1>
    
    <form action="CashTrackServlet" method="POST">
        <label for="valor">Ingrese el monto: </label>
        <input type="text" id="valor" name="valor" required>
        <br>
        <label for="tipo">Seleccione el tipo:</label>
        <select id="tipo" name="tipo">
            <option value="ingreso">Ingreso</option>
            <option value="gasto">Gasto</option>
        </select>
        <br>
        <button type="submit">Registrar</button>
    </form>

    <div class="resultados">
        <h2>Estado Actual</h2>
        <p><strong>Total Ingresos: $<%= request.getAttribute("ingresos") %></strong></p>
        <p><strong>Total Gastos: $<%= request.getAttribute("gastos") %></strong></p>
        <p>
            <strong>Saldo Disponible: 
            <% 
                double saldo = (double) request.getAttribute("saldo");
                String classSaldo = saldo < 0 ? "saldoNegativo" : "saldoPositivo";
                DecimalFormat df = new DecimalFormat("#.##");
            %>
            <span class="<%= classSaldo %>">$<%= df.format(saldo) %></span>
            </strong>
        </p>

        <h3>Detalles:</h3>
        <p class="resultadoIngreso">Ingreso: $<%= request.getAttribute("ingresos") %></p>
        <p class="resultadoGasto">Gasto: $<%= request.getAttribute("gastos") %></p>
    </div>
</body>
</html>
