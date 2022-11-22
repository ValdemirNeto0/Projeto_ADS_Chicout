package br.edu.uniaeso.classes;

public class Disciplina {
    private int id_disciplina;
    private String carga_horaria, nome_disciplina;

    public Disciplina(int id_disciplina, String carga_horaria, String nome_disciplina) {
        this.id_disciplina = id_disciplina;
        this.carga_horaria = carga_horaria;
        this.nome_disciplina = nome_disciplina;
    }
      
    // Get e Set
    public String getCarga_horaria(){
        return carga_horaria;
    }
    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
    public String getNome_disciplina(){
        return nome_disciplina;
    }
    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = carga_horaria;
    }
    public int getId_disciplina(){
        return id_disciplina;
    }
    public void setId_disciplina(int id_disciplina){
        this.id_disciplina = id_disciplina;
    }
}