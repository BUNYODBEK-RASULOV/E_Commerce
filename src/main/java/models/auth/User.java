package models.auth;


import enums.auth.Role;
import enums.internationalization.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User extends AutUser {

    private int smsCode;

    public User(String name, String phoneNumber, String password, Role role, Language lan) {
        super(name, phoneNumber, password, role, lan);
    }

    {
        this.smsCode = Math.abs((int) System.currentTimeMillis() % 100000);
        role = Role.User;
    }
}
