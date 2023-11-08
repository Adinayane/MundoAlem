package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pagamento;
import model.PagamentoDAO;
import model.TipoPagamento;
import model.TipoPagamentoDAO;
import model.Usuario;
import model.Destino;
import model.DestinoDAO;
import model.DestinoEscolhido;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/requisitarViagem")
public class PagamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PagamentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TipoPagamento> tp = new ArrayList<TipoPagamento>();
		TipoPagamentoDAO tpdao = new TipoPagamentoDAO();
		tp = tpdao.pesquisaTiposPag();
		request.setAttribute("tiposPag", tp);

		List<Destino> destinoOpcao = new ArrayList<Destino>();
		DestinoDAO ddao = new DestinoDAO();
		destinoOpcao = ddao.PesquisaDestinos();
		request.setAttribute("destOp", destinoOpcao);

		int resId = 0;
		for(Destino destino: destinoOpcao) {
			int idDest = destino.getIdDestino();
			resId = idDest;
		}
		
		List<Destino> destino = new ArrayList<Destino>();
		destino = ddao.PesquisaDestinoById(resId);
		request.setAttribute("destEsc", destino);
		
		RequestDispatcher rd = request.getRequestDispatcher("/JSPpage/EditarCompra.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario user = new Usuario();
		Destino nd = new Destino();
		String dataIda = request.getParameter("dataIda");
		String dataVolta = request.getParameter("dataVolta");
		String fk_cpf = request.getParameter("cpf");
		int idDestino = Integer.parseInt(request.getParameter("idDestino"));
		
		
		DestinoEscolhido de = new DestinoEscolhido();
		de.setDataIda(dataIda);
		de.setDataVolta(dataVolta);
		de.setFk_Cpf(user);
		de.setFk_idDestino(nd);
		
		double valor = Double.parseDouble(request.getParameter("valor"));
		int parcelas = Integer.parseInt(request.getParameter("parcelas"));
		String dataVenc = request.getParameter("dataVenc");
		double valorParcela = Double.parseDouble(request.getParameter("valorParcela"));
		//String fk_cpf = request.getParameter("fk_cpf");
		int fk_idTipo = Integer.parseInt(request.getParameter("fk_idTipo"));
		
		
		//Usuario user = new Usuario();
		TipoPagamento tip = new TipoPagamento();
		Pagamento newPag = new Pagamento();
		
		newPag.setValor(valor);
		newPag.setParcelas(parcelas);
		
		newPag.setDataVenc(dataVenc);
		
		double valorParcelado = newPag.parcelar(valor, parcelas);
		request.setAttribute("valorParc", valorParcelado);
				
		newPag.setValorParcela(valorParcela);
		newPag.setFk_Cpf(user);
		newPag.setFk_idTipo(tip);
		
		
		
		PagamentoDAO updao = new PagamentoDAO();
		try {
			updao.AddForma(newPag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/JSPpage/Perfil.jsp");
	}

}
