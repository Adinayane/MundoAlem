package mundoalemjava;

import destino.Destino;
import destino.DestinoDAO;
import destino.DestinoEscolhido;
import destino.EscolhidoDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import pagamento.TipoPagamento;
import pagamento.TipoPagamentoDAO;
import pagamento.Pagamento;
import pagamento.PagamentoDAO;
import usuario.Usuario;
import usuario.UsuarioDAO;
import usuario.UsuarioDAO.tipoPesquisa;

public class MundoAlemJava {
    public void resumo(){
        String select = "SELECT your_columns FROM table1 "+
                "INNER JOIN table2 ON table1.col1 = table2.col1"+
                "INNER JOIN table3 ON table2.col2 = table3.col2";
        System.out.println();
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*teste para receber data vencimento*/
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formaData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFinal = dataAtual.format(formaData);

        /*--------------------------------------------*/
        
       
    }
}
