package models.auth;


import enums.auth.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User extends AutUser {

    private int smsCode;


    {
        this.smsCode = (int)System.currentTimeMillis() % 10000;
        role = Role.User;
    }
}
