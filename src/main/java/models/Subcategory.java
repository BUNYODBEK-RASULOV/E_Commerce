package models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import response.BaseResponse;

import java.util.UUID;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Subcategory extends BaseModel{
        private UUID catId;
        private String name;
    }

//okay
// kurindimi bulli 15 min coffe breakka chiqib kelaylik davom etamiz ok
//boshladik
