public class Turma {
    private int idTurma, idAluno, idCurso;
    private String turmaNome, qTdAlunos;

    public Turma(String turmaNome, String qTdAlunos, int idTurma) {
        setturmaNome(turmaNome);
        setIdTurma(idTurma);
        setqTdAlunos(qTdAlunos);
    }

    public String getqTdAlunos() {
        return qTdAlunos;
    }

    public String getturmaNome() {
        return turmaNome;
    }

    public void setqTdAlunos(String qTdAlunos) {
        this.qTdAlunos = qTdAlunos;
    }

    public void setturmaNome(String turmaNome) {
        this.turmaNome = turmaNome;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getidAluno() {
        return idAluno;
    }

    public int getidCurso() {
        return idCurso;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}