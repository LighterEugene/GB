import java.util.*;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
 из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи.
  С помощью метода get() искать номер телефона по фамилии.
  Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.
 */


public class Homework3 {
    public static void main(String[] args) {
       // первое задание

        List<String> strArr = new ArrayList<>(Arrays.asList(
                "Мишка", "Мишка", "Тося", "Саша", "Тося",
                "Зина", "Моня", "Боря", "Густав", "Тося",
                "Мишка", "Зулим", "Боря", "Саша", "Мишка",
                "Боря", "Артём", "Олег", "Саша", "Боря"
        ));
        System.out.println("Весь массив: " + strArr);

        Set<String> unicArr = new HashSet<>(strArr);
        System.out.println("Только уникальные значения: " + unicArr);

        Map<String, Integer> sumArr = new HashMap<>();
        for (String s : strArr) {
            int val = sumArr.getOrDefault(s, 0) + 1;
            sumArr.put(s, val);
        }
        System.out.println("Сколько раз встречается каждое слово: " + sumArr);

        System.out.println();
        System.out.println("Задание 2");

        Contacts contacts = new Contacts();

        contacts.add("Толстой", "+7987654321");
        contacts.add("Толстой", "+7987654322");
        contacts.add("Булгаков", "+7987654323");
        contacts.add("Булгаков", "+7987654324");
        contacts.add("Лермонтов", "+7987654325");
        contacts.add("Пастернак", "+7987654326");
        contacts.add("Островский", "+7987654327");
        contacts.add("Пастернак", "+7987654328");
        contacts.add("Некрасов", "+7987654329");

        System.out.println("Толстой: " + contacts.get("Толстой"));
        System.out.println("Булгаков: " + contacts.get("Булгаков"));
        System.out.println("Пастернак: " + contacts.get("Пастернак"));
        System.out.println("Некрасов: " + contacts.get("Некрасов"));
        System.out.println("Островский: " + contacts.get("Островский"));
        System.out.println("Лермонтов: " + contacts.get("Лермонтов"));
    }
}