package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseModel {
    protected UUID id;
    protected String name;
    protected LocalDate createDate;
    protected LocalDate updateDate;
    protected LocalDate deleteDate;
    protected boolean Activity;

    public BaseModel(String name) {
        this.name = name;
    }

    {
        this.id = UUID.randomUUID();
        this.Activity = true;
        this.createDate = LocalDate.now();
    }
}
