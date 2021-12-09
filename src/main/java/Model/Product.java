package Model;

import lombok.Data;

import java.util.UUID;

@Data
public class Product extends BaseModel {
    private UUID createdById;
    private double price;
    private String infoProduct;
}
