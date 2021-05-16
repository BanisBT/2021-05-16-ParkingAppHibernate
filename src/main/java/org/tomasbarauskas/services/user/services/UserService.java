package org.tomasbarauskas.services.user.services;

import org.tomasbarauskas.entities.user.User;

public interface UserService {
    User getUserById(Long id);

    User getUserByUserId(String userId);

    void saveOrUpdate(User user);

    void deleteUser(User user);
}