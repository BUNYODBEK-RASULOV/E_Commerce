package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private UUID createdById;
    private double price;
    private String infoProduct;
}
