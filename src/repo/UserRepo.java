package repo;

import java.util.*;

import model.User;

public class UserRepo implements RepoInterface<User> {

    private static UserRepo instance;

    private UserRepo(){
        this.loadData();
    }

    public static UserRepo getUserRepo(){

        if(instance == null){
            instance = new UserRepo();
        }

        return instance;
    }

    private Map<Integer , User> users = new HashMap<>();

    private void loadData(){
        users.put(1, new User(1, "admin", "admin123", "8870865204", "ADMIN") );
    }

    @Override
    public User add(User user){
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public User update(User user){
        return this.update(user);
    }   

    @Override
    public List<User> getAll(){
        return new ArrayList<>(users.values());
    }

    @Override
    public User getById(int id){
        return users.get(id);
    }
    
}
