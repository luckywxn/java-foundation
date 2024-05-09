public class String_Family_Test {
    public static void main(String[] args) {
        String str1 = "abc";

        /**
         * 在 str 被重新赋值后，如果没有任何其他引用指向原始的 "Hello World" 字符串，
         * 那么这个字符串对象就变成了垃圾收集器的候选对象，可能会在未来的某个时刻被回收。
         * 但具体何时回收取决于 Java 虚拟机的垃圾回收策略和内存需求。
         */
        String str2 = str1 + "def";

        /**
         * 使用synchronized 锁,可以保证线程安全,但效率会降低
         */
        StringBuffer buffer = new StringBuffer("abc");

        /**
         * StringBuilder没有考虑线程安全问题,也正因如此,StringBuilder比StringBuffer性能略高
         */
        StringBuilder builder = new StringBuilder("abc");
        System.out.println(builder.reverse());

    }
}
