import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TurmaDao implements Dao<Turma>{

    @Override
    public Optional<Turma> get(long id) {
        String sql = "SELECT * FROM turmas WHERE idTurma = " + id;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Turma turmas = new Turma();
        try {
            con = Connection.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();

            turmas.setIdTurma(resultSet.getInt("idTurma"));
            turmas.setturmaNome(resultSet.getString("nome da turma: "));

        } catch (Exception ex) {
            try {
                throw new SQLException("Erro, a turma nao foi encontrada!"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(TurmaDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement, resultSet);
        }
        return Optional.of(turmas);
    }

    @Override
    public List<Turma> getAll() {
        String sql = "SELECT * FROM alunos";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Turma> turmasList = new ArrayList<Turma>();
        try {
            con = Connection.getConnection();
            statement = con.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Turma turmas = new Turma();
                turmas.setIdTurma(resultSet.getInt("idTurma"));
                turmas.setturmaNome(resultSet.getString("nome da turma: "));

                turmasList.add(turmas);
            }
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro de listagem"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(TurmaDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Connection.closeConnection(con, statement, resultSet);
        }
        return turmasList;
    }

    @Override
    public void save(Turma turmas) {
        String sql = "INSERT INTO turmas (nome,idAluno,idProfessor) VALUES (?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        DatabaseMetaData Conection;
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, turmas.getturmaNome());
            statement.setInt(4, turmas.getIdTurma());
            statement.setInt(5, turmas.getidAluno());
            statement.setInt(6, turmas.getidCurso());
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o aluno!"+ ex.getMessage(), ex);
        } finally {
            Conection.closeConnection(con, statement);
        }
    }

    @Override
    public void update(Turma turmas, String[] params) {
        String sql = "UPDATE turmas SET nome = ?, endereco = ?, email = ?, "
                + "idTurma = ?, idCurso = ? WHERE idAluno = ?" ;
        Connection con = null;
        PreparedStatement statement = null;
        for( int i = 0; i < 6; i++){
            if(params[i] == null){
                switch (i) {
                    case 0:
                        params[i] = turmas.getturmaNome();
                        break;
                    case 1:
                        params[i] = turmas.getqTdAlunos();
                        break;
                    case 2:
                        params[i] = Integer.toString(turmas.getIdTurma());
                        break;
                    case 3:
                        params[i] = Integer.toString(turmas.getidAluno());
                        break;
                    case 4:
                        params[i] = Integer.toString(turmas.getidCurso());
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
                statement.setInt(7, turmas.getIdTurma());
                statement.execute();
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao realizar a edicao!" + ex.getMessage(), ex);
            } finally {
                Conection.closeConnection(con, statement);
            }
        }
    }

    @Override
    public void delete(Turma turmas) {
        String sql = "DELETE FROM turmas WHERE idTurma = ?";

        Connection con = null;

        PreparedStatement statement = null;
        DatabaseMetaData Conection;
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            Conection.getConnection();
            statement.setInt(1, turmas.getIdTurma());
            statement.execute();
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao deletar a turma!"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(TurmaDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement);
        }
    }
}
}
