public class Calculator implements Calculable {
    private double result;

    public Calculator() {
        this.result = 0;
    }

    @Override
    public void sum(double a, double b) {
        double tempResult = a + b;
        result = a + b;
    }

    @Override
    public void multiply(double a, double b) {
        double tempResult = a * b;
        result += tempResult;
    }

    @Override
    public void divide(double a, double b) {
        if (a == 0 | b == 0) throw new ArithmeticException("Divide by zero exception.");
        result = a / b;

    }

    @Override
    public void subtraction(double a, double b) {
        double tempResult = a - b;
        result += tempResult;
    }

    @Override
    public double result() {
        System.out.println(result);
        return result;
    }

    @Override
    public void clear() {
        this.result = 0;
    }
}
