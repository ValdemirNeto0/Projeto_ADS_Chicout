package br.edu.uniaeso.classes;
public class Turma {
    private int idTurma, qTdAlunos;
    private String turmaNome;

    public Turma(String turmaNome, int qTdAlunos, int idTurma) {
        setturmaNome(turmaNome);
        setIdTurma(idTurma);
        setqTdAlunos(qTdAlunos);
    }
    
    public int getqTdAlunos() {
        return qTdAlunos;
    }
    public String getturmaNome() {
        return turmaNome;
    }
    public void setqTdAlunos(int qTdAlunos) {
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
