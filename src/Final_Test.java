import entity.FinalClass;
import entity.FinalFun;

public class Final_Test extends FinalFun {

    final int age = 18;

    public static void main(String[] args) {
        /**
         * 变量不可变
         */
//        age = 20;

        System.out.println(Math.abs(1));
    }

    /**
     * 当final修饰类时,该类不能被继承
     */
//    class FinalClassExtend extends FinalClass {
//
//    }

    /**
     * 当final修饰方法时,该方法不能被重写
     */
//    public void sound() {
//
//    }




}