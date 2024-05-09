import java.io.FileNotFoundException;

public class ExceptionTest {
    public static void main(String[] args){

        /**
         * 1、验证异常五个关键字
         */
        System.out.println("1、验证异常五个关键字*********************");
        vilidException();

        /**
         * 2、导致try块、catch块中的return、throw语句失效
         */
        System.out.println("2、导致try块、catch块中的return、throw语句失效*********************");
        System.out.println(invalidCatchTest());

        /**
         * 3、finally代码块不执行的几种情况
         */
        System.out.println("3、finally代码块不执行的几种情况*********************");
        finallyNotExecuteTest();

    }

    public static void vilidException() {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            // 当找不到文件时，捕获并处理异常
            System.out.println(e.getMessage());
//            e.printStackTrace();
        } finally {
            // 无论是否发生异常，这段代码都会被执行
            System.out.println("This is the finally block, always executed.");
        }
    }

    public static void readFile() throws FileNotFoundException {
        throw new FileNotFoundException("File not found.");
    }

    public static String invalidCatchTest() {
        try {
            int i = 2 / 0;
            return "try";
        } catch (Exception e) {
            System.out.println("catch");
            return "catch";
        } finally {
            return "finally";
        }
    }

    public static void finallyNotExecuteTest() {
        try {
            int i = 2 / 0;
        } catch (Exception e) {
            System.out.println("catch");
            System.exit(1);
        } finally {
            System.out.println("finally");
        }
    }



}
