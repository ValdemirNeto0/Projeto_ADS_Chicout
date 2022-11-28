package ryck.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoDisciplina implements Dao<Disciplina>{
    @Override
    public Optional<Disciplina> get(long id) {
        String sql = "SELECT * FROM disciplina WHERE idDisciplina = " + id;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Disciplina disciplina = new Disciplina();
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
           
            disciplina.setId_disciplina(resultSet.getInt("id_disciplina"));
            disciplina.setNome_disciplina(resultSet.getString("nome"));
            disciplina.setCarga_horaria(resultSet.getString("endereco"));

        } catch (Exception ex) {
            try {
                throw new SQLException("Erro, Disciplina nao encontrado!"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DaoDisciplina.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement, resultSet);
        }
        return Optional.of(disciplina);
    }

    @Override
    public List<Disciplina> getAll() {
        String sql = "SELECT * FROM disciplina";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Disciplina> alunosList = new ArrayList<Disciplina>();
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId_disciplina(resultSet.getInt("idDisciplina"));
                disciplina.setNome_disciplina(resultSet.getString("nomeDisciplina"));
                disciplina.setCarga_horaria(resultSet.getString("cargaHoraria"));
                disciplinaList.add(disciplina);
            }
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro de listagem"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DaoDisciplina.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement, resultSet);
        }
        return alunosList;
    }

    @Override
    public void save(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (nomeDisciplina,cargaHoraria,idDisciplina) VALUES (?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, disciplina.getNome_disciplina());
            statement.setString(2, disciplina.getCarga_horaria());
            statement.setString(3, disciplina.getId_disciplina());
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o Disciplina!"+ ex.getMessage(), ex);
        } finally {
            Conection.closeConnection(con, statement);
        }
    }

    @Override
    public void update(Disciplina disciplina, String[] params) {
        String sql = "UPDATE disciplina SET nomeDisciplina = ?, idDisciplina = ?, cargaHoraria = ?, ";
        Connection con = null;
        PreparedStatement statement = null;
        for( int i = 0; i < 6; i++){
            if(params[i] == null){
                switch (i){
                    case 0: 
                    params[i] = disciplina.getNome_disciplina();
                    break;
                    case 1:
                    params[i] = disciplina.getCarga_horaria();
                    break;
                    case 2:
                    params[i] = disciplina.getId_disciplina();
                    break;
                    case 3:
                    params[i] = Integer.toString(disciplina.getNome_disciplina());
                    break;
                    case 4:
                    params[i] = Integer.toString(disciplina.getCarga_horaria());
                    break;
                    case 5:
                    params[i] = Integer.toString(disciplina.getId_disciplina());
                    break;
            }
        }
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, params[0]);
            statement.setString(2, params[1]);
            statement.setString(3, params[2]);
            statement.setString(4, params[3]);
            statement.setString(5, params[4]);
            statement.setInt(6, Integer.parseInt(params[5]));
            statement.setInt(7, disciplina.getId_disciplina());
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao realizar a edicao!" + ex.getMessage(), ex);
        } finally {
            Conection.closeConnection(con, statement);
        }
    }
    }

    @Override
    public void delete(Disciplina disciplina) {
        String sql = "DELETE FROM disciplina WHERE idDisciplina = ?";

        Connection con = null;

        PreparedStatement statement = null;
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            Conection.getConnection();
            statement.setInt(1, Disciplina.getId_disciplina());
            statement.execute();
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao deletar a disciplina!"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(DaoDisciplina.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement);
        }
    }
}