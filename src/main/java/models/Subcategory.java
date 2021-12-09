package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Subcategory {
        private UUID productId;
        private UUID categoryId;
        private UUID subcategoryId;


        {
            this.categoryId=UUID.randomUUID();
        }
    }


