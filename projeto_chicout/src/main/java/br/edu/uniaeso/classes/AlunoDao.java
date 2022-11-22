package br.edu.uniaeso.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Objects;

public class AlunoDao implements Dao<Aluno>{
    private List<Aluno> alunos = new ArrayList<>();
    
    public AlunoDao(){
        alunos.add(new Aluno(1,18,"Neto","Rua tal","valderneto@gmail.com"));
        alunos.add(new Aluno(2,25,"Rodrigo","Rua sei la","rodrigo@gmail.com"));
    }

    @Override
    public List<Aluno> getAll(){
        return alunos;
    }
    @Override
    public void save(Aluno aluno){
        alunos.add(aluno);
    }
    @Override
    public void update(Aluno aluno, String[] parametros){
        aluno.setNome(Objects.requireNonNull(parametros[0], "Nome nao pode ser nulo"));
        aluno.setEmail(Objects.requireNonNull(parametros[1], "Email nao pode ser nulo"));

        alunos.add(aluno);
    }
    @Override
    public void delete(Aluno aluno){
        alunos.remove(aluno);
    }

    @Override
    public Optional<Aluno> get(long id) {
        return Optional.empty();
    }
}
