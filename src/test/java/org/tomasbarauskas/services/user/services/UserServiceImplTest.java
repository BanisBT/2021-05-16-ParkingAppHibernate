package org.tomasbarauskas.services.user.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.tomasbarauskas.entities.user.User;
import org.tomasbarauskas.utilities.HibernateConfiguration;

class UserServiceImplTest {

    private final UserService userService = new UserServiceImpl();
    private final User testUser = User.builder()
            .userId("Test")
            .password("Test")
            .name("TestName")
            .surname("TestSurname")
            .build();

    @BeforeAll
    static void beforeAll() {
        HibernateConfiguration.buildSessionFactory();
    }

    @AfterAll
    static void afterAll() {
        HibernateConfiguration.closeSessionFactory();
    }

    @Test
    void saveOrUpdate() {
        userService.saveOrUpdate(testUser);

        Assertions.assertEquals(testUser.getId(), userService.getUserById(testUser.getId()).getId());
        Assertions.assertEquals(testUser.getId(), userService.getUserByUserId(testUser.getUserId()).getId());

        userService.deleteUser(testUser);
    }

    @Test
    void getUserById() {
        userService.saveOrUpdate(testUser);

        Assertions.assertEquals(testUser.getId(), userService.getUserByUserId(testUser.getUserId()).getId());
        Assertions.assertNull(userService.getUserById(99L));

        userService.deleteUser(testUser);
    }

    @Test
    void getUserBuUserId() {
        userService.saveOrUpdate(testUser);

        Assertions.assertEquals(testUser.getUserId(), userService.getUserByUserId(testUser.getUserId()).getUserId());
        Assertions.assertEquals(testUser.getUserId(), userService.getUserById(testUser.getId()).getUserId());

        userService.deleteUser(testUser);
    }
}