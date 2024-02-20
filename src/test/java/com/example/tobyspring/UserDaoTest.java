package com.example.tobyspring;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.tobyspring.dao.DaoFactory;
import com.example.tobyspring.dao.UserDao;
import com.example.tobyspring.domain.User;
import java.sql.SQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;

public class UserDaoTest {

    private final UserDao userDao = new DaoFactory().userDao();
    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    void setUp(){
        user1 = new User("h1", "김희정", "1234");
        user2 = new User("h2", "김희정2", "pass");
        user3 = new User("h3", "김희정3", "word");

    }

    // Junit 5부터는 접근제한자가 Default 여도 된다. (JUnit4 까지는 public이어야 했링)
    @Test
    void addAndGet() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        User finded = userDao.get(user1.getId());
        assertThat(finded.getName()).isEqualTo(user1.getName());
        User finded2 = userDao.get(user2.getId());
        assertThat(finded2.getName()).isEqualTo(user2.getName());
    }

    @Test
    void getCount() throws SQLException {
        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }

    //    @Test(expected= EmptyResultDataAccessException.class)
    /*
    Junit5부터 @Test annotation expected 속성을 사용하여 예외 값 지정 불가능.
    assertThrows메서드를 사용하여 예상되는 예외의 유형과 람다 식을 통해 테스트 중인 코드를 전달할 수 있는 실행 가능한 기능 인터페이스를 사용.
     */
    @Test
    void getUserFail() throws SQLException {
        userDao.deleteAll();
        assertThrows(EmptyResultDataAccessException.class, () -> userDao.get("fail_id"));
    }
}
