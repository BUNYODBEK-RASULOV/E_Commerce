package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product extends BaseModel {
    private UUID adminID;
    private BigDecimal price;
    private String infoProduct;
    private UUID discountID; //chegirma % larda (defolt xolda 0 foiz)


}
