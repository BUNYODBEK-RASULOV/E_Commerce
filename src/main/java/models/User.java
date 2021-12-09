package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User extends BaseModel {
    private String phoneNumber;
    private String password;
    private String smsCode;
}