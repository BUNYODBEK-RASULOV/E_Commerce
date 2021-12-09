package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Brand extends BaseModel {
    private String brandName;
    private String brand;
    private String infoProduct;

}
