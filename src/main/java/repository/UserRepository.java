package repository;

import models.auth.User;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository extends BaseRepository<User, String, List<User>> {


       List<User> userList=new ArrayList<>();
       boolean checkPhoneNumber(String phoneNumber);
       User logIn(String phoneNumber,String password);
       boolean isAdmin(User user);
}