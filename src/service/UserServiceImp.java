package service;

import java.util.*;

import dto.UserDTO;
import model.User;
import repo.RepoInterface;
import repo.UserRepo;
import service.exception.InvalidException;
import service.interfaces.UserService;
import service.interfaces.ViewService;

public class UserServiceImp implements ViewService<UserDTO> , UserService{

    private final RepoInterface<User> repo;


    public UserServiceImp(){
        repo = UserRepo.getUserRepo();
    }

    @Override
    public List<UserDTO> viewAll(){

        List<UserDTO> users = new ArrayList<>();

        if(repo.getAll().isEmpty()){
            return null;
        }

        for(User user : repo.getAll()){
            users.add(sendRes(user));
        }

        return users;


    }

    @Override
    public User getIdByUserName(String userName){

        for(User user : repo.getAll()){

            if(user.getUserName().equals(userName)){
                return user;
            }
        }

        throw new InvalidException("The UserName doesnot exists");
    }

    @Override
    public String getUserNameById(int id){
        return repo.getById(id).getUserName();
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
