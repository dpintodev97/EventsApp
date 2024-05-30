package es.events.servlets;
import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		name = "HTMLServlet",    //NOMBRE SERVLET
		urlPatterns = {"/vistas/html"}, //PATRON A USAR PARA ACCDER AL SERVLET; ACCEDER A LA APP PRINCIPAL AL ESCRIBIR /html
		loadOnStartup = 1        //INDICA QUE CARGUE EL SERVLET EN CUANTO ARRANQUE LA APP.

		)  
public class HTMLServlet extends HttpServlet { //PUEDE EXTENDER PORQUE PREVIAMENTE INCLUÍ LA DEPENDEN.: jakarta.servlet-api
	
	//NOTA: ESCRIBIR doGet Y EL ASISTENTE DE ECLIPSE LO CREA SOLO LA PLANTILLA E IMPORTA LAS DEPENDENCIAS AUTOM.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1.DEFINIR EL TIPO DE SALIDA, DE RESPUESTA; QUE SERÍA UN HTML EN UTF-8:
		resp.setContentType("text/html;charset=UTF-8");
		
		//2.GENERAR TIPO DE SALIDA QUE OFRECER COMO body, cuerpo, DE LA RESPUESTA (response) CON UN OutputStream (PARA ABRIR FICHEROS, MANEJOS DE DATOS...SE USA STreams)
		ServletOutputStream out = resp.getOutputStream();
		
		//3.IMPRIMIR DATOS EN LA SALIDA HTML:
		out.print("<html>" +
				"<head><tittle>Pagina Servlets</tittle></head" +
				"<body><h2>Pagina generada desde un Servlet</h2></body>" +
				"</html>"
				);
		// Cerrar el ServletOutputStream
        out.close();
		
	}
	

}
