package br.edu.uniaeso.Conector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conection {
    public static final String DRIVER = "org.h2.Driver";
    public static final String URL = "jdbc:h2:file:.\\DB";
    public static final String USER = "sa";//alterar
    public static final String PASS = "";//alterar
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao conectar com o banco de dados");
        }
    }

    public static void closeConnection(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao encerrar a conexao com o banco de dados");
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao encerrar a conexao com o banco de dados");
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao encerrar a conexão com o banco de dados");
        }
    }
}
