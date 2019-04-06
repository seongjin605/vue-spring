package com.naturemobility.kernel.service;

import java.util.List;

import com.naturemobility.kernel.entity.User;

public interface IUserService {
   User getUserById(int userId);

   User getUserByUserName(String userName);

   List<User> getAllUser();

   Boolean addUser(User user);

   Boolean deleteUser(Integer id);

   Boolean updateUser(User user);
}
