package dto;


public class UserDTO {

    private int userId;
    private String userName;
    private String status;
    private String role;
    private String accessId;
    private String phone;

    public UserDTO(String userName , String accessId ){
        this.userName = userName;
        this.accessId = accessId;
    }

    public UserDTO( String userName , String accessId , String role ,  String phone){
        this(userName, accessId);
        this.phone = phone;
        this.role = role;
    }

    public UserDTO(int userId , String userName , String phone , String role , String status ){
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.role = role;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public String getAccessId(){
        return accessId;
    }
    
    
}
