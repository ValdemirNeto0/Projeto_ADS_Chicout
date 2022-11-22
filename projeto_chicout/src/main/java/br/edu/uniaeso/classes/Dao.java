package br.edu.uniaeso.classes;

import java.util.List;
import java.util.Optional;

public interface Dao<T>{
    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] parametro);
    void delete(T t);
}
