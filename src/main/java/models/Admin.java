package models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Admin extends BaseModel {
    private String username;
    private String password;
    private boolean createProductIsActivity;
    private boolean createCategoryIsActivity;
    private boolean deleteProductIsActivity;
}
