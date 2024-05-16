import entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection_Test2 {
    public static void main(String[] args) throws Exception {
//        Class<?> clazz = Class.forName("entity.User");
        Class<?> clazz = User.class;
        Method method = clazz.getMethod("setId",Long.class);
        Object obj = clazz.newInstance();
        method.invoke(obj, 1L);

        Method getId = clazz.getMethod("getId");
        System.out.println(getId.invoke(obj));

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj,"张三");
        System.out.println(name.get(obj));

    }
}
