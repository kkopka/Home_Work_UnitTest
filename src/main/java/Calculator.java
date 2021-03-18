import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Команды калькулятора: сложение +, вычитание -, деление /, умножение *, выход exit");
        while (true) {
           String operationName = null;
            while (true) {
                System.out.print("Выберите операцию:");
                try {
                    operationName = (reader.readLine());
                    if (operation(operationName)) {
                        break;
                    } else {
                        continue;
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка");
                    continue;
                }
            }

            Double first = null;
            Double second = null;


            while (true) {
                try {
                    System.out.print("Введите первое число:");
                    first = Double.parseDouble(reader.readLine());
                    System.out.print("Введите второе число:");
                    second = Double.parseDouble(reader.readLine());
                } catch (NumberFormatException | IOException e) {
                    System.out.println("Введите данные корректно");
                    continue;
                }
                break;
            }

              Double result = computation(first, second, operationName);


            System.out.println(first + " " + operationName + " " + second + " = " + result);

        }
    }

    public static boolean operation(String operationName) {
        if (!operationName.equals("+") && !operationName.equals("-") && !operationName.equals("/") && !operationName.equals("*")) {
            System.out.println(operationName + " данная операция не распознана");
            return false;
        }
        return true;
    }


    public static double computation(double first, double second, String operationName) {
        Double result = null;
            switch (operationName) {
                case "+":
                    result = addition(first, second);
                    break;
                case "-":
                    result = subtraction(first, second);
                    break;
                case "*":
                    result = multiplication(first, second);
                    break;
                case "/":
                    result = division(first, second);
                    break;

            }

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






