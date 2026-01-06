package model;

import model.enums.Role;
import model.enums.Status;

public class User{

    private int id ;
    private String userName;
    private String accessId;
    private String phone;
    private Status status;
    private Role role;

    public User(int id , String userName , String accessId , String phone , String role){

        this.id = id ;
        this.userName = userName;
        this.accessId = accessId;
        this.phone = phone;
        this.status = Status.ACTIVE;
        this.role = Role.valueOf(role);
    }

    public int getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public boolean checkValidId(String accessId){

        if(accessId.equals(this.accessId)){
            return true;
        }

        return false;
    }

    public String getPhone(){
        return phone;
    }


    public void setStatus(Status status){
        this.status = status;
    }

    public String getStatus(){
        return status.name();
    }

    public String getRole(){
        return role.name();
    }
}