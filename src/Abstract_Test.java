import entity.Animal;
import entity.Soundable;
import entity.Dog1;
import entity.Dog2;

public class Abstract_Test {
    public static void main(String[] args) {
        //接口和抽象类都不能被实例化
//        Animal animal = new Animal();
//        Soundable soundable = new Soundable();



        Dog1 dog1 = new Dog1();
        dog1.sound();
        dog1.move();
        Dog2 dog2 = new Dog2();
        dog2.sound();
        dog2.move();
    }
}
