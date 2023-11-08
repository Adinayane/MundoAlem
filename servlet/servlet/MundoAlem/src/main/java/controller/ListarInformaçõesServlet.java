package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DestinoEscolhido;
import model.EscolhidoDAO;
import model.Pagamento;
import model.PagamentoDAO;
import model.TipoPagamento;
import model.TipoPagamentoDAO;
import model.Usuario;
import model.UsuarioDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/perfil")
public class ListarInformaçõesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListarInformaçõesServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		List<Usuario> usuario = new ArrayList<Usuario>();
		
		UsuarioDAO udao = new UsuarioDAO();
		usuario = udao.PesquisaUsuarioTipo(email,UsuarioDAO.tipoPesquisa.email);
		request.setAttribute("perfiluser", usuario);
		
		//int numViagem = Integer.parseInt(request.getParameter("numViagem"));
		List<DestinoEscolhido> destinoEsc = new ArrayList<DestinoEscolhido>();
		EscolhidoDAO dedao = new EscolhidoDAO();
		
		destinoEsc = dedao.PesquisaEscolhidos();
		request.setAttribute("destEsc", destinoEsc);
		
		List<Pagamento> pag = new ArrayList<Pagamento>();
		PagamentoDAO pgdao = new PagamentoDAO();
		
		pag = pgdao.pesquisaForma();
		request.setAttribute("pgs", pag);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPpage/Perfil.jsp");
		dispatcher.forward(request, response);
	}

}
