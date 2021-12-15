package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category extends BaseModel{
    private String info;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                ", Activity=" + Activity +
                ", info='" + info + '\'' +
                '}';
    }
}