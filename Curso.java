public class Curso {
    private String Nome;
    private float CargaHoraria;
    private int QtdAlunos, QtdProfessores;

    public Curso(String nome, float cargaHoraria, int qtdAlunos, int qtdProfessores) {
        Nome = nome;
        CargaHoraria = cargaHoraria;
        QtdAlunos = qtdAlunos;
        QtdProfessores = qtdProfessores;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(float cargaHoraria) {
        CargaHoraria = cargaHoraria;
    }

    public int getQtdAlunos() {
        return QtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        QtdAlunos = qtdAlunos;
    }

    public int getQtdProfessores() {
        return QtdProfessores;
    }

    public void setQtdProfessores(int qtdProfessores) {
        QtdProfessores = qtdProfessores;
    }
}
