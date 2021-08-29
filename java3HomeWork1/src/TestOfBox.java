import java.math.BigDecimal;

public class TestOfBox {
    public static void main(String[] args) {
        Apple apple1 = new Apple();// экземпляры классов наследников Fruit для коробок
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();



        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
         // создание  коробок
        Box<Apple> box1 = new Box<Apple>(apple1, apple2);
       Box<Orange> box2 = new Box<Orange>(orange1, orange2);


        System.out.println(box1.compare(box2));// сравнение  коробок

        Box<Orange> box3 = new Box<Orange>();
        System.out.println(box2.getWeight());
        box2.transfer(box3);// проверка метода по пересыпанию фруктов
        System.out.println(box1.getWeight());
       System.out.println(box3.getWeight());
        box3.remove(orange1);
       System.out.println(box3.getWeight());


    }
}
