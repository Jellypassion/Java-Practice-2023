package com.reflectionapi.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Indicates the contexts in which an annotation interface is applicable
@Target({ElementType.TYPE,
        ElementType.FIELD
}) // TYPE == Class, interface (including annotation interface), enum, or record declaration
// Указывает, как долго должны сохраняться аннотации с аннотированным интерфейсом.
@Retention(RetentionPolicy.RUNTIME)// when using Reflection API RetentionPolicy should be RUNTIME otherwise we will have no access to it when app is running
public @interface MinAge {
    int age() default 18; // у аннотации будет свойство age, которое если не заполнено будет иметь дефолтное значение
    //int value();// A reserved keyword for annotations. It can be used without default value, but in this case an Annotation should look like @MinAge(18)
}
