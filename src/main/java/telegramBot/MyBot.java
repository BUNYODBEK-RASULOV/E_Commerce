package telegramBot;

import enums.internationalization.Language;
import enums.internationalization.Message;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MyBot extends TelegramLongPollingBot implements TelegramBotUtils {

    public static Language lan = Language.UZ;
    public static String chatId;


    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {

        }
    }

    private void messageStages(String text) {
        BotState botState = BotState.findByCode(text, lan);
        switch (botState) {
            case START: {
                sendMessage("Tilni tanlang:",
                        TelegramBotUtils.createReplyKeyboardMarkup(Language.getAll()),
                        null);
            }
            break;
            case ENG:
            case RUS:
            case UZB: {
                lan=Language.findByCode(text);
                sendMessage(Message.CHOOSE.get(lan),
                        TelegramBotUtils.createReplyKeyboardMarkup(new ArrayList<String>(Arrays.asList(Message.SIGN_IN.get(lan),Message.SIGN_IN.get(lan)))),
                        null);
            }
            break;
            case SIN_IN: {

            }
            break;
            case SIN_UP: {
            }
            break;
            case DISCOUNT: {
            }
            break;
            case CATEGORY: {
            }
            break;
            case MY_CART: {
            }
            break;
        }
    }


    private void sendMessage(String text, ReplyKeyboardMarkup replyKeyboardMarkup, InlineKeyboardMarkup inlineKeyboardMarkup) {
        SendMessage sendMessage = new SendMessage(chatId, text);
        if (replyKeyboardMarkup != null) {
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        if (inlineKeyboardMarkup != null) {
            sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendPhoto(String url, String text, InlineKeyboardMarkup inlineKeyboardMarkup) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(this.chatId);
        sendPhoto.setPhoto(new InputFile(new File(url)));
        sendPhoto.setCaption(text);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}

