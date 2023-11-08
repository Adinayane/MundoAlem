package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Destino;
import model.DestinoDAO;
import model.DestinoEscolhido;
import model.EscolhidoDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/escolherDestino")
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numViagem = Integer.parseInt(request.getParameter("numViagem"));
		List<DestinoEscolhido> destinoEsc = new ArrayList<DestinoEscolhido>();
		EscolhidoDAO dedao = new EscolhidoDAO();
		
		destinoEsc = dedao.PesquisaEscolhidos();
		request.setAttribute("destEsc", destinoEsc);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPpage/Perfil.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
