package enums.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    SUPER_ADMIN(100),
    ADMIN(50),
    User(0),
    ANONYMOUS(-1);
    private final int order;

    public boolean in(Role... roles) {
        for (Role role : roles)
            if (this.equals(role)) return true;
        return false;
    }

    public boolean notIn(Role... roles) {
        return !in(roles);
    }

}
