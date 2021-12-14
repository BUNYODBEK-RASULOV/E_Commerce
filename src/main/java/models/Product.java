    package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product extends BaseModel {

    private UUID createdById;
    private double price;
    private String productInfo;
    private Brand brand;
    private UUID discountID;

}
