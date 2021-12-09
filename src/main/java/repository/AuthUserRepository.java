package repository;

import enums.internationalization.Language;
import models.auth.AutUser;
import models.auth.User;

import java.util.ArrayList;
import java.util.List;

public interface AuthUserRepository extends BaseRepository<AutUser,String, List<AutUser>>{

    List<AutUser> autUserList=new ArrayList<>();
    void changeLanguage(Language language);
    AutUser findByPhoneNumber(String phoneNumber);
}
