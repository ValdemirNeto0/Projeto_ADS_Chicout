package org.example;

// Criando classe
public class Disciplina {
    private String carga_horaria, nome_disciplina, id_disciplina;

    } // Get e Set
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
    public String getId_disciplina(){
        return id_disciplina;
    }
    public void setId_disciplina(String id_disciplina){
        this.id_disciplina = id_disciplina;
    }
    // Construtor com parametros
    public Disciplina(String carga_horaria, String nome_disciplina, String id_disciplina) {
        this.carga_horaria = carga_horaria;
        this.nome_disciplina = nome_disciplina;
        this.id_disciplina = id_disciplina;
    }
}