public abstract class Animal {
    String name;
    String color;
    int age;
    static int amountOfAnimals;   // Добавить подсчет созданных котов, собак и животных.

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        amountOfAnimals++;
    }

    abstract void run(int x);
       abstract void swim(int x);
    }

