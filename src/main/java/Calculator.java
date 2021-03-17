public class Calculator {

    public int  addition(int first, int  second) {
        return first + second;
    }

    public int  subtraction(int minuend, int subtrahend) {
        return minuend - subtrahend;
    }

    public int  multiplication(int  first, int  second) {
        return first * second;
    }

    public int  division(int  numerator, int  denominator) {
        return numerator/ denominator;
    }

    public Exception divisionNull(int  numerator, int  denominator) {
        Exception exception=null;
       if (denominator==0){
           return exception=new NullPointerException();
       }
       return exception;
    }

}
