package com.example.tobyspring;


import static org.assertj.core.api.Assertions.assertThat;

import com.example.tobyspring.dao.DaoFactory;
import com.example.tobyspring.dao.UserDao;
import com.example.tobyspring.domain.User;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

public class UserDaoTest {
    private final UserDao userDao = new DaoFactory().userDao();
    @Test
    void findById() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setId("hihi");
        user.setName("김희정");
        user.setPassword("1234");
        userDao.add(user);

        User finded = userDao.get("hihi");

        assertThat(finded.getId()).isEqualTo(user.getId());
    }
}
