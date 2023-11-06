package model
;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UsuarioDAO.tipoPesquisa;

public class EscolhidoDAO {

    Connection conecta = null;
    PreparedStatement prepara = null;
    ResultSet resposta = null;

    public void AddViagem(DestinoEscolhido dEscolhido) throws SQLException {

        String insert = "INSERT INTO escolhe(dataIda,dataVolta,"
                + "fk_Usuario_cpf,fk_Destino_idDestino)"
                + "VALUES(str_to_date(?,'%d-%m-%Y'),str_to_date(?,'%d-%m-%Y'),?,?)";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(insert);
            prepara.setString(1, dEscolhido.getDataIda());
            prepara.setString(2, dEscolhido.getDataVolta());
            prepara.setString(3, dEscolhido.getFk_Cpf().getCpf());
            prepara.setInt(4, dEscolhido.getFk_idDestino().getIdDestino());
            prepara.executeUpdate();

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

    public void DeletaViagem(int numViagem) {
        String deleta = "DELETE FROM escolhe WHERE numViagem=?";

        try {
            System.out.println("ATENÇÃO! DELETAR UMA VIAGEM É IRREVESÍVEL!");
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(deleta);
            prepara.setInt(1, numViagem);
            prepara.execute();

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
    }

    public void AtualizarViagem(DestinoEscolhido dEscolhido) {
        String atualiza = "UPDATE escolhe SET dataIda=str_to_date(?,'%d-%m-%Y'),"
                + " dataVolta=str_to_date(?,'%d-%m-%Y'), fk_Destino_idDestino=? "
                + "WHERE numViagem=?";

        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(atualiza);
            prepara.setString(1, dEscolhido.getDataIda());
            prepara.setString(2, dEscolhido.getDataVolta());
            prepara.setInt(3, dEscolhido.getFk_idDestino().getIdDestino());
            prepara.setInt(4, dEscolhido.getNumViagem());
            prepara.execute();
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<DestinoEscolhido> PesquisaEscolhido(int numViagem) {
        String pesquisa = "SELECT * FROM escolhe WHERE numViagem=?";

        List<DestinoEscolhido> escolhidos = new ArrayList<DestinoEscolhido>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);

            prepara.setInt(1, numViagem);

            resposta = prepara.executeQuery();
         
            while (resposta.next()) {
                DestinoEscolhido escolhido = new DestinoEscolhido();
                escolhido.setNumViagem(numViagem);
                escolhido.setDataIda(resposta.getString("dataIda"));
                escolhido.setDataVolta(resposta.getString("dataVolta"));

                String cpf = resposta.getString("fk_Usuario_cpf");
                UsuarioDAO usuariodao = new UsuarioDAO();
                List<Usuario> usuarios = usuariodao.PesquisaUsuarioTipo(cpf, tipoPesquisa.cpf);

                if (!usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        escolhido.setFk_Cpf(usuario);
                    }
                } else {
                    System.out.println("A lista está vazia");
                }
                int idDestino = resposta.getInt("fk_Destino_idDestino");
                DestinoDAO destinodao = new DestinoDAO();
                List<Destino> destinos = destinodao.PesquisaDestinoById(idDestino);

                if (!destinos.isEmpty()) {
                    for (Destino destino : destinos) {
                        escolhido.setFk_idDestino(destino);
                    }
                }

                escolhidos.add(escolhido); //add - método do array
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
        return escolhidos;
    }
    
    public List<DestinoEscolhido> PesquisaEscolhidos() {
        String pesquisa = "SELECT * FROM escolhe";

        List<DestinoEscolhido> escolhidos = new ArrayList<DestinoEscolhido>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
            resposta = prepara.executeQuery();
           
            while (resposta.next()) {
                DestinoEscolhido escolhido = new DestinoEscolhido();
                escolhido.setNumViagem(resposta.getInt("numViagem"));
                escolhido.setDataIda(resposta.getString("dataIda"));
                escolhido.setDataVolta(resposta.getString("dataVolta"));

                String cpf = resposta.getString("fk_Usuario_cpf");
                UsuarioDAO usuariodao = new UsuarioDAO();
                List<Usuario> usuarios = usuariodao.PesquisaUsuarioTipo(cpf, tipoPesquisa.cpf);

                if (!usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        escolhido.setFk_Cpf(usuario);
                    }
                } else {
                    System.out.println("A lista está vazia");
                }
                int idDestino = resposta.getInt("fk_Destino_idDestino");
                DestinoDAO destinodao = new DestinoDAO();
                List<Destino> destinos = destinodao.PesquisaDestinoById(idDestino);

                if (!destinos.isEmpty()) {
                    for (Destino destino : destinos) {
                        escolhido.setFk_idDestino(destino);
                    }
                }

                escolhidos.add(escolhido); //add - método do array
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
        return escolhidos;
    }
}
