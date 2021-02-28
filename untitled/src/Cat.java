public class Cat extends Animal {
    static int amountOfCats;
    public Cat(String name, String color, int age) {
        super(name, color, age);
        amountOfCats++;// Добавить подсчет созданных котов, собак и животных.
    }

    @Override
    public void run(int distance){// метод в случае неверного ввода данных, защищен, иначе выводит что надо.
        trying:
        {
            if (distance > 200 || distance < 0) {
                System.out.println("Введено не корректное число - кот может пробежать от 0 до 200 метров включительно");
                break trying;
            }

            System.out.println(super.name + " преодолевает по суху " + distance + " метров");
        }
    }
    @Override
    public void swim(int distance){
        System.out.println("Плавать не может!");
    }
}
