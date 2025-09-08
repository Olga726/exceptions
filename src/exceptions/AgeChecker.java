package exceptions;
// Разработайте метод, который проверяет валидность возраста пользователя.
// Если возраст меньше 0 или больше 150, метод должен выбрасывать проверяемое исключение.
public class AgeChecker {
    public static void checkAge(int age) throws MyException {
        if (age<0 || age >150){
            throw new MyException("Невалидный возраст");
        } else {
            System.out.println("Возраст корректный: " + age);
        }
    }
}
