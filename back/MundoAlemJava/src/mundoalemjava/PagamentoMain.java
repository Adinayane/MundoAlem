
package mundoalemjava;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import pagamento.Pagamento;
import pagamento.PagamentoDAO;
import pagamento.TipoPagamento;
import pagamento.TipoPagamentoDAO;
import usuario.Usuario;

public class PagamentoMain {

    public static void main(String[] args) throws SQLException {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formaData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFinal = dataAtual.format(formaData);
        
        
        Usuario user = new Usuario(); //15, 718
        user.setCpf("15");
        
        Usuario user2 = new Usuario();
        user2.setCpf("718");
        
        TipoPagamentoDAO tpdao = new TipoPagamentoDAO();
        TipoPagamento tipo1 = new TipoPagamento("Credito", dataFinal);
        TipoPagamento tipo2 = new TipoPagamento("Debito", dataFinal);
        TipoPagamento tipo3 = new TipoPagamento("Pix", dataFinal);
        
        /*tpdao.AddTipo(tipo1);
        tpdao.AddTipo(tipo2);
        tpdao.AddTipo(tipo3);*/
        
        TipoPagamento tipoAtual = new TipoPagamento();
        tipoAtual.setDescricao("Boleto");
        tipoAtual.setDataVenc("20-10-2023");
        tipoAtual.setIdTipo(2);
        
        //tpdao.atualizaTipo(tipoAtual);
        //tpdao.deletaTipo(3);
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa por Tipo de Pagamento");
        System.out.println("------------------------------------------------");
        
        for(TipoPagamento tp: tpdao.pesquisaTipo(2)){
            System.out.println();
            System.out.println("Id: " + tp.getIdTipo() + 
                    " Descricao: " + tp.getDescricao() + " Venc: "+tp.getDataVenc());
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa Geral");
        System.out.println("------------------------------------------------");
        
        for(TipoPagamento tp: tpdao.pesquisaTiposPag()){
            System.out.println();
            System.out.println("Id: " + tp.getIdTipo() + 
                    " Descricao: " + tp.getDescricao() + " Venc: "+tp.getDataVenc());
        }
        
        PagamentoDAO pagdao = new PagamentoDAO();
        tipo1.setIdTipo(1);
        tipo2.setIdTipo(2);
        Pagamento pag1 = new Pagamento(4500.33, 7, user, tipo1);
        Pagamento pag2 = new Pagamento(680.74, 3, user2, tipo2);
        Pagamento pag3 = new Pagamento(2000, 5, user2, tipo1);
        
        /*pagdao.AddForma(pag1);
        pagdao.AddForma(pag2);
        pagdao.AddForma(pag3);*/
        
        Pagamento atual = new Pagamento();
        atual.setValor(680.74);
        atual.setParcelas(1);
        double parcelado = atual.parcelar(atual.getValor(), atual.getParcelas());
        atual.setValorParcela(parcelado);
        atual.setFk_idTipo(tipo2);
        atual.setIdPag(11);
        
        //pagdao.atualizaForma(atual);
        //pagdao.deletaForma(12);
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa por Id de Pagamento");
        System.out.println("------------------------------------------------");
        
        for(Pagamento pag: pagdao.pesquisaFormaById(11)){
            System.out.println();
            System.out.println("IdPagamento: " + pag.getIdPag()+
                    " CPF: " + pag.getFk_Cpf() + " Tipo pagamento " +
                    pag.getFk_idTipo().getIdTipo() + " Valor: " + pag.getValor() + 
                    " Parcelas: " + pag.getParcelas() + " Valor/Parcela: "+
                    pag.getValorParcela());
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa Geral");
        System.out.println("------------------------------------------------");
        
        for(Pagamento pag: pagdao.pesquisaForma()){
            System.out.println();
            System.out.println("IdPagamento: " + pag.getIdPag()+
                    " CPF: " + pag.getFk_Cpf() + " Tipo pagamento " +
                    pag.getFk_idTipo().getIdTipo() + " Valor: " + pag.getValor() + 
                    " Parcelas: " + pag.getParcelas() + " Valor/Parcela: "+
                    pag.getValorParcela());
        }
        
    }
    
}
