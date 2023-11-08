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

@WebServlet("/inserirUsuario")
public class InserirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InserirUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String dataNasc = request.getParameter("datanasc");
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		Usuario newUser = new Usuario();
		
		newUser.setCpf(cpf);
		newUser.setNome(nome);
		newUser.setDataNasc(dataNasc);
		newUser.setEmail(email);
		newUser.setSenha(senha);
		
		UsuarioDAO udao = new UsuarioDAO();
		
		try {
			udao.AddUsuario(newUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		List<Usuario> usuario = new ArrayList<Usuario>();
		usuario = udao.PesquisaUsuarioTipo(email,UsuarioDAO.tipoPesquisa.email);
		request.setAttribute("perfiluser", usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSPpage/Perfil.jsp");
		dispatcher.forward(request, response);
	}

}
