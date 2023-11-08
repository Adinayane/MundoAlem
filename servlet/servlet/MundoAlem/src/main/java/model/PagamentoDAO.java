package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PagamentoDAO {

    /*--------------DEFINIÇÃO DAS CLASSES CONNECTION E PREPAREDSTATEMENT-----------------------------*/
    Connection conecta = null;
    PreparedStatement prepara = null;
    ResultSet resposta = null;

    /*--------------INSERIR FORMA DE PAGAMENTO-------------------------------*/
    public void AddForma(Pagamento formaPag) throws SQLException {
        String inserir= "INSERT INTO pagamento(valor,parcelas, dataVenc, valorParcela, "
                + "fk_Usuario_cpf, fk_tipoPagamento_idTipo) "
                + "VALUES(?,?,str_to_date(?,'%d-%m-%Y'),?,?,?)";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(inserir);
            prepara.setDouble(1, formaPag.getValor());
            prepara.setInt(2, formaPag.getParcelas());
            prepara.setString(3, formaPag.getDataVenc());
            prepara.setDouble(4, formaPag.getValorParcela());
            prepara.setString(5, formaPag.getFk_Cpf().getCpf());
            prepara.setInt(6, formaPag.getFk_idTipo().getIdTipo());
            prepara.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepara != null) {
                    prepara.close();
                }
                if (conecta != null) {
                    conecta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deletaForma(int idPag) {
        String deleta = "DELETE FROM pagamento WHERE idPag=?";
        
        try {
            System.out.println("Você está deletando uma forma de pagamento!");
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(deleta);
            prepara.setInt(1, idPag);
            prepara.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conecta != null) {
                    conecta.close();
                }
                if (prepara != null) {
                    prepara.close();
                }
                if (resposta != null) {
                    resposta.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void atualizaForma(Pagamento formaPag) {
        String atualiza = "UPDATE pagamento SET "
                + "valor=?, parcelas=?, valorParcela=?,fk_tipoPagamento_idTipo=?, "
                + " dataVenc=str_to_date(?,'%d-%m-%Y') "
                + "WHERE idPag=?";
        try {
            conecta = ConexaoBD.fazConexao();            
            prepara = conecta.prepareStatement(atualiza);
            prepara.setDouble(1, formaPag.getValor());
            prepara.setInt(2, formaPag.getParcelas());
            prepara.setDouble(3, formaPag.getValorParcela());            
            prepara.setInt(4, formaPag.getFk_idTipo().getIdTipo());
            prepara.setString(5, formaPag.getDataVenc());
            prepara.setInt(6, formaPag.getIdPag());
            prepara.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conecta != null) {
                    conecta.close();
                }
                if (prepara != null) {
                    prepara.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Pagamento> pesquisaFormaById(int idPag) {
        String pesquisa = "SELECT * FROM pagamento WHERE idPag=?";
        
        List<Pagamento> formaPag = new ArrayList<>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
            prepara.setInt(1, idPag);
                        
            resposta = prepara.executeQuery();
            while (resposta.next()) {
                Pagamento pag = new Pagamento();
                pag.setIdPag(idPag);
                pag.setValor(resposta.getDouble("valor"));
                pag.setParcelas(resposta.getInt("parcelas"));
                pag.setValorParcela(resposta.getDouble("valorParcela"));
                pag.setDataVenc(resposta.getString("dataVenc"));
                
                String cpf = resposta.getString("fk_Usuario_cpf");
                UsuarioDAO usuariodao = new UsuarioDAO();
                List<Usuario> usuarios = usuariodao.PesquisaUsuarioTipo(cpf, UsuarioDAO.tipoPesquisa.cpf);
                
                if (!usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        pag.setFk_Cpf(usuario);
                    }
                } else {
                    System.out.println("A lista está vazia");
                }
                
                int idTipo = resposta.getInt("fk_tipoPagamento_idTipo");
                TipoPagamentoDAO tipodao = new TipoPagamentoDAO();
                List<TipoPagamento> tipo = tipodao.pesquisaTipo(idTipo);
                if (!tipo.isEmpty()) {
                    for (TipoPagamento type : tipo) {
                        pag.setFk_idTipo(type);
                    }
                }
                
                formaPag.add(pag);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return formaPag;
    }
    
     public List<Pagamento> pesquisaForma() {
        String pesquisa = "SELECT * FROM pagamento";
        
        List<Pagamento> formaPag = new ArrayList<>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
                        
            resposta = prepara.executeQuery();
            while (resposta.next()) {
                Pagamento pag = new Pagamento();
                pag.setIdPag(resposta.getInt("idPag"));
                pag.setValor(resposta.getDouble("valor"));
                pag.setParcelas(resposta.getInt("parcelas"));
                pag.setValorParcela(resposta.getDouble("valorParcela"));
                pag.setDataVenc(resposta.getString("dataVenc"));
                
                String cpf = resposta.getString("fk_Usuario_cpf");
                UsuarioDAO usuariodao = new UsuarioDAO();
                List<Usuario> usuarios = usuariodao.PesquisaUsuarioTipo(cpf, UsuarioDAO.tipoPesquisa.cpf);
                
                if (!usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        pag.setFk_Cpf(usuario);
                    }
                } else {
                    System.out.println("A lista está vazia");
                }
                
                int idTipo = resposta.getInt("fk_tipoPagamento_idTipo");
                TipoPagamentoDAO tipodao = new TipoPagamentoDAO();
                List<TipoPagamento> tipo = tipodao.pesquisaTipo(idTipo);
                if (!tipo.isEmpty()) {
                    for (TipoPagamento type : tipo) {
                        pag.setFk_idTipo(type);
                    }
                }
                
                formaPag.add(pag);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return formaPag;
    }
}
