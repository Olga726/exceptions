package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Напишите функцию, которая принимает строку в качестве аргумента и проверяет,
// является ли строка правильным электронным адресом.
// Если строка не удовлетворяет критериям, функция должна выбрасывать непроверяемое исключение.
public class MailChecker {
    public static void checkMail (String mail){
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$";

        if(!Pattern.matches(regex, mail)){
            throw new UncheckedException("Невалидный email");
        }
        System.out.println("email валидный: " + mail);
    }
}
