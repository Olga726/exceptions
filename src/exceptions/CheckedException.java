package exceptions;

// Напишите метод, который принимает на вход два числа и выполняет их деление.
// Обработайте ситуацию, когда второе число равно нулю, чтобы избежать исключения при делении.
public class CheckedException {
    public static void division (int a, int b){
        try{
            System.out.println(a/b);
        } catch (ArithmeticException e){
            System.out.println("ошибка: на 0 делить нельзя");
        }
    }
}
