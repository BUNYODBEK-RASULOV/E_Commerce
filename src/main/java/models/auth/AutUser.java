package models.auth;

import enums.auth.Role;
import enums.internationalization.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.BaseModel;


@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class AutUser extends BaseModel {

    protected String phoneNumber;
    protected String password;
    protected Role role;
    protected Language lan;

    public AutUser(String name, String phoneNumber, String password, Role role, Language lan) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.lan = lan;
    }

    {
        role = Role.ANONYMOUS;
    }



}
