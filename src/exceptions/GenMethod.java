package exceptions;
//Напишите дженерик метод printArray, который принимает массив элементов любого типа
// и выводит каждый элемент массива на консоль.
public class GenMethod {
    public static <T> void printArray(T[] values){
        for (T element: values){
            System.out.println(element);
        }

    }

}
