package service.interfaces;

import dto.UserDTO;

public interface AuthService {

    UserDTO addUser(UserDTO req);
    UserDTO validUser(UserDTO req);
    
}
