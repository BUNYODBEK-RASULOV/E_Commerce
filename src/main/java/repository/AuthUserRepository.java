package repository;

import enums.internationalization.Language;
import models.auth.AutUser;
import models.auth.User;

import java.util.ArrayList;
import java.util.List;

public interface AuthUserRepository extends BaseRepository<AutUser,String, List<AutUser>>{


    void changeLanguage(Language language);
    AutUser findByPhoneNumber(String phoneNumber);

    boolean removeByObj(User user);

    AutUser logIn(String phoneNumber, String password);
}
