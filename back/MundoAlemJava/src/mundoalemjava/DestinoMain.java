
package mundoalemjava;

import destino.Destino;
import destino.DestinoDAO;
import destino.DestinoEscolhido;
import destino.EscolhidoDAO;
import java.sql.SQLException;
import usuario.Usuario;

public class DestinoMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DestinoDAO destdao = new DestinoDAO();
        EscolhidoDAO escdao = new EscolhidoDAO();
        
        /*Destino dest1 = new Destino("Paris - França");
        Destino dest2 = new Destino("Rio de Janeiro");
        Destino dest3 = new Destino("Lençóis Maranhenses");
        
        destdao.AddDestino(dest3);
        destdao.AddDestino(dest2);
        destdao.AddDestino(dest1);*/
        
        Destino dest = new Destino();
        dest.setNomeDestino("Olinda-Pernambuco");
        dest.setIdDestino(3);
        //destdao.atualizaDestino(dest);
        //destdao.deletaDestino(2);
        
        /*Destino teste = new Destino();
        teste.setNomeDestino("Paris - França");
        teste.setIdDestino(1);
        destdao.atualizaDestino(teste);
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa por Id de Destino");
        System.out.println("------------------------------------------------");
        
        for(Destino dId: destdao.PesquisaDestinoById(1)){
            System.out.println("Id: " + dId.getIdDestino() +
                    "| nome: "+dId.getNomeDestino());
        }*/
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa Geral");
        System.out.println("------------------------------------------------");
        
        for(Destino d: destdao.PesquisaDestinos()){
            System.out.println("Id: " + d.getIdDestino() +
                    "| nome: "+d.getNomeDestino());
        }
        
        Usuario user = new Usuario();
        user.setCpf("718");
        user.getCpf();
        Destino destiny = new Destino();
        destiny.setIdDestino(3);
        destiny.getIdDestino();
        
        DestinoEscolhido dEsc1 = new DestinoEscolhido("12-10-2023",
        "30-10-2023", user, destiny);
        
        //escdao.AddViagem(dEsc1);
        
        DestinoEscolhido dEsc2 = new DestinoEscolhido("11-11-2023",
        "04-12-2023", user, destiny);
        
        //escdao.AddViagem(dEsc2);
        
        DestinoEscolhido atual = new DestinoEscolhido();
        atual.setDataIda("05-02-2024");
        atual.setDataVolta("03-03-2024");
        atual.setFk_idDestino(destiny);
        atual.setNumViagem(3);
        
        //escdao.AtualizarViagem(atual);
        //escdao.DeletaViagem(2);
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa por Número de Viagem");
        System.out.println("------------------------------------------------");
        
        for(DestinoEscolhido dNum: escdao.PesquisaEscolhido(4)){
            System.out.println("NumViagem: " + dNum.getNumViagem());
            System.out.println("Cpf: " + dNum.getFk_Cpf());
            System.out.println("idDestino: " + dNum.getFk_idDestino());
            System.out.println("Ida: " + dNum.getDataIda());
            System.out.println("Volta: " + dNum.getDataVolta());
        }
        
        System.out.println("------------------------------------------------");
        System.out.println("Pesquisa Geral");
        System.out.println("------------------------------------------------");
        
        for(DestinoEscolhido dNum: escdao.PesquisaEscolhidos()){
            System.out.println();
            System.out.println("NumViagem: " + dNum.getNumViagem());
            System.out.println("Cpf: " + dNum.getFk_Cpf());
            System.out.println("idDestino: " + dNum.getFk_idDestino());
            System.out.println("Ida: " + dNum.getDataIda());
            System.out.println("Volta: " + dNum.getDataVolta());
            System.out.println();
        }
        
    }
    
}
