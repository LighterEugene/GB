//Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//Написать метод, который преобразует массив в ArrayList;

import java.util.*;


public class ArrayAndListTasks {
    public static void main(String[] args) {
        Object[] array = {1, 2, 3, 3};
        swapCellValueOfArrayByIndex(array,0,3);
        for (Object i : array){

            System.out.println(i);
        }
        System.out.println("Граница");
      ArrayList<Object> Try = transformingArrayIntoArraylist(array);
        Try.add("Вставленный элемент в лист");
        for (Object i : Try){

            System.out.println(i);
        }

    }
    // Метод меняет элементы массива по индексу
    public static void swapCellValueOfArrayByIndex(Object[] array,int a,int b)  {
        try {
          Object temp1 = array[a];
          array[a] = array[b];
          array[b] = temp1;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введен некорректный индекс массива");
            System.out.println(e.getMessage());
            return;
        }
    }
    //метод, который преобразует массив в ArrayList;
    public static ArrayList<Object> transformingArrayIntoArraylist(Object[] array)    {
        ArrayList<Object> ArrayList  = new ArrayList<Object>();
        for (int i = 0; i < array.length; i++) {
            ArrayList.add(array[i]);
        }
        return ArrayList;
    }
}


