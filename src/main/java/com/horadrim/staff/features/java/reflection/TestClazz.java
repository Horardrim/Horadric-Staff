package com.horadrim.staff.features.java.reflection;

@TestAnnotation(tag = "reflection")
public class TestClazz {
    public void testMethod(int parameter) {
        int a = parameter;
        a++;
        parameter++;
        parameter = a;
    }
}
