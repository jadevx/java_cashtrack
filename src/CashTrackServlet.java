import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CashTrackServlet extends HttpServlet {
    private double ingresos = 0;
    private double gastos = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Establecer las variables para mostrar en la JSP
        request.setAttribute("ingresos", ingresos);
        request.setAttribute("gastos", gastos);
        request.setAttribute("saldo", ingresos - gastos);
        
        // Redirigir a la JSP para mostrar la interfaz
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los datos del formulario
        String tipo = request.getParameter("tipo");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        if ("ingreso".equals(tipo)) {
            ingresos += valor;
        } else if ("gasto".equals(tipo)) {
            gastos += valor;
        }

        // Redirigir a la JSP con los nuevos datos
        doGet(request, response);
    }
}
