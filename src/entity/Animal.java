package entity;

public abstract class Animal {

    // 实例初始化块
    {
        System.out.println("初始化块被执行了");
    }

    /**
     * 既可以定义普通成员变量,也可以定义静态常量
     */
    int a;
    static int b;

    public abstract void sound(); // 抽象方法
    public void move() { // 非抽象方法
        System.out.println("动物可以移动");
    }

    /**
     * 可以包含构造器,但抽象类的构造器并不是用于创建对象,而是让其子类调用这些构造器来完成属于抽象类的初始化操作
     */
    Animal(){

    }
}