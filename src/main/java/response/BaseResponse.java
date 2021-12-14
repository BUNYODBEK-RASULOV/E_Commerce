package response;

public interface BaseResponse {
    String ERROR_USER_ALREADY_EXISTS = "\n============ THIS USER ALREADY EXIST ============\n";
    String ERROR_AGE_RESTRICTION = "\n============ YOU SHOULD BE OVER 12 ============\n";
    String ERROR_USER_NOT_FOUND = "\n============ USER NOT FOUND ============\n";
    String ERROR_USER_SIGN_IN_FIRSTLY = "\n============ Firstly you must sign up ";

    String ERROR_PRODUCT_ALREADY_EXISTS = "\n============ THIS PRODUCT ALREADY EXIST ============\n";
    String ERROR_PRODUCT_NOT_FOUND = "\n============ PRODUCT NOT FOUND ============\n";
    String NO_PRODUCTS = "\n============ NO PRODUCTS ============\n";
    String ERROR_CATEGORY_ALREADY_EXIST = "CATEGORY ALREADY EXISTS!";
    String ERROR_PRODUCT_ALREADY_EXIST = "PRODUCT ALREADY EXISTS";
    String ERROR_CATEGORY_IS_NOT_FOUND = "CATEGORY IS NOT FOUND";
    String ERROR_DETAIL_TYPE_NOT_FOUND = "\n============ USER NOT FOUND ============\n";


    String NEW_NOTIFICATION = "\n============ You have new notification ============\n";


    String PRODUCT_NEW_POST = "\n============ New notification in your products ==========\n";






    String NO_REQUESTS = "\n ============= NO REQUESTS ============= \n";
    String ERROR_REQUEST_ALREADY_FOUND = "\n============ REQUEST FOR THIS CARD ALREADY EXIST ============\n";
    String ERROR_REQUEST_NOT_FOUND = "\n============ REQUEST NOT FOUND ============\n";



    String SUCCESS = "\n============ SUCCESSFULLY COMPLETED ============\n\n";
    String WELCOME = "\n\n============ WELCOME ============\n";
    String WRONG_INPUT = "\n============ WRONG INPUT ============\n";


    String MAIN_MENU_ADMIN = "\n\n 1. User \t2. Publication \t3.Group";
    String MENU_ADMIN_USER = "\n\n 1.Block \t2.Active blocked user \t3.User list";
    String MENU_ADMIN_PUBLICATION = "\n\n 1.Block \t2.Active blocked publication \t3.Publication list ";
    String MENU_ADMIN_GROUP = "\n\n 1.Block \t2.Active blocked groups \t3.Group list ";



    String MAIN_MENU_USER = "\n\n 1. Sign in \t2. Sign up";

    String MENU_USER_SIGN_IN = "\n\n 1.Home \t2.Friends \t3.Show publications \t4.Channels \t5. Notifications \t6.Messenger";

    String MENU_HOME = "\n\n 1. Post publication \t2.Requests";

    String MENU_FRIENDS = "\n\n 1. Add friend \t2.All friend";

    String MENU_CHANNELS = "\n\n 1. Create channel \t2. My channels \t3. Post page to channel";

    String MENu_MESSENGER = "\n\n 1. Create group \t2. Search \t3.Send message to group \t4. P2P chat";







    String PREVIOUS = " ========== PREVIOUS ========== ";
    String ERROR_INCORRECT_SMSCODE = "Incorrect sms code. Please, check your phone one more time";
    String ERROR_PHONE_NUMBER_ALREADY_EXISTS = "Phone number is exist";

}
