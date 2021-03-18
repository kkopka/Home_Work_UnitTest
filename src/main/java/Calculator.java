import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private static String result;

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
            result="Вы ввели неверные данные";
            return;
        }

        switch (operationName) {
            case "+":
                result =  addition(firstFromCalculator,secondFromCalculator).toString();
                break;
            case "-":
                result = subtraction(firstFromCalculator,secondFromCalculator).toString();
                break;
            case "*":
                result = multiplication(firstFromCalculator,secondFromCalculator).toString();
                break;
            case "/":
                result = division(firstFromCalculator,secondFromCalculator).toString();
                break;
            default:
                result="Нет подходящего символа";
        }

    }

    public static String getResult() {
        return result;
    }

    private static Double addition(double first, double second) {
        return first + second;
    }

    private static Double subtraction(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    private static Double multiplication(double first, double second) {
        return first * second;
    }

    private static Double division(double numerator, double denominator) {
        return numerator / denominator;
    }


}






