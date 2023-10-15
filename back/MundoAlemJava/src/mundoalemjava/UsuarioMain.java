
package mundoalemjava;

import java.sql.SQLException;
import usuario.Usuario;
import usuario.UsuarioDAO;

public class UsuarioMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UsuarioDAO userdao = new UsuarioDAO();
        /*Usuario user1 = new Usuario("015", "Thiago", "12-06-1990");
        Usuario user2 = new Usuario("963", "Ana", "09-07-1985");
        Usuario user3 = new Usuario("718", "Lia", "22-04-2002");
        
        userdao.AddUsuario(user1);
        userdao.AddUsuario(user2);
        userdao.AddUsuario(user3);
        
        Usuario user4 = new Usuario("718","Mike","22-04-2000");
        userdao.AtualizaUsuario(user4);
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa por CPF");
        System.out.println("------------------------------------------------");
        
        for(Usuario res: userdao.PesquisaUsuarioTipo("718", UsuarioDAO.tipoPesquisa.cpf)){
            System.out.println("CPF: " + res.getCpf() +
                    " | Nome: " + res.getNome() + " | Nascimento: " + res.getDataNasc());
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa por Nome");
        System.out.println("------------------------------------------------");
        
        for(Usuario res: userdao.PesquisaUsuarioTipo("Thiago", UsuarioDAO.tipoPesquisa.nome)){
            System.out.println("CPF: " + res.getCpf() +
                    " | Nome: " + res.getNome() + " | Nascimento: " + res.getDataNasc());
        }*/
        
       // userdao.DeletaUsuario("963");
       
       System.out.println("------------------------------------------------");
       System.out.println("Pesquisa Geral");
        System.out.println("------------------------------------------------");
        for(Usuario res: userdao.PesquisaUsuario()){
            System.out.println("CPF: " + res.getCpf() +
                    " | Nome: " + res.getNome() + " | Nascimento: " + res.getDataNasc());
        }
        
    }
    
}
