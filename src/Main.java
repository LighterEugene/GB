/*
Создал новый проект, затем создал класс Main, затем psvm и tab
 */
public class Main {
    /*
     Создание переменные всех пройденных типов данных и инициализировать их значения:
     */
    byte first = 1;
    short second = 2;
    char third = '3';
    int fourth = 15;
    long fifth = 20;
    double sixth = 20.3;
    float seventh = 20.3f;
    boolean eighth = true;

    public static float calculateEqualation(float a, float b, float c, float d) { //метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        return a * (b + (c / d));
    }

    public static boolean isSumFrom10To20(int a, int b) {
        int sum = (a + b);          //метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно)
        if (sum >= 10 && sum <= 20) return true;// если да – вернуть true, в противном случае – false.
        else return false;
    }

    /*
     метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void isNumberPositiveOrNegative(int a) {
        if (a >= 0) System.out.println("Это число положительное");
        else System.out.println("Это число отрицательное");
    }

    /*
     метод, которому в качестве параметра передается целое число.
     Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isNumberPositiveOrNegativeBoolean(int a) {
        if (a < 0) return true;
        else return false;
    }

    /*
   метод, которому в качестве параметра передается строка, обозначающая имя.
      Метод должен вывести в консоль сообщение «Привет, указанное_имя!».
     */
    public static void sayHello(String name) {
        System.out.println("Привет, " + name + "!");
    }


    public static void main(String[] args) {

        // System.out.println(isSumFrom10To20( 2,7));
        //isNumberPositiveOrNegative (0);
        //System.out.println(isNumberPositiveOrNegativeBoolean(0));
        //sayHello("Евгений");
        // System.out.println(3 % 4 );

    }
}

