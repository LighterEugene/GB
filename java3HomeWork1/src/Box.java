import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {// T создаётся как Дженерик класс, который расширяет Fruit = соответственно он может
    // работать с Apple и Orange, и везде дальше где T, это подразумевается и состоит из представителей этих классов
    private ArrayList<T> items;

    public Box(T... items) { // T... items Означает, что мы пихаем представителей класса один за другим
        // items массив, мы не можем положить два разных класса наследника в одну коробку, потому как
        //задаём значение Т когда создаём объект класса, тогда Т уже определенно, а значит нельзя положить иное,
        // согласно конструктору
        this.items = new ArrayList<T>(Arrays.asList(items));
    }
    // преобразует массив элементов и добавляет в лист,addAll метод ArrayList
    public void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }
    //убирает уже вложенные экземпляры класса с коробки с ссылкой
    public void remove(T... items) {
        for (T item: items) this.items.remove(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public void clear() {// метод clear очищает лист
        items.clear();
    }

    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item: items) {
            if (item instanceof Apple)
            weight += 1.0f;
            if (item instanceof Orange)
                weight += 1.5f;
        }
        return weight;
    }


    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();// в обоих случаях сравнивается конкретное число, не ссылки.
    }

    public void transfer(Box<? super T> box) {// wildcard super для того, чтобы исключить пересыпания яблок к апельсинам, и наоборот
        box.items.addAll(this.items);
        clear();
    }
}














