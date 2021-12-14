package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
       private String location;
       private String comment;
       private UUID productID;
       private UUID userID;
       private double amount;

}
