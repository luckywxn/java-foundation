public class String_Test {
    public static void main(String[] args){
        String str = "Hello World";
        String str2 = "Hello World";
        /**
         * 这里的两个字符串是直接量，Java 编译器会优化它们，使它们在内存中只存储一次
         */
        System.out.println(str == str2);
        String str3 = new String("Hello World");
        /**
         * 使用new关键字来创建字符串时,JVM会先使用常量池来管理字符串直接量,再调用String类的构造器来创建一个新的String对象,
         * 新创建的String对象会被保存在堆内存中。对比来说,采用new的方式会多创建出一个对象来,占用了更多的内存 ,
         * 所以建议采用直接量的方式来创建字符串。
         */
        System.out.println(str == str3);
        System.out.println(str.equals(str3));

    }
}
