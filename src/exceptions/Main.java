package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        // 1. Напишите программу, которая пытается открыть файл с именем "data.txt".
        // Если файл не найден, программа должна обработать исключение и вывести сообщение: "Файл не найден".

        
        try{

            FileReader reader = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        }
 
       //2
       CheckedException.division(5,2);

       //3 
        try{
            AgeChecker.checkAge(-1);
        }catch (MyException ex){
            System.out.println(ex.getMessage());
        }
        
        //4
        MailChecker.checkMail("11119");

        //5
        Box<String> stringBox = new Box<>();
        stringBox.setT("hello");
        System.out.println(stringBox.getT());

        Box<Integer> integerBox = new Box<>();
        integerBox.setT(123);
        System.out.println(integerBox.getT());

        //6
        String[] stringArray = {"hello", "people"};
        GenMethod.printArray(stringArray);

        Integer[] intArray = { 5, 6, 77, 21};
        GenMethod.printArray(intArray);

        
        //7
        Pair<String, Integer> pair1 = new Pair<>("Яблоко: ", 420);
        System.out.println(pair1.getFirst() + pair1.getSecond());
        pair1.setFirst("Слива: ");
        pair1.setSecond(200);
        System.out.println(pair1.getFirst() + pair1.getSecond());



    }
}
