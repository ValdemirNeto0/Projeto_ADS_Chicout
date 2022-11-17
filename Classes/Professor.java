package br.edu.uniaeso.classes;
public class Professor {
    private String NomeProfessor, EmailProf, Enderecoprof,Telefoneprof;
    private int IdadeProf, idProfessor;

    public Professor(String nomeProfessor, String emailProf, String enderecoprof, int idProfessor, int idadeProf, String telefoneprof) {
        NomeProfessor = nomeProfessor;
        EmailProf = emailProf;
        Enderecoprof = enderecoprof;
        this.idProfessor = idProfessor;
        IdadeProf = idadeProf;
        Telefoneprof = telefoneprof;
    }

    public String getNomeProfessor() {
        return NomeProfessor;
    }
    public void setNomeProfessor(String nomeProfessor) {
        NomeProfessor = nomeProfessor;
    }
    public String getEmailProf() {
        return EmailProf;
    }
    public void setEmailProf(String emailProf) {
        EmailProf = emailProf;
    }
    public String getEnderecoprof() {
        return Enderecoprof;
    }
    public void setEnderecoprof(String enderecoprof) {
        Enderecoprof = enderecoprof;
    }
    public int getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    public int getIdadeProf() {
        return IdadeProf;
    }
    public void setIdadeProf(int idadeProf) {
        IdadeProf = idadeProf;
    }
    public String getTelefoneprof() {
        return Telefoneprof;
    }
    public void setTelefoneprof(String telefoneprof) {
        Telefoneprof = telefoneprof;
    }
}
