package enums.internationalization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@RequiredArgsConstructor
public enum Language {
    UZ("Uzbek"),
    RU("Russian"),
    EN("English");
    private final String code;

    public static List<String> getAll() {
        List<String> list=new ArrayList<>();
        for (Language code : values()) {
            list.add(code.getCode());
        }
        return list;
    }

    public static Language findByCode(String code) {
        for (Language language : values()) {
            if (language.getCode().equalsIgnoreCase(code))
                return language;
        }
        return null;
    }

    @Override
    public String toString() {
        return code ;
    }
}