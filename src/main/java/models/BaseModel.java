package models;

import java.time.LocalDate;
import java.util.UUID;

public abstract class BaseModel {
    protected UUID id;
    protected LocalDate createDate;
    protected LocalDate updateDate;
    protected LocalDate deleteDate;
    protected boolean isActivite;
}
