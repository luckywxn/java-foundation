import entity.Person;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JDK8_Test {
    public static void main(String[] args) {

        /**
         * 1.Lambda表达式
         */
        System.out.println("1.Lambda表达式******************************");
        lambdaTest();

        /**
         * 2.方法引用
         */
        System.out.println("2.方法引用******************************");
        methodReferenceTest();

        /**
         * 3.允许在接口中定义默认方法,默认方法必须使用default修饰。
         */

        /**
         * 4.Stream
         */
        System.out.println("3.Stream******************************");
        streamTest();

        /**
         * 5.Date Time API
         */
        System.out.println("4.Date Time API******************************");
        dateTimeTest();

    }

    public static void lambdaTest(){
        /**
         * 1、函数式接口的简单应用
         */
        List<String> names = Arrays.asList( "Bob", "Alice","Charlie");
        names.forEach(name -> System.out.println(name));

        /**
         * 2、使用条件过滤
         */
        List<Person> persons = Arrays.asList(
                new Person("Alice", 45),
                new Person("Bob", 30),
                new Person("Charlie", 13)
        );
        List<Person> adults = persons.stream()
                                .filter(p -> p.getAge() >= 18)
                                .collect(Collectors.toList());
        adults.forEach(p -> System.out.println(p.getName()));

        /**
         * 3、使用方法引用
         */
        Collections.sort(names, String::compareToIgnoreCase);
        names.forEach(System.out::println);

        /**
         * 4、映射操作
         */
         List<Integer> lengths = names.stream()
                                .map(String::length)
                                .collect(Collectors.toList());
         lengths.forEach(System.out::println);

         /**
         * 5、使用比较器
         */
         Collections.sort(persons, Comparator.comparing(Person::getAge));
        persons.forEach(p -> System.out.println(p.getName()));
    }

    public static void methodReferenceTest(){
        /**
         *1、引用静态方法
         */
        Integer[] intArray = {8, 2, 9, 4, 5};
        Arrays.sort(intArray, Integer::compare);
        /**
         * 2、引用对象的非静态方法
         */
        List<Integer> list = Arrays.asList(intArray);
        list.forEach(System.out::println);
        /**
         * 3、引用类的非静态方法
         */
        Function<String, Integer> toLength = String::length;
        System.out.println(toLength.apply("hello"));

        Consumer<String> printer = System.out::println;
        printer.accept("Hello, world!");

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(7));

        Supplier<String> randomString = () -> "Random String";
        System.out.println(randomString.get());


        /**
         * 4、引用构造方法
         */
        List<StringBuilder> list2 = Stream.of("one", "two", "three")
                .map(StringBuilder::new)
                .collect(Collectors.toList());
        list2.forEach(System.out::println);
    }

    public static void streamTest(){
        /**
         * 1、过滤偶数
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                                      .filter(n -> n % 2 == 0)
                                      .collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);

        /**
         * 2、映射字符串长度
         */
         List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Integer> wordLengths = words.stream()
                                   .map(String::length)
                                   .collect(Collectors.toList());
        wordLengths.forEach(System.out::println);

        /**
         * 3、查找最大值
         */
        List<Person> people = Arrays.asList(
                new Person("Alice", 45),
                new Person("Bob", 30),
                new Person("Dac", 30),
                new Person("Charlie", 13)
        );
        OptionalInt maxAge = people.stream()
                              .mapToInt(Person::getAge)
                              .max();
        if (maxAge.isPresent()) {
            System.out.println("Max age: " + maxAge.getAsInt());
        }

        /**
         * 4、分组
         */
        Map<Integer, List<Person>> personByAge = people.stream()
                                                 .collect(Collectors.groupingBy(Person::getAge));
        personByAge.forEach((age, people1) -> {
            System.out.println("Age: " + age);
            people1.forEach(x-> System.out.println(x.getName()));
        });

        /**
         * 5、聚合计算
         */
         long sum = numbers.stream()
                     .peek(System.out::println) // 可选的中间操作，用于调试
                     .mapToInt(Integer::intValue)
                     .sum();
         System.out.println("Sum: " + sum);
    }

    public static void dateTimeTest(){
        /**
         * 1、获取当前日期和时间
         */
        LocalDate today = LocalDate.now(); // 获取当前日期
        LocalTime now = LocalTime.now();   // 获取当前时间
        LocalDateTime dateTime = LocalDateTime.now(); // 获取当前日期和时间
        System.out.println("Today: " + today);
        System.out.println("Now: " + now);
        System.out.println("Date and Time: " + dateTime);

        /**
         * 2、解析和格式化日期时间
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter); // 格式化日期时间
        LocalDateTime parsedDateTime = LocalDateTime.parse("2023-04-01 15:30:00", formatter); // 解析字符串为日期时间
        System.out.println("Formatted Date and Time: " + formattedDateTime);
        System.out.println("Parsed Date and Time: " + parsedDateTime);

        /**
         * 3、时区处理
         */
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai")); // 获取上海时区的当前日期时间
        Instant instant = zonedDateTime.toInstant(); // 转换为Instant，表示时间戳
        System.out.println("Zoned Date and Time: " + zonedDateTime);
        System.out.println("Instant: " + instant);

        /**
         * 4、计算日期时间差
         */
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 12, 31, 23, 59);
        Duration duration = Duration.between(startDate, endDate); // 计算两个日期时间之间的持续时间

        System.out.println("Duration: " + duration);
        System.out.println("Duration day: " + duration.toDays());

        /**
         * 5、日期调整
         */
        LocalDate nextMonday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 获取下一个星期一的日期
        System.out.println("Next Monday: " + nextMonday);

    }




}
