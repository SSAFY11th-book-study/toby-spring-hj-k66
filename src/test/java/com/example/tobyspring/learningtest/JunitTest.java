package com.example.tobyspring.learningtest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class JunitTest {
    static Set<JunitTest> testObjects = new HashSet<>();

    @Test
    void test1(){
        assertThat(testObjects, not(hasItems(this)));
        testObjects.add(this);
    }

    @Test
    void test2(){
        assertThat(testObjects, not(hasItems(this)));
        testObjects.add(this);
    }
    @Test
    void test3(){
        assertThat(testObjects, not(hasItems(this)));
        testObjects.add(this);
    }

}
