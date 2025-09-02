package com.horadrim.staff.features.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ReflectionTest {
    @Test
    public void testGetClazz() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.horadrim.staff.features.java.reflection.TestClazz");
        TestClazz t = (TestClazz) clazz.getDeclaredConstructor().newInstance();
    }

    @Test
    public void testGetMethod() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.horadrim.staff.features.java.reflection.TestClazz");
        TestClazz t = (TestClazz) clazz.getDeclaredConstructor().newInstance();
        Method m = clazz.getDeclaredMethod("testMethod", int.class);
        m.invoke(t, 11);
    }

    @Test
    public void testGetAnnotations() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.horadrim.staff.features.java.reflection.TestClazz");
        Annotation[] annos = clazz.getAnnotations();
        Assertions.assertEquals(1, annos.length);
    }
}
