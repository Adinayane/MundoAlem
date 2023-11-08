package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UsuarioDAO;

import java.io.IOException;

@WebServlet("/deletarUsuario")
public class DeletarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeletarUsuarioServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		UsuarioDAO udao = new UsuarioDAO();
		
		udao.DeletaUsuario(cpf);
		response.sendRedirect("/MundoAlem/pages/login.html");
	}

	

}
