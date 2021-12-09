package repository;

import models.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User, String, List<User>> {

       boolean checkPhoneNumber(String phoneNumber);
       User logIn(String phoneNumber,String password);
       boolean isAdmin(User user);
}