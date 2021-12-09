package enums.internationalization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum Language {
    UZ("Uzbek"),
    RU("Russian"),
    EN("English");
    private final String code;

    public static void showAll() {
        for (Language code : values()) {
            System.out.println(code);
        }
    }

    public static Language findByCode(String code) {
        for (Language language : values()) {
            if (language.name().equalsIgnoreCase(code))
                return language;
        }
        return null;
    }

    @Override
    public String toString() {
        return code + " -> " + name();
    }
}
