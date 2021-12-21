package telegramBot;

import models.BaseModel;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public interface TelegramBotUtils {
    String BOT_USERNAME = "b6=_pdp_bunyod_bot";
    String BOT_TOKEN = "5072405618:AAHJlBcjcg_IwArDErTTpxfVr0x_KcGS1QM";

    static ReplyKeyboardMarkup createReplyKeyboardMarkup(List<String> list) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        for (int i = 1; i <= list.size(); i++) {
            keyboardRow.add(list.get(i - 1));
            if (i % 3 == 0) {
                keyboardRows.add(keyboardRow);
                keyboardRow = new KeyboardRow();
            }
        }
        return replyKeyboardMarkup;
    }

    private InlineKeyboardMarkup createInlineKeyboardMarkup(List<BaseModel> datas) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(list);
        List<InlineKeyboardButton> inlineKeyboardButtons = new ArrayList<>();
        int i = 1;
        for (BaseModel model : datas) {
            InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
            inlineKeyboardButton.setText((model.getName()));
            inlineKeyboardButton.setCallbackData(model.getId().toString());
            inlineKeyboardButtons.add(inlineKeyboardButton);

            if (i % 3 == 0) {
                list.add(inlineKeyboardButtons);
                inlineKeyboardButtons = new ArrayList<>();
            }
            i++;
        }
        list.add(inlineKeyboardButtons);
        return inlineKeyboardMarkup;
    }


}

