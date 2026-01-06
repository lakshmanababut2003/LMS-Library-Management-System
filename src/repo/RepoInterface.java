package repo;

import java.util.List;

public interface RepoInterface<T> {
    
    T add(T obj);
    List<T> getAll();
    T update(T Obj);
    T getById(int id);
    
}
