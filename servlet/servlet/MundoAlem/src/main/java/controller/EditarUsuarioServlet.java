package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editarUsuario")
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		RequestDispatcher rd = null;
		
		UsuarioDAO udao = new UsuarioDAO();
		List<Usuario> uselec = udao.PesquisaUsuarioTipo(cpf, UsuarioDAO.tipoPesquisa.cpf);
		
		if(!uselec.isEmpty()) {
			request.setAttribute("usuario", uselec.get(0));
			rd = request.getRequestDispatcher("/JSPpage/EditarUsuario.jsp");
		}else {
			rd = request.getRequestDispatcher("/JSPpage/Perfil.jsp");
		}
		
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario alteruser = new Usuario();
		alteruser.setNome(request.getParameter("nome"));
		alteruser.setDataNasc(request.getParameter("datanasc"));
		alteruser.setEmail(request.getParameter("email"));
		alteruser.setCpf(request.getParameter("cpf"));
		
		UsuarioDAO udao = new UsuarioDAO();
		try {
			udao.AtualizaUsuario(alteruser);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String email = request.getParameter("email");
		List<Usuario> usuario = new ArrayList<Usuario>();
		usuario = udao.PesquisaUsuarioTipo(email,UsuarioDAO.tipoPesquisa.email);
		request.setAttribute("perfiluser", usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPpage/Perfil.jsp");
		dispatcher.forward(request, response);
	}

}
