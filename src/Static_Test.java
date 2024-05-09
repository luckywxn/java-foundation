public class Static_Test {

    static int a;

    /**
     *实例变量
     */
    int b = 2;
    static void print(){
        System.out.println(a);
    }

    /**
     * static关键字可以修饰除了构造器外的其他4种成员
     */
//    static Static_Test(){
//
//    }

    static{
        a = 1;
    }

    static class Inner{

    }

    public static void main(String[] args){
        System.out.println(a);
        /**
         * 类成员不能访问实例成员
         */
//        System.out.println(b);
    }
}
