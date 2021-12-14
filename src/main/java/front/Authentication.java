package front;


import models.auth.User;
import response.BaseResponse;
import service.CartService;
import service.UserService;
import utils.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Authentication implements BaseResponse{
       static UserService userService = new UserService();
       static CartService cartService = new CartService();
       public static void signUp() {
              User newUser = new User();
              boolean checkNumber = false;
              String phoneNumber;
              do{
                     phoneNumber = Input.getStr("phone number (e.g +998-xx-xxx-xx-xx)");
                     checkNumber = isValid(phoneNumber);
              }while (checkNumber);
              if(userService.checkPhoneNumber(phoneNumber)){
                     System.out.println(ERROR_PHONE_NUMBER_ALREADY_EXISTS);
              }else {
                     System.out.println("Your sms code is " + newUser.getSmsCode());
                     System.out.println("Don't show anyone!");
                     int smsCode;
                     do{
                            smsCode = Input.getNum("Code");
                     }while(smsCode == newUser.getSmsCode());

                     newUser.setName(Input.getStr("Enter name : "));
                     newUser.setPassword(Input.getStr("Enter password:"));
                     cartService.add(new Cart(newUser.getId()));
                     System.out.println(userService.add(newUser));
              }
       }

       private static boolean isValid(String phoneNumber) {
              Pattern phone = Pattern.compile("^\\d{9}$");
              Matcher number = phone.matcher(phoneNumber);
              return (number.matches());
       }

       public static User signIn(){
              String userName = Input.getStr("User Name");
              String password = Input.getStr("Password: ");
              return userService.logIn(userName, password);
       }
}



