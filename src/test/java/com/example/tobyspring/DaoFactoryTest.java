package com.example.tobyspring;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.example.tobyspring.dao.DaoFactory;
import com.example.tobyspring.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DaoFactoryTest {

    @Test
    void name(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        assertDoesNotThrow(()->context.getBean("userDao", UserDao.class));
    }
}
