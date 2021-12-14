package service;

import models.auth.User;
import repository.UserRepository;
import java.util.List;
import java.util.UUID;

public class UserService implements UserRepository {

    {
        User user=new User();
//        user.setUsername("admin");
        user.setPassword("root");
        user.setPhoneNumber("123");
//        userList.add(user);
    }


    @Override
    public String add(User user) {
        if (!checkPhoneNumber(user.getPhoneNumber())){
            userList.add(user);
            return SUCCESS;
        }
        return ERROR_USER_ALREADY_EXISTS;
    }

    @Override
    public User getById(UUID id) {
        for (User user: userList) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getList() {
        return userList;
    }

    @Override
    public boolean edit(UUID id, User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)){
                userList.set(i, user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeById(UUID id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(id)){
                userList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeByObj(User user) {
        return userList.remove(user);
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        if (userList == null || userList.size() == 0) return false;
        for (User user: userList) {
            if (user.getPhoneNumber().equals(phoneNumber)){
                return true;
            }
        }
        return false;
    }



    @Override
    public User logIn(String phoneNumber, String password) {
        for (User user : userList) {
            if (user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password))
                return user;
        }
        return null;
    }

    @Override
    public boolean isAdmin(User user) {
        return false;
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        for (User user : userList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    static public User getUserByID(UUID id) {
        for (User user: userList) {
            if (user.getId().equals(id))
                return user;
        }
        return null;
    }

}