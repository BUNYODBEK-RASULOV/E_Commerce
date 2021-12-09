package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Discount extends BaseModel {
    private LocalDate starDate;
    private LocalDate endDate;
    private double discount;

}
