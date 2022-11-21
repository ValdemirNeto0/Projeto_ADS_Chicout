package br.edu.uniaeso.classes;

public class Aluno {
    private int idAluno,idade;
    private String nome,endereco,email;

    public Aluno(int idAluno, int idade, String nome, String endereco, String email) {
        this.idAluno = idAluno;
        this.idade = idade;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
    }

    //get e setters
    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
