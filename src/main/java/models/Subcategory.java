package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Subcategory {
        private UUID catId;
        private String name;
    }


