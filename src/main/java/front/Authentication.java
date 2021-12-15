package front;


import enums.auth.Role;
import enums.internationalization.Language;
import models.auth.Admin;
import models.auth.AutUser;
import models.auth.User;
import response.BaseResponse;
import service.AuthUserService;
import service.CartService;
import service.UserService;
import utils.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Authentication implements BaseResponse{

       static UserService userService = new UserService();
       static CartService cartService = new CartService();
       static AuthUserService authUserService = new AuthUserService();

       public static void signUp() {

              User newUser = new User();
              boolean checkNumber;
              String phoneNumber;
              do{
                     phoneNumber = Input.getStr("phone number (e.g +998-xx-xxx-xx-xx)");
                     checkNumber = isValid(phoneNumber);
              }while (checkNumber);
              newUser.setPhoneNumber(phoneNumber);
              if(userService.checkPhoneNumber(phoneNumber)){
                     System.out.println(ERROR_PHONE_NUMBER_ALREADY_EXISTS);
              }else {
                     System.out.println("Your sms code is " + newUser.getSmsCode());
                     System.out.println("Don't show anyone!");
                     int smsCode;
                     do{
                            smsCode = Input.getNum("Code: ");
                     }while(smsCode != newUser.getSmsCode());

                     newUser.setName(Input.getStr("Enter name : "));
                     newUser.setPassword(Input.getStr("Enter password:"));
                     System.out.println(authUserService.add(newUser));
              }
       }

       private static boolean isValid(String phoneNumber) {
              Pattern phone = Pattern.compile("^\\d{8}$");
              Matcher number = phone.matcher(phoneNumber);
              return (number.matches());
       }

       public static AutUser signIn(){
              String userName = Input.getStr("Phone Number:");
              String password = Input.getStr("Password: ");
              return authUserService.logIn(userName, password);
       }
}



