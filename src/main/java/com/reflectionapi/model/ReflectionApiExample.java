package com.reflectionapi.model;

import java.lang.reflect.*;

public class ReflectionApiExample {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        User user = new User(25L, "Ivan", 30);
        int age = user.getClass().getDeclaredField("age").getAnnotation(MinAge.class).age();
        System.out.println(age);// 21 - это значение аннотейшена, возраст юзера остается заданным
        System.out.println(user);
        System.out.println();
        Class<? extends User> userClass = user.getClass();
        var userClass1 = User.class;
//        System.out.println(userClass == userClass1);
//        userClass.getSuperclass().getDeclaredFields();// Получить класс-родитель и его поля
//        userClass.getModifiers();// Получить модификаторы доступа
//        userClass.getMethods();// Получить все методы, в т.ч. унаследованные
//        userClass.getConstructors();// Получить все конструкторы
//        userClass.getDeclaredMethods();// Получить только методы в этом классе
//        userClass.getInterfaces();// Получить реализованные интерфейсы

        testConstructor();
        System.out.println();
        testFields(user);
        System.out.println();
        testMethods(user);

    }

    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = User.class.getConstructor(Long.class, String.class, Integer.class);// get the Constructor object by class and parameters
        User user1 = constructor.newInstance(5L, "Petro", 44);// Using this constructor we can create a new instance of that class
        System.out.println(user1);
    }

    private static void testFields(User user) throws IllegalAccessException {
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);// Makes private fields accessible
            Object value = declaredField.get(user);// get the value of a field by class instance
//            declaredField.set(user, "value");// also we can set the value of some field
            System.out.print(declaredField.getName() + ": " + value);
            System.out.println("; private field: " + Modifier.isPrivate(declaredField.getModifiers()));// Check if this fields is private
        }
    }

    private static void testMethods(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = user.getClass().getDeclaredMethod("setName", String.class);// Get method by its name and parameter types (if any)
        method.invoke(user, "Nick");// Calls the method based on class instance and method args (if any)
        System.out.println(user);
    }
}
