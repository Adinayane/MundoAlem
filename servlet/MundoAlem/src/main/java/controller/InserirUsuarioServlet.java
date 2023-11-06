package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/inserirUsuario")
public class InserirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		response.sendRedirect("/MundoAlem/JSPpage/Perfil.jsp");
	}

}
