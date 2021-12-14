package models.auth;


import enums.auth.Role;
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
}
