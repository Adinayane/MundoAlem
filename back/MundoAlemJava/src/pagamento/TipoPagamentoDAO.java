package pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mundoalemjava.ConexaoBD;

public class TipoPagamentoDAO {

    Connection conecta = null;
    PreparedStatement prepara = null;
    ResultSet resposta = null;
//------------------------------DAO---------------------------------------

    public void AddTipo(TipoPagamento tipo) throws SQLException {
        String insert = "INSERT INTO tipoPagamento(descricao,dataVenc)"
                + "VALUES(?,str_to_date(?,'%d-%m-%Y'))";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, tipo.getDescricao());
            prepara.setString(2, tipo.getDataVenc());
            prepara.executeUpdate();

            resposta = prepara.getGeneratedKeys();
            resposta.next();
            int idTipoGer = resposta.getInt(1);
            tipo.setIdTipo(idTipoGer);

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
                if (resposta != null) {
                    resposta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletaTipo(int idTipo) {
        String sql = "DELETE FROM tipoPagamento WHERE idTipo=?";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(sql);
            prepara.setInt(1, idTipo);
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

            }
        }
    }

    public void atualizaTipo(TipoPagamento tipo) {
        String atualiza = "UPDATE tipoPagamento SET descricao=?,"
                + " dataVenc=str_to_date(?,'%d-%m-%Y') "
                + "WHERE idTipo=?";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(atualiza);
            prepara.setString(1, tipo.getDescricao());
            prepara.setString(2, tipo.getDataVenc());
            prepara.setInt(3, tipo.getIdTipo());
            prepara.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conecta != null) {
                    conecta.close();
                }
                if (prepara != null) {
                    prepara.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<TipoPagamento> pesquisaTipo(int idTipo) {
        String pesquisa = "SELECT * FROM tipoPagamento WHERE idTipo=?";
        List<TipoPagamento> tipos = new ArrayList<>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
            prepara.setInt(1, idTipo);

            resposta = prepara.executeQuery();
            while (resposta.next()) {
                TipoPagamento tipo = new TipoPagamento();
                tipo.setIdTipo(idTipo);
                tipo.setDescricao(resposta.getString("descricao"));
                tipo.setDataVenc(resposta.getString("dataVenc"));

                tipos.add(tipo);
            }
        } catch (ClassNotFoundException | SQLException e) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tipos;
    }
    
    public List<TipoPagamento> pesquisaTiposPag() {
        String pesquisa = "SELECT * FROM tipoPagamento";
        List<TipoPagamento> tipos = new ArrayList<>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
           
            resposta = prepara.executeQuery();
            while (resposta.next()) {
                TipoPagamento tipo = new TipoPagamento();
                tipo.setIdTipo(resposta.getInt("idTipo"));
                tipo.setDescricao(resposta.getString("descricao"));
                tipo.setDataVenc(resposta.getString("dataVenc"));

                tipos.add(tipo);
            }
        } catch (ClassNotFoundException | SQLException e) {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tipos;
    }
}
