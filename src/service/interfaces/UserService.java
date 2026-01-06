package service.interfaces;

import model.User;

public interface UserService {

    User getIdByUserName(String userName);
    String getUserNameById(int id);
    
}
