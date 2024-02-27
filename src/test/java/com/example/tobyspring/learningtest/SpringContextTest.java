package com.example.tobyspring.learningtest;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class SpringContextTest {
    @Autowired
    private ApplicationContext context;

    private static final Set<SpringContextTest> springContextTests = new HashSet<>();
    private static ApplicationContext contextObject = null;

    @Test
    void test1(){
        assertThat(springContextTests).doesNotHaveSameClassAs(this);
        springContextTests.add(this);

        if(contextObject != null){
            assertThat(contextObject).isEqualTo(this.context);
            contextObject = this.context;
        }
    }

    @Test
    void test2(){
        assertThat(springContextTests).doesNotHaveSameClassAs(this);
        springContextTests.add(this);

        if(contextObject != null){
            assertThat(contextObject).isEqualTo(this.context);
            contextObject = this.context;
        }
    }

    @Test
    void test3(){
        assertThat(springContextTests).doesNotHaveSameClassAs(this);
        springContextTests.add(this);

        if(contextObject != null){
            assertThat(contextObject).isEqualTo(this.context);
            contextObject = this.context;
        }
    }
}
