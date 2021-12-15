import enums.auth.Role;
import front.AdminFront;
import front.SuperAdminFront;
import front.UserFront;
import models.auth.Admin;
import models.auth.AutUser;
import models.auth.User;
import service.AuthUserService;

import utils.Input;
import utils.Print;
import front.Authentication;


public class App {

    public static void main(String[] args) {
        int stepcode=1;
        while(stepcode!=0){
            stepcode= Input.getNum("1.Sign in \t2.Sign up\t 0.Exit");
            switch (stepcode){
                case 1-> {
                    AutUser user = Authentication.signIn();
                    if (user == null){
                        System.out.println("User is not found!");
                    }
                    else{
                        switch (user.getRole()) {

                            case ADMIN:
                                AdminFront.main((Admin) user);
                                System.out.println("welcome to admin");
                                break;
                            case SUPER_ADMIN:
                                SuperAdminFront.main();
                                break;
                            case User:
                                UserFront.main((User) user);
                                break;
                            default:
                                System.out.println("User is not found!");
                                break;
                        }
                        }
                }
                case 2-> Authentication.signUp();
            }
        }

    }
}
