package enums.internationalization;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {
    //// TODO: 11/24/2021 add localization here
    LOGIN("login", "login", "login", "login"),
    USERNAME("username", "Foydalanuvchi nomi", "Username", "Имя пользователя"),
    PASSWORD("password", "Parol", "Password", "Пароль"),
    USER_NOTFOUND("user.not.found", "Foydalanuvchi topilmadi", "User not found", "Пользователь не найден"),
    ORG_NOTFOUND("Org.not.found", "Organizatsiya topilmadi", "Org not found", "организацию не найден"),
    CREATE_ORGANIZATION("create.organization", "Tashkilot yaratish", "Create organization", "Создать организацию"),
    DELETE_ORGANIZATION("delete.organization", "Tashkilotni o'chirish", "Delete organization", "Удалить организацию"),
    BLOCK_ORGANIZATION("block.organization", "Tashkilotni bloklash", "Block organization", "Заблокировать организацию"),
    UNBLOCK_ORGANIZATION("unblock.organization", "Tashkilotni blokdan chiqarish", "Unblock organization", "Разблокировать организацию"),
    SHOW_ORGANIZATIONS("show.organizations", "Tashkilotlarni ko'rsatish", "Show organizations", "Показать организации"),
    SEE_ALL_BRANCH_LOCATIONS("see.all.branch.locations", "Barcha filiallar joylashuvi", "See all branch locations", "Расположение всех филиалов"),
    DELETE_ADMIN("delete.admin", "Adminni o'chirish", "Delete admin", "Удалить админа"),
    BLOCK_ADMIN("block.admin", "Adminni bloklash", "Block admin", "Заблокировать админа"),
    UNBLOCK_ADMIN("unblock.admin", "Adminni blokdan chiqarish", "Unblock admin", "Разблокировать админа"),
    CREATE_ADMIN("create.admin", "Admin yaratish", "Create admin", "Создать админа"),

    CREATE_BRANCH("create.branch", "Filial yaratish", "Create branch", "Создать филиал"),
    DELETE_BRANCH("delete.branch", "Filialni o'chirish", "Delete branch", "Удалить филиал"),
    BLOCK_BRANCH("block.branch", "Filialni bloklash", "Block branch", ""),
    UNBLOCK_BRANCH("unblock.branch", "Filialni blokdan chiqarish", "Unblock branch", ""),
    SHOW_BRANCHES("show.branches", "Filiallarni ko'rish", "Show branches", "Показать филиалы"),
    SEE_BRANCH_LOCATIONS("see.branch.locations", "Filiallar joylashuvi", "See branch locations", "Расположение филиалов"),
    CREATE_USER("create.user", "Foydalanuvchi yaratish", "Create user", "Создать пользователя"),
    DELETE_USER("delete.user", "Foydalanuvchini oʻchirish", "Delete user", "Удалить пользователя"),
    BLOCK_USER("block.user", "Foydalanuvchini bloklash", "Block user", "Блокировать пользователя"),
    UNBLOCK_USER("unblock.user", "Foydalanuvchini blokdan chiqarish", "Unblock user", "Разблокировать пользователя"),

    SHOW_DRUGS("show.drugs", "Dorilarni ko'rish", "Show drugs", "Показать препараты"),
    ADD_DRUG("add.drug", "Dori qo'shish", "Add drug", "Добавить препарат"),
    SELL_DRUG("sell.drug", "Dori sotish", "Sell drug", "Продать препарат"),
    SEARCH_DRUG("search.drug", "Dori qidirish", "Search drug", "Поиск препарата"),

    RESET_PASSWORD("reset.password", "Parolni o'zgartirish", "Reset password", "Сброс пароля"),
    CHANGE_LANGUAGE("change.language", "Tilni o'zgartirish", "Change language", "Сменить язык"),
    LOGOUT("logout", "Chiqish", "Logout", "Выйти"),
    EXIT("exit", "Chiqish", "Logout", "Выйти"),

    CHOOSE("choose","Tanlang","Choose", "Выбирать"),
    NAME("name","Nomi","Name ","Имя"),
    NAME_ORG("name","Tashkilotni Nomi","Name organization","Имя организацию"),
    NOT_CHOICE("choice","Bunday tanlov mavjud","There is such a choice","Есть такой выбор"),
    SIGN_IN("signIn", "Tizimga kirish","Sign In" , "Войти");

   // LOCALIZATION_NOT_FOUND("LOCALIZATION_NOT_FOUND", "LOCALIZATION_NOT_FOUND", "LOCALIZATION_NOT_FOUND", "LOCALIZATION_NOT_FOUND");
    private final String code;
    private final String uz;
    private final String en;
    private final String ru;
//
//    private static String getByCodeAndLanguage(String code, Language language) {
//        for (Message message : values()) {
//            if (message.getCode().equals(code))
//                return message.get(language);
//        }
//        return LOCALIZATION_NOT_FOUND.ru;
//    }

    public String get(Language language) {
        if (language.name().equals("UZ"))
            return this.uz;
        if (language.name().equals("RU"))
            return this.ru;
        return this.en;
    }
}
