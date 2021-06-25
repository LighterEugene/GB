public class Dog extends Animal{
    static int amountOfDogs;
    public Dog(String name, String color, int age) {
        super(name, color, age);
        amountOfDogs++;// Добавить подсчет созданных котов, собак и животных.
    }

    @Override
    public void run(int distance){// метод в случае неверного ввода данных, защищен, иначе выводит что надо.
        trying:
        {
            if (distance > 500 || distance < 0) {
                System.out.println("Введено не корректное число -  собака может пробежать от 0 до 500 метров ");
                break trying;
            }
            System.out.println(super.name + " преодолевает по суху " + distance + " метров");
        }
    }
    @Override
    public void swim(int distance){// метод в случае неверного ввода данных, защищен, иначе выводит что надо.
        trying:
        {
            if (distance > 10 || distance < 0) {
                System.out.println("Введено не корректное число -  собака может проплыть от 0 до 10 метров включительно");
                break trying;
            }
            System.out.println(super.name + " преодолевает по воде " + distance + " метров");
        }


    }
}
