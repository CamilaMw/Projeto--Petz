package DAO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Classe responsável por abrir a conexão com o banco de dados.
 *
 * @author Camila
 */
public class Conexao {
    // Dados de conexão
    private static final String SERVIDOR = "localhost";
    private static final String PORTA = "5432";
    private static final String BANCO_DE_DADOS = "TrabalhoVendas";
    private static final String USUARIO = "postgres"; //  o usuário padrão é "postgres"
    private static final String SENHA = "ca182730"; //  ser substituído pela senha real do banco de dados

    // URL de conexão JDBC
    private static final String URL = "jdbc:postgresql://" + SERVIDOR + ":" + PORTA + "/" + BANCO_DE_DADOS;

    private Connection conexao;

    public Conexao() throws SQLException {
        try {
            // Carregando o driver JDBC
            Class.forName("org.postgresql.Driver");
            // Obtendo a conexão com o banco de dados
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            JOptionPane.showMessageDialog(null, "Conectado");
            // Configurando para não realizar commits automáticos
            conexao.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado.", e);
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar com a base de dados.", e);
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void confirmar() throws SQLException {
        try {
            conexao.commit();
        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                throw new SQLException("Erro ao tentar rollback após falha no commit.", ex);
            }
            throw new SQLException("Erro ao tentar commit.", e);
        } finally {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }
}
