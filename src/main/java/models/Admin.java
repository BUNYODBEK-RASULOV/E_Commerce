package models;


import lombok.Data;

@Data
public class Admin extends BaseModel {
    private String username;
    private String password;
    private boolean createProductIsActivity;
    private boolean createCategoryIsActivity;
    private boolean deleteProductIsActivity;
}
