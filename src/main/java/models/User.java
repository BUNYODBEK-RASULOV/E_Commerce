package models;


import lombok.Data;

@Data
public class User extends BaseModel {
    private String phoneNumber;
    private String password;
    private String smsCode;
}
