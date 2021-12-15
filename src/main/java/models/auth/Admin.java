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

public class Admin extends AutUser {

    private boolean createProductIsActivity;
    private boolean createCategoryIsActivity;
    private boolean deleteProductIsActivity;

    {
        role = Role.ADMIN;
    }

    public Admin(String name, String phoneNumber, String password, Role role, Language lan) {
        super(name, phoneNumber, password, role, lan);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
