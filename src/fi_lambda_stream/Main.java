package fi_lambda_stream;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Напишите интерфейс MathOperation, который принимает два числа и возвращает результат операции.
        // Реализуйте его с помощью лямбда-выражений: сложение, вычитание, умножение, деление.

        MathOperation add = (x, y) -> x + y;
        MathOperation substract = (x, y) -> x - y;
        MathOperation multiply = (x, y) -> x * y;
        MathOperation divide = (x, y) -> x / y;

        System.out.println(add.operate(11, 158));
        System.out.println(substract.operate(11, 158));
        System.out.println(multiply.operate(11, 158));
        System.out.println(divide.operate(11000, 158));

        //Создайте анонимный класс, реализующий интерфейс Runnable, который выводит сообщение "Hello from anonymous class!".
        Runnable anonymousClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from anonymous class!");
            }
        };
        anonymousClass.run();


        //Напишите лямбду, которая проверяет, является ли число чётным.
        Predicate<Integer> isEven = n -> n%2 ==0;
        System.out.println(isEven.test(58));
        System.out.println(isEven.test(51));

        //Создайте лямбду, которая принимает строку и возвращает её длину.
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println(stringLength.apply(""));

        //Напишите лямбду, которая принимает строку и печатает её в консоль.
        Consumer<String> printString = str -> System.out.println(str);
        printString.accept("hello!");


        //Напишите программу, которая принимает список строк и удаляет из него все строки длиной 5 символов и менее,
        // используя Stream API.
        List<String> list1 = Arrays.asList("hghghgh", "ss", "oioio", "gggggg");
        List<String> list2 = list1.stream()
                .filter(str -> str.length()>5)
                .collect(Collectors.toList());
        System.out.println(list2);

        //Напишите программу, которая принимает список чисел и отбирает только те,
        // которые делятся на 5 без остатка, используя Stream API.
        List<Integer> list3 = Arrays.asList(155, 2, 10, 14);
        List<Integer> list4 = list3.stream()
                .filter(el -> el%5 ==0)
                .collect(Collectors.toList());
        System.out.println(list4);

        //Напишите программу, которая принимает список строк и заменяет каждую строку на её длину,
        // используя Stream API.
        List<String> list5 = Arrays.asList("sss", "s", "kjkjkkj", "de");
        List<Integer> list6 = list5.stream()
                .map(str -> str.length())
                .collect(Collectors.toList());
        System.out.println(list6);

        //Напишите программу, которая принимает список чисел и преобразует его в новый список,
        // где каждое число заменено на его квадрат, используя Stream API.
        List<Integer> list7 = Arrays.asList(155, 2, 10, 14, 2, 1, 1, 10, 17 );
        List<Integer> list8 = list7.stream()
                .map(el -> el*el)
                .collect(Collectors.toList());
        System.out.println(list8);

        //Напишите программу, которая принимает список элементов и удаляет из него все дубликаты, используя Stream API.
        List<Integer> list9 = list7.stream()
                .distinct().toList();
        System.out.println(list9);

        //Напишите программу, которая принимает список чисел и находит в нём самое большое число, используя Stream API.
        Integer maxFromList7 = list7.stream()
                .max(Integer::compareTo)
                .get();
        System.out.println(maxFromList7);

        //Напишите программу, которая принимает список чисел и находит в нем наименьшее число, используя Stream API.
        Integer minFromList7 = list7.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println(minFromList7);

        //Напишите программу, которая принимает список чисел и вычисляет их сумму, используя Stream API.
        Integer sumList7 = list7.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumList7);

        //Напишите программу, которая принимает список строк и находит первую строку,
        // начинающуюся на букву "Б", используя Stream API.
        List<String> list10 = Arrays.asList("Апельсин", "Вишня", "Банан", "Батон", "ананас", "Груша");
        Optional<String> stringBStarts = list10.stream()
                .filter(str -> str.startsWith("Б"))
                .findFirst();
        System.out.println(stringBStarts.get());

        //Напишите программу, которая проверяет, есть ли хотя бы один элемент в списке,
        // который удовлетворяет заданному условию (например, является чётным числом), используя Stream API.
        List<Integer> list11 = Arrays.asList(1, 21, 3, 7, 107);
        Boolean anyEvenInList11 = list11.stream()
                .anyMatch(el ->el % 2 ==0);
        System.out.println(anyEvenInList11);


        //Напишите программу, которая принимает список строк и группирует их по первой букве, используя Stream API.
        Map<Character, List<String>> list12 = list10.stream()
                .collect(Collectors.groupingBy(str -> Character.toLowerCase(str.charAt(0))));
        list12.forEach((character, strings) -> System.out.println(character + ": " + strings));

        //Напишите программу, которая принимает список чисел и группирует их на чётные и нечётные, используя Stream API.
        List<Integer> list13 = Arrays.asList(0, 1, 15, 2, 9, 8, 14);
        Map<Boolean, List<Integer>> groupedList13 = list13.stream()
                .collect(Collectors.groupingBy(el -> el%2 ==0));
        System.out.println("четные: " + groupedList13.get(true));
        System.out.println("нечетные: " + groupedList13.get(false));

        //Напишите программу, которая принимает список чисел и находит их среднее значение, используя Stream API.
        OptionalDouble avgList13 = list13.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.println("среднее значение: " + avgList13.getAsDouble());


    }
}
