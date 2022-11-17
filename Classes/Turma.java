public class Turma {
    private int idTurma;
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
}
