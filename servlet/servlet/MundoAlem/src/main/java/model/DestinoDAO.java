package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author japao
 */
public class DestinoDAO {

    /*--------------DEFINIÇÃO DAS CLASSES CONNECTION E PREPAREDSTATEMENT-----------------------------*/
    Connection conecta = null;
    PreparedStatement prepara = null;
    ResultSet resposta = null;

    /*--------------DAO DESTINO-------------------------------*/
    public void AddDestino(Destino destino) throws SQLException {
        String insert = "INSERT INTO destino(nomeDestino, valorDestino)"
                + "VALUES(?,?)";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, destino.getNomeDestino());
            prepara.setDouble(2, destino.getValorDestino());
            prepara.executeUpdate();

            resposta = prepara.getGeneratedKeys();
            resposta.next();
            int idGerado = resposta.getInt(1);
            destino.setIdDestino(idGerado);

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

    public void deletaDestino(int idDestino) {
        String deleta = "DELETE FROM destino WHERE idDestino=?";

        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(deleta);
            prepara.setInt(1, idDestino);
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

    public void atualizaDestino(Destino destino) throws ClassNotFoundException, SQLException {
        String atualiza = "UPDATE destino SET nomeDestino=?, valorDestino=?"
                + "WHERE idDestino=?";

        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(atualiza);
            prepara.setString(1, destino.getNomeDestino());
            prepara.setDouble(2, destino.getValorDestino());
            prepara.setInt(3, destino.getIdDestino());
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

    public List<Destino> PesquisaDestinoById(int idDestino) {
        String pesquisa = "SELECT * FROM destino WHERE idDestino=?";

        List<Destino> destinos = new ArrayList<Destino>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);

            prepara.setInt(1, idDestino);
            resposta = prepara.executeQuery();

            while (resposta.next()) {
                Destino destino = new Destino();
                destino.setIdDestino(idDestino);
                destino.setNomeDestino(resposta.getString("nomeDestino"));
                destino.setValorDestino(resposta.getDouble("valorDestino"));

                destinos.add(destino); //add - método do array
            }
        } catch (Exception e) {
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
        return destinos;
    }
    
    public List<Destino> PesquisaDestinos() {
        String pesquisa = "SELECT * FROM destino";

        List<Destino> destinos = new ArrayList<Destino>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
            resposta = prepara.executeQuery();

            while (resposta.next()) {
                Destino destino = new Destino();
                destino.setIdDestino(resposta.getInt("idDestino"));
                destino.setNomeDestino(resposta.getString("nomeDestino"));
                destino.setValorDestino(resposta.getDouble("valorDestino"));

                destinos.add(destino); //add - método do array
            }
        } catch (Exception e) {
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
        return destinos;
    }
}
