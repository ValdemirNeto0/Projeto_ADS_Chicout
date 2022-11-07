public class professor {
    private String NomeProfessor, EmailProf, Enderecoprof, idProfessor;
    private int IdadeProf,Telefoneprof;


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

    public String getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(String idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdadeProf() {
        return IdadeProf;
    }

    public void setIdadeProf(int idadeProf) {
        IdadeProf = idadeProf;
    }

    public int getTelefoneprof() {
        return Telefoneprof;
    }

    public void setTelefoneprof(int telefoneprof) {
        Telefoneprof = telefoneprof;
    }

    public professor(String nomeProfessor, String emailProf, String enderecoprof, String idProfessor, int idadeProf, int telefoneprof) {
        NomeProfessor = nomeProfessor;
        EmailProf = emailProf;
        Enderecoprof = enderecoprof;
        this.idProfessor = idProfessor;
        IdadeProf = idadeProf;
        Telefoneprof = telefoneprof;
    }
}
