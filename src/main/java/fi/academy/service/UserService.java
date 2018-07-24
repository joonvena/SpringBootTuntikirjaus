package fi.academy.service;

import fi.academy.model.User;

public interface UserService {

   public User findUserByEmail(String email);

}
