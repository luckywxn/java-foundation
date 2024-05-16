import java.lang.reflect.Method;

public class Reflection_Test {
    public static void main(String[] args) throws Exception {

        String string = "Hello, World!";
        System.out.println("Length of string: " + string.length());

        // 获取String类的Class对象
        Class<?> stringClass = string.getClass();

        // 使用反射创建String对象
//        Object instance = stringClass.newInstance();

        // 获取String类中的length()方法
        Method lengthMethod = stringClass.getMethod("length");

        // 调用length()方法
        int length = (int) lengthMethod.invoke(string);
        System.out.println("Length of empty string: " + length);

        // 获取和调用concat方法
        Method concatMethod = stringClass.getMethod("concat", String.class);
        String concatenated = (String) concatMethod.invoke(string, " Example");
        System.out.println("Concatenated string: " + concatenated);
    }
}
