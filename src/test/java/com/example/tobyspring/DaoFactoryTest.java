package com.example.tobyspring;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.example.tobyspring.dao.DaoFactory;
import com.example.tobyspring.dao.UserDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DaoFactoryTest {

    @Test
    @DisplayName("빈 등록 확인")
    void name(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        assertDoesNotThrow(()->context.getBean("userDao", UserDao.class));
    }

    @Test
    @DisplayName("new로 생성한 오브젝트는 동일하지 않다.")
    void createObjectByNew(){
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao1 = daoFactory.userDao();
        UserDao userDao2 = daoFactory.userDao();


        assertNotEquals(userDao1, userDao2);
    }

    @Test
    @DisplayName("bean으로 등록한 오브젝트는 동일하다.")
    void createObjectByBean(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao1 = applicationContext.getBean("userDao", UserDao.class);
        UserDao userDao2 = applicationContext.getBean("userDao", UserDao.class);

        assertEquals(userDao1, userDao2);
    }

}
