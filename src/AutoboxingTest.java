import java.util.ArrayList;
import java.util.List;

public class AutoboxingTest {
    public static void main(String[] args){

        /**
         * 自动装箱
         */
        int num = 10; // 基本数据类型
        Integer integer = num; // 自动装箱：编译器隐式地将基本类型int转换为Integer对象

        /**
         * 自动拆箱
         */
        Integer integerValue = 42; // 包装类对象
        int intValue = integerValue; // 自动拆箱：Integer对象转换为基本类型int

        /**
         * 实际应用场景
         */
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10); // 自动装箱：基本类型int值10被转换为Integer对象添加进List
        int firstNumber = numbers.get(0); // 自动拆箱：从List中获取的Integer对象转换为int类型

    }
}
