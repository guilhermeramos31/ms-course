package com.guilhermeramos31.mshrworker.service.assembler;
import java.lang.reflect.Field;
import java.util.Collection;

public class WorkerVerify {
    public static void verify(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object valor = field.get(obj);
            if (valor == null || valor instanceof String && ((String) valor).isEmpty()) {
                throw new NullPointerException("That's field " + field.getName() + " is null");
            }
            if (valor instanceof Collection && ((Collection<?>) valor).isEmpty()) {
                throw new NullPointerException("That's collections field " + field.getName() + " is null");
            }
        }
    }
}
