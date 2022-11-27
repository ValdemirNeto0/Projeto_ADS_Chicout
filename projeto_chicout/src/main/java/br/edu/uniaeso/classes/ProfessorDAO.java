import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class ProfessorDAO implements Dao<Professor>{

    @Override
    public Optional<Professor> get(long id) {
        String sql = "SELECT * FROM Professor WHERE idProfessor = " + id;
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet ResultSet = null;
        Professor professor = new Professor();
        try {
            con = Connection.getConnection();
            statement = con.prepareStatement(sql);
            ResultSet = statement.executeQuery();

            Professor Professor = new Professor();
            Professor.setIdProfessor(ResultSet.getInt(("idProfessor"));
            Professor.setNomeProfessor(ResultSet.getString("nome"));
            Professor.setEnderecoprof(ResultSet.getString("endereco"));
            Professor.setEmailProf(ResultSet.getString("email"));
            Professor.setIdadeProf(ResultSet.getInt("idade"));
            Professor.setTelefoneprof(ResultSet.getString("Telefone"));

        } catch (Exception ex) {
            try {
                throw new SQLException("Erro, Professor nao encontrado!"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement, resultSet);
        }
        return Optional.of(professor);
    }

    @Override
    public List<Professor> getAll() {
        String sql = "SELECT * FROM professor";
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet ResultSet = null;
        List<Professor> ProfessorList = new ArrayList<Professor>();
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            ResultSet = statement.executeQuery();
            while (ResultSet.next()) {
                Professor Professor = new Professor();
                Professor.setIdProfessor(ResultSet.getInt(("idProfessor"));
                Professor.setNomeProfessor(ResultSet.getString("nome"));
                Professor.setEnderecoprof(ResultSet.getString("endereco"));
                Professor.setEmailProf(ResultSet.getString("email"));
                Professor.setIdadeProf(ResultSet.getInt("idade"));
                Professor.setTelefoneprof(ResultSet.getString("telefone"));
            }
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro de listagem"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement, ResultSet);
        }
        return ProfessorList;
    }
    @Override
    public void save(Professor Professor) {
        String sql = "INSERT INTO Professor (nome,endereco,email,idade,idprofessor,) VALUES (?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, Professor.getNomeProfessor());
            statement.setString(2, Professor.getEnderecoprof());
            statement.setString(3, Professor.getEmailProf());
            statement.setInt(   4, Professor.getIdadeProf());
            statement.setInt(   5, Professor.getIdProfessor());
            statement.setInt(   6, Professor.getTelefoneprof());
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o professor!"+ ex.getMessage(), ex);
        } finally {
            Conection.closeConnection(con, statement);
        }
    }
    @Override
    public void update(Professor professor, String[] params) {
        String sql = "UPDATE Professor SET nome = ?, endereco = ?, email = ?, "
                + "idade = ?, idProf = ?,WHERE idprof = ?" ;
        Connection con = null;
        PreparedStatement statement = null;
        for( int i = 0; i < 5; i++){
            if(params[i] == null){
                switch (i){
                    case 0:
                        params[i] = professor.getNomeProfessor();
                        break;
                    case 1:
                        params[i] = professor.getEnderecoprof();
                        break;
                    case 2:
                        params[i] = professor.getEmailProf();
                        break;
                    case 3:
                        params[i] = Integer.toString(professor.getIdadeProf());
                        break;
                    case 4:
                        params[i] = Integer.toString(professor.getIdProfessor());
                        break;
                    case 5:
                        params[i] = Integer.toString(professor.getTelefoneprof());
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
                statement.execute();
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao realizar a edicao!" + ex.getMessage(), ex);
            } finally {
                Conection.closeConnection(con, statement);
            }
        }
    }
    @Override
    public void delete(Professor professor) {
        String sql = "DELETE FROM professor WHERE idProfessor = ?";

        Connection con = null;

        PreparedStatement statement = null;
        try {
            con = Conection.getConnection();
            statement = con.prepareStatement(sql);
            Conection.getConnection();
            statement.setInt(1, Professor.getIdprofessor());
            statement.execute();
        } catch (Exception ex) {
            try {
                throw new SQLException("Erro ao deletar o professor!"+ ex.getMessage(), ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            Conection.closeConnection(con, statement);
        }
    }
}
