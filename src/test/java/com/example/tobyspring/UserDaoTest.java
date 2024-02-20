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
    void addAndGet() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        User user = new User();
        user.setId("hihi");
        user.setName("김희정");
        user.setPassword("1234");

        userDao.add(user);
        assertThat(userDao.getCount()).isEqualTo(1);

        User finded = userDao.get("hihi");
        assertThat(finded.getId()).isEqualTo(user.getId());
    }
}
