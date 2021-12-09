package enums.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE(0),
    NOT_ACTIVE(-1),
    TEMP_BLOCKED(-10),
    PERM_BLOCKED(-50),
    DELETED(-100);
    private final int code;
}
