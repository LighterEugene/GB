import java.util.Arrays;

/* Необходимо написать два метода, которые делают следующее:

1) Создают одномерный длинный массив:

2) Заполняют этот массив единицами;

3) Засекают время выполнения: long a = System.currentTimeMillis();

4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:

arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

5) Проверяется время окончания метода System.currentTimeMillis();

6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a); Отличие первого метода от второго:
 Первый просто бежит по массиву и вычисляет значения. Второй разбивает массив на два массива, в двух потоках высчитывает
  новые значения и потом склеивает эти массивы обратно в один.

*/
public class HomeWork05 {
    public static void main(String[] args) {
        singleThread();
        multiThread();
    }

    private static void singleThread() { // метод для одной нити
        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1); // заполнение массива единицами

        long start = System.currentTimeMillis(); //точка отсчета времени начала выполнения задания

        for (int i = 0; i < size; i++) {// заполнение ячеек массива значениями
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long singleTime = System.currentTimeMillis() - start; // высчитывание время выполнения задания

        System.out.printf("Время выполнения при однопоточных вычислениях: %d%n", singleTime);
    }

    private static void multiThread() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a = new float[h];
        float[] b = new float[h];

        Arrays.fill(arr, 1); // заполнение массива единицами

        long start = System.currentTimeMillis();//точка отсчета времени начала выполнения задания
        //разбивка массива на два
        //Массив источник;  Позиция с которой берём значения; Массив цель;
        //Куда по индексу скопировать в массиве цели; количество элементов массива которые следует скопировать в массив цель.
        System.arraycopy(arr, 0, a, 0, h);
        System.arraycopy(arr, h, b, 0, h);

        //создание два объекта класса MyThread
        MyThread t1 = new MyThread("a", a);
        MyThread t2 = new MyThread("b", b);

        //Старт двух объектов класса MyThread в нескольких потоках
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // возвращаем массивы, которые хранятся в объектах t1 и t2
        a = t1.getArr();
        b = t2.getArr();

        // обратная склейка массива назад в один
        System.arraycopy(a, 0, arr, 0, h);
        System.arraycopy(b, 0, arr, a.length, b.length);

        // определение затраченного времени и сохранение в переменную
        long multiTime = System.currentTimeMillis() - start;

        System.out.printf("Время выполнения при многопоточных вычислениях: %d%n", multiTime);
    }


}

class MyThread extends Thread {

    private float[] arr;

    MyThread(String name, float[] arr) {
        super(name);
        this.arr = arr;
    }
    // геттер для приватного массива
    float[] getArr() {

        return arr;
    }

    @Override
    public void run() {
        calculate();
    }

    // метод заполняющий ячейки массива согласно формуле
    private void calculate() {
        // переменная  содержащая длинну массива
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}