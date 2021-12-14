package service;

import enums.internationalization.Language;
import models.auth.AutUser;

import repository.AuthUserRepository;


import java.util.List;
import java.util.UUID;

public class AuthUserService implements AuthUserRepository {

    @Override
    public  void changeLanguage(Language language) {
        for (AutUser autUser : autUserList) {
//            if (user.getId().equals(session.getId())) {
//                user.setLanguage(language);
//                session.setLanguage(language);
//            }
        }
    }

    @Override
    public  AutUser findByPhoneNumber(String phoneNumber) {
        for (AutUser autUser : autUserList) {
            if (autUser.getPhoneNumber().equals(phoneNumber))
                return autUser;
        }
        return null;
    }

    public boolean login() {
        return true;
    }


    @Override
    public String add(AutUser autUser) {
        return null;
    }

    @Override
    public AutUser getById(UUID id) {
        return null;
    }

    @Override
    public List<AutUser> getList() {
        return null;
    }

    @Override
    public boolean edit(UUID id, AutUser autUser) {
        return false;
    }

    @Override
    public boolean removeById(UUID id) {
        return false;
    }

    @Override
    public boolean removeByObj(AutUser autUser) {
        return false;
    }
}
