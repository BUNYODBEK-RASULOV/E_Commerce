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

    private String name;
    private UUID brandId;
    private UUID createdById;
    private double price;
    private String infoProduct;
    private double discount=0; //chegirma % larda (defolt xolda 0 foiz)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(brandId, product.brandId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, brandId);
    }

}
