package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    /*--------------DEFINIÇÃO DAS CLASSES CONNECTION E PREPAREDSTATEMENT-----------------------------*/
    Connection conecta = null;
    PreparedStatement prepara = null;
    ResultSet resposta = null;

    /*--------------INSERIR USUARIO-------------------------------*/

    public void AddUsuario(Usuario usuario) throws SQLException {
        String insert = "INSERT INTO usuario(cpf,nome,dataNasc,email,senha)"
                + "VALUES(?,?,str_to_date(?,'%d-%m-%Y'),?,?)";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            prepara.setString(1, usuario.getCpf());
            prepara.setString(2, usuario.getNome());
            prepara.setString(3, usuario.getDataNasc());
            prepara.setString(4, usuario.getEmail());
            prepara.setString(5, usuario.getSenha());
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeletaUsuario(String cpf) {
        String deleta = "DELETE FROM usuario WHERE cpf=?";
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(deleta);
            prepara.setString(1, cpf);
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

    public void AtualizaUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        String atualiza = "UPDATE usuario SET nome=?, dataNasc=str_to_date(?,'%d-%m-%Y'), email=?, senha=? "
                + "WHERE cpf=?";

        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(atualiza);
            prepara.setString(1, usuario.getNome());
            prepara.setString(2, usuario.getDataNasc());
            prepara.setString(3, usuario.getEmail());
            prepara.setString(4, usuario.getSenha());
            prepara.setString(5, usuario.getCpf());
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

    public List<Usuario> PesquisaUsuarioTipo(String user, tipoPesquisa tipo) {
        String pesquisa = "SELECT * FROM usuario WHERE cpf=?";
        String pesquisaEmail = "SELECT * FROM usuario WHERE email=?";

        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conecta = ConexaoBD.fazConexao();
            String query;
            if (tipo == tipoPesquisa.cpf) {
                query = pesquisa;
            } else if (tipo == tipoPesquisa.email) {
                query = pesquisaEmail;
            } else {
                System.out.println("Tipo de pesquisa incorreta ou vazia.");
                return usuarios;
            }
            prepara = conecta.prepareStatement(query);
            prepara.setString(1, user);

            resposta = prepara.executeQuery();
            
            while (resposta.next()) {
                Usuario usuario = new Usuario();
                usuario.setCpf(resposta.getString("cpf"));
                usuario.setNome(resposta.getString("nome"));
                usuario.setDataNasc(resposta.getString("dataNasc"));
                usuario.setEmail(resposta.getString("email"));
                usuario.setSenha(resposta.getString("senha"));

                usuarios.add(usuario); //add - método do array
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
        return usuarios;
    }
    //---- auxilia o método pesquisaUsuarioTipo----- 

    public enum tipoPesquisa {
        cpf,
        email
    }
    
    public List<Usuario> PesquisaUsuario() {
        String pesquisa = "SELECT * FROM usuario";

        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conecta = ConexaoBD.fazConexao();
            prepara = conecta.prepareStatement(pesquisa);
            resposta = prepara.executeQuery();

            while (resposta.next()) {
                Usuario usuario = new Usuario();
                usuario.setCpf(resposta.getString("cpf"));
                usuario.setNome(resposta.getString("nome"));
                usuario.setDataNasc(resposta.getString("dataNasc"));
                //usuario.setEmail(resposta.getString("email"));
                //usuario.setSenha(resposta.getString("senha"));

                usuarios.add(usuario); //add - método do array
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
        return usuarios;
    }
}
