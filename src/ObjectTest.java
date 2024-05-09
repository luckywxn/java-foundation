import entity.Animal;
import entity.Dog1;
import entity.Dog2;

public class ObjectTest {
    private int attribute_a ;
    public static void main(String[] args) {
        ObjectTest a = new ObjectTest();
        a.setAttribute_a(1);
        ObjectTest b = new ObjectTest();
        b.setAttribute_a(1);

        System.out.println(a == b);
        /**
         * 二者之间有两个约定,如果两个对象相等,它们必须有相同的哈希码；但如果两个对象的哈希码相同,他们却不一定相等。
         */
        System.out.println(a.equals(b));

        /**
         * Object 类中的 hashCode() 方法是一个本地方法（native）
         */
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Animal animal = new Dog1();
        Dog1 dog1 = new Dog1();
        Dog2 dog2 = new Dog2();

        System.out.println(animal == dog1);
        /**
         * ==不能用于比较类型上没有父子关系的两个对象
         */
//        System.out.println(dog1 == dog2);

    }

    public void setAttribute_a(int attribute_a) {
        this.attribute_a = attribute_a;
    }

    public int hashCode() {
        return attribute_a;
    }

    public boolean equals(ObjectTest obj) {
        return (this.attribute_a == obj.attribute_a);
    }
}
