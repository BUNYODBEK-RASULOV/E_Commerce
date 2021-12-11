package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Order extends BaseModel{
    private UUID cartID;
    private UUID productID;
    private BigDecimal amount;
    private LocalDate date;

}
