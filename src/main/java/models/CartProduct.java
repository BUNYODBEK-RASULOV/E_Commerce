package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProduct {
       private UUID userID;
       private UUID productID;
       private double amount;
       private LocalDate localDate;


}
