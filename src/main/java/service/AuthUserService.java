package service;

import enums.auth.Role;
import enums.internationalization.Language;
import models.auth.Admin;
import models.auth.AutUser;

import models.auth.User;
import repository.AuthUserRepository;


import java.util.List;
import java.util.UUID;

public class AuthUserService implements AuthUserRepository {

    {
        Admin admin = new Admin("Lord", "997098166","7272", Role.SUPER_ADMIN, Language.EN);
        admin.setRole(Role.SUPER_ADMIN);
        add(admin);
    }


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
    public boolean removeByObj(AutUser autUser) {
        return false;
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
    public String add(AutUser user) {
        if (!checkPhoneNumber(user.getPhoneNumber())){
            autUserList.add(user);
            return SUCCESS;
        }
        return ERROR_USER_ALREADY_EXISTS;
    }

    @Override
    public AutUser getById(UUID id) {
        for (AutUser user: autUserList) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<AutUser> getList() {
        return autUserList;
    }

    @Override
    public boolean edit(UUID id, AutUser user) {
        for (int i = 0; i < autUserList.size(); i++) {
            if (autUserList.get(i).getId().equals(id)){
                autUserList.set(i, user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeById(UUID id) {
        for (int i = 0; i < autUserList.size(); i++) {
            if (autUserList.get(i).getId().equals(id)){
                autUserList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeByObj(User user) {
        return autUserList.remove(user);
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        if (autUserList == null || autUserList.size() == 0) return false;
        for (AutUser user: autUserList) {
            if (user.getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }



    @Override
    public AutUser logIn(String phoneNumber, String password) {
        for (AutUser user : autUserList) {
            if (user.getPhoneNumber().equals(phoneNumber) &&
                    user.getPassword().equals(password))
                return user;
        }
        return null;
    }



    public AutUser getUserByPhoneNumber(String phoneNumber) {
        for (AutUser user : autUserList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    static public AutUser getUserByID(UUID id) {
        for (AutUser user: autUserList) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }

}
