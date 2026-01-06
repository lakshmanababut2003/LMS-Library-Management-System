package service;

import dto.UserDTO;
import model.User;
import repo.RepoInterface;
import repo.UserRepo;
import service.exception.InvalidException;
import service.interfaces.AuthService;

public class AuthServiceImp  implements AuthService{

    private final RepoInterface<User> repo;
    private static int idCounter = 2;

    public AuthServiceImp(){
        repo = UserRepo.getUserRepo();
    }

    @Override
    public UserDTO addUser(UserDTO req){

        if(req.getUserName().isEmpty() || req.getPhone().isEmpty() || req.getAccessId().isEmpty()){
            
            throw new InvalidException("Invalid Inputs...(Please check");
        }

        User user = repo.add(new User(
            idCounter++, 
            req.getUserName(), 
            req.getAccessId(),
            req.getPhone() ,
             req.getRole()
            )
        );


        return sendRes(user);
    }

    @Override
    public UserDTO validUser(UserDTO req){

        if(!repo.getAll().isEmpty()){
            for(User user : repo.getAll()){

                if(user.getUserName().equals(req.getUserName()) && user.checkValidId(req.getAccessId())){
                    return sendRes(user);
                }
            }
        }

        throw new InvalidException("Invalid Username and AccessId...");
        
    }

    private UserDTO sendRes(User user){

        return new UserDTO(
            user.getId(), 
            user.getUserName(), 
            user.getPhone(), 
            user.getRole(), 
        user.getStatus());
    }
    
}
