package enums.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuKey {
    DELETE_CATEGORY(1),
    BLOCK_CATEGORY(2),
    UNBLOCK_CATEGORY(3),
    SHOW_CATEGORIES(4),
    DELETE_SUBCATEGORY(5),
    BLOCK_SUBCATEGORY(6),
    UNBLOCK_SUBCATEGORY(7),
    SHOW_SUBCATEGORIES(8),
    DELETE_ADMIN(9),
    BLOCK_ADMIN(10),
    UNBLOCK_ADMIN(11),
    CREATE_ADMIN(12),
    CREATE_USER(13),
    DELETE_USER(14),
    BLOCK_USER(15),
    UNBLOCK_USER(16),
    RESET_PASSWORD(17),
    CHANGE_LANGUAGE(18),
    LOGOUT(19),
    LOGIN(20),
    EXIT(21),
    UNDEFINED(22);
    private int code;
    static boolean a = false;

    public static MenuKey findByCode(int menu) {
        if (LOGIN.code == menu) a = true;
        if (a) {
            for (MenuKey menuKey : values()) {
                if (menuKey.getCode() == menu) return menuKey;

            }
        }
        if (EXIT.code == menu)
            return EXIT;
        return UNDEFINED;
    }
}
