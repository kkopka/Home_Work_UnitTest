import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Команды калькулятора: сложение +, вычитание -, деление /, умножение *, выход exit");
        while (true) {
            System.out.print("Какую операцию вы хотите выполнить:");
            String operation = null;
            try {
                operation = reader.readLine();
                if (operation.equals("exit")){
                    break;
                }
                if (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*")) {
                    throw new IOException();
                }
            } catch (IOException e) {
                System.out.println("Команда неккоректна");
                continue;
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

            Double result = null;
            switch (operation) {
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
            System.out.println(first + " " + operation + " " + second + " = " + result);

        }
    }


    public static double addition(double first, double second) {
        return first + second;
    }

    public static double subtraction(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }

    public static double multiplication(double first, double second) {
        return first * second;
    }

    public static double division(double numerator, double denominator) {
        return numerator / denominator;
    }

}






