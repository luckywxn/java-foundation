package entity;

public interface Soundable {

    /**
     *接口里不能包含初始化块
     */
//    {
//        System.out.println("初始化块被执行了");
//    }

    static int a = 1;
    /**
     *,不能定义普通成员变量
     */
//    int b ;

    /**
     * 接口中定义的变量默认是public static final的，这意味着它们是全局常量，必须在声明时初始化
      */
    public static final int b = 2;


    public abstract void sound(); // 接口方法
    default void move(){
        System.out.println("move");
    }

    /**
     * 不能为普通方法提供方法实现
     */
//    public void move2() {
//        System.out.println("动物可以移动");
//    }

    /**
     * 接口里不包含构造器
     */
//    Soundable(){
//
//    }

}
