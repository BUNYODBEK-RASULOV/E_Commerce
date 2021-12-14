package front;

import enums.internationalization.Language;
import service.AuthUserService;
import utils.Input;

public class AutFront {


       public static AuthUserService authUserService = new AuthUserService();

       public static void resetLanguage() {
              Language.showAll();
              String langCode = Input.getStr("?:");
              Language language = Language.findByCode(langCode);
              authUserService.changeLanguage(language);
       }

       public static void resetPassword() {

       }

       public static void exit() {

       }

       public static void logout() {
//        App.run();
       }

       public static void login() {
              String username = Input.getStr("username : ");
              String password = Input.getStr("password : ");

       }
}
