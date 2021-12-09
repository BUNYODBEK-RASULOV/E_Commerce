package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product extends BaseModel {
    private UUID createdById;
    private UUID brandId;
    private double price;
    private String infoProduct;
    private UUID discount;


}
