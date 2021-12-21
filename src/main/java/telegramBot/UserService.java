package telegramBot;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User>users=new ArrayList<>();
    public static void add(String number, String password){
        User user=new User();
        user.setNumber(number);
        user.setPassword(password);
        users.add(user);
    }
}
