import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private static Double result;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Команды калькулятора: сложение +, вычитание -, деление /, умножение *, выход exit");
        String first = null;
        String second = null;
        String operation=null;
        try {
            System.out.print("Выберите операцию: ");
            operation= reader.readLine();
            System.out.print("Введите первое число: ");
            first = reader.readLine();
            System.out.print("Введите второе число: ");
            second = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
       try {
           computation(first,second,operation);
           System.out.println("Результат: "+getResult());
       }catch (NullPointerException e){
           System.out.println("Error, введите данные заново");
       }

    }

    public static void computation(String first, String second, String operationName) {

        Double firstFromCalculator=null;
        Double secondFromCalculator=null;
        try {
            firstFromCalculator=Double.parseDouble(first);
            secondFromCalculator=Double.parseDouble(second);

        }catch (NumberFormatException e){
            System.out.println("Вы ввели неверные данные");
            result=null;
            System.out.println(getResult());
            return;
        }

        switch (operationName) {
            case "+":
                result = addition(firstFromCalculator,secondFromCalculator);
                break;
            case "-":
                result = subtraction(firstFromCalculator,secondFromCalculator);
                break;
            case "*":
                result = multiplication(firstFromCalculator,secondFromCalculator);
                break;
            case "/":
                result = division(firstFromCalculator,secondFromCalculator);
                break;
            default:
                System.out.println("Нет подходящего символа");
                result=null;
        }

    }

    public static Double getResult() {
        return result;
    }

    private static double addition(double first, double second) {
        return first + second;
    }

    private static double subtraction(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    private static double multiplication(double first, double second) {
        return first * second;
    }

    private static double division(double numerator, double denominator) {
        return numerator / denominator;
    }


}






