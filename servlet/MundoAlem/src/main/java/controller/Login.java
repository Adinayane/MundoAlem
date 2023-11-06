package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/MundoAlem/pages/login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		String emailEnc = null;
		String senhaEnc = null;
		
		UsuarioDAO userdao = new UsuarioDAO();
		
		for(Usuario usuario: userdao.PesquisaUsuarioTipo(email, UsuarioDAO.tipoPesquisa.email)) {
			emailEnc = usuario.getEmail();
			senhaEnc = usuario.getSenha();
		}
		
		if(emailEnc != null && senhaEnc != null) {
			if(email.equals(emailEnc) && senha.equals(senhaEnc)) {
				response.sendRedirect("/JSPpage/Perfil.jsp");
			}else {
				response.sendRedirect("/MundoAlem/pages/destino.html");
			}
		}else{
			response.sendRedirect("/MundoAlem/pages/promocoes.html");
		}
	}

}
