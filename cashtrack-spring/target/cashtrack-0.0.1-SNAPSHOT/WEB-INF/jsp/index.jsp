<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CashTrack - Gestión de Ingresos y Gastos</title>
    <style>
        .positive { color: green; }
        .negative { color: red; }
    </style>
</head>
<body>
    <h1>CashTrack</h1>
    
    <form action="${pageContext.request.contextPath}/process" method="post">
        <label for="valor">Ingrese el monto:</label>
        <input type="text" name="valor" id="valor" required/>
        <br/>
        <label for="tipo">Tipo:</label>
        <select name="tipo" id="tipo">
            <option value="ingreso">Ingreso</option>
            <option value="gasto">Gasto</option>
        </select>
        <br/>
        <button type="submit">Registrar</button>
    </form>
    
    <h2>Estado Actual</h2>
    <p>Total Ingresos: $<c:out value="${cashTrack.ingresos}" /></p>
    <p>Total Gastos: $<c:out value="${cashTrack.gastos}" /></p>
    <p>Saldo Disponible: 
        <c:choose>
            <c:when test="${cashTrack.saldo < 0}">
                <span class="negative">$<c:out value="${cashTrack.saldo}" /></span>
            </c:when>
            <c:otherwise>
                <span class="positive">$<c:out value="${cashTrack.saldo}" /></span>
            </c:otherwise>
        </c:choose>
    </p>
</body>
</html>
