//Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//Написать метод, который преобразует массив в ArrayList;

import java.util.*;


public class ArrayAndListTasks {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 3};
        swapCellValueOfArrayByIndex(array,0,3);
        for (Integer i : array){

            System.out.println(i);
        }
        System.out.println("Граница");
      ArrayList<Integer> probe = transformingArrayIntoArraylist(array);

        for (Integer i : probe){

            System.out.println(i);
        }

    }
    // Метод меняет элементы массива по индексу
    public static <T> T swapCellValueOfArrayByIndex(T[] array, int a, int b) throws ArrayIndexOutOfBoundsException {
        try {
          T temp1 = array[a];
          array[a] = array[b];
          array[b] = temp1;
        }
        catch (ArrayIndexOutOfBoundsException e) {

                throw e;
            }
        return (T) array;
        }

    //метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> transformingArrayIntoArraylist(T[] array)    {
        ArrayList<T> arrayList  = new ArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }
}


