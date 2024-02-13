package com.example.tobyspring;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.tobyspring.dao.CountingConnectionMaker;
import com.example.tobyspring.dao.CountingDaoFactory;
import com.example.tobyspring.dao.UserDao;
import com.example.tobyspring.domain.User;
import java.sql.SQLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CountingDaoFactoryTest {

    @Test
    @DisplayName("연결횟수 카운팅 테스트")
     void UserDaoConnectionCountingTest() throws SQLException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("104");
        user.setName("hee");
        user.setPassword("12345");
        userDao.add(user);

        User user2 = new User();
        user2.setId("105");
        user2.setName("hee");
        user2.setPassword("12345");
        userDao.add(user2);


        CountingConnectionMaker connectionMaker = applicationContext.getBean("connectionMaker", CountingConnectionMaker.class);
        assertThat(connectionMaker.getCounter()).isEqualTo(2);
    }
}
