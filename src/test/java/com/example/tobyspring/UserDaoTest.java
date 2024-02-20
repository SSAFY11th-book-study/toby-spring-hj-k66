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
        User user2 = new User("h2", "김희정2", "pass");

        userDao.add(user);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        User finded = userDao.get(user.getId());
        assertThat(finded.getName()).isEqualTo(user.getName());
        User finded2 = userDao.get(user2.getId());
        assertThat(finded2.getName()).isEqualTo(user2.getName());
    }

    @Test
    void getCount() throws SQLException{
        User user1 = new User("h1", "김희정", "1234");
        User user2 = new User("h2", "김희정2", "pass");
        User user3 = new User("h3", "김희정3", "word");

        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }
}
