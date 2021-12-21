package telegramBot;


import enums.internationalization.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor


public enum BotState {
    START("/star"),
    UZB("uz"),
    RUS("ru"),
    ENG("eng"),
    SIN_IN("sign.in", "Sign In", "", ""),
    SIN_UP("sign.up", "Sign Up", "", ""),
    DISCOUNT("discount", "Discount", "", ""),
    CATEGORY("category", "Category", "", ""),
    MY_CART("my.cart", "My Cart", "", ""),
    ;

    BotState(String code) {
        this.code = code;
    }

    private String code;
    private String eng;
    private String ru;
    private String uz;

    public static BotState findByCode(String message, Language lan) {
        for (BotState botState : values()) {
            switch (lan) {
                case EN -> {
                    if (botState.getEng().equals(message)) {
                        return botState;
                    }
                }
                case RU -> {
                    if (botState.getRu().equals(message)) {
                        return botState;
                    }
                }
                case UZ -> {
                    if (botState.getUz().equals(message)) {
                        return botState;
                    }
                }
            }
        }
        return null;
    }

}
