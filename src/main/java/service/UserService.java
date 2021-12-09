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
        return null;
    }

    @Override
    public User getById(UUID id) {
        return null;
    }

    @Override
    public List<User> getList() {
        return null;
    }

    @Override
    public boolean edit(UUID id, User user) {
        return false;
    }

    @Override
    public boolean removeById(UUID id) {
        return false;
    }

    @Override
    public boolean removeByObj(User user) {
        return false;
    }

    @Override
    public boolean checkPhoneNumber(String phoneNumber) {
        return false;
    }

    @Override
    public User logIn(String phoneNumber, String password) {
        return null;
    }

    @Override
    public boolean isAdmin(User user) {
        return false;
    }
}