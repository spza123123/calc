import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class View {
    Calculable calculator;

    public View(Calculable calculator) {
        this.calculator = calculator;
    }

    public void run() {
        while (true) {
            enteringNum();
            String action = prompt();
            if (!action.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }

    private void enteringNum() {
        System.out.println("Enter 1-st num: ");
        double a = checkum();
        System.out.println("Enter 2-nd num: ");
        double b = checkum();
        System.out.println(a);
        System.out.println(b);
        System.out.println("Enter operator ");
        String operator = oGet();
        if (operator.equals("*")) {
            calculator.multiply(a, b);
        }

        if (operator.equals("+")) {
            calculator.sum(a, b);
        }

        if (operator.equals("/")) {
            calculator.divide(a, b);
        }

        if (operator.equals("-")) {
            calculator.subtraction(a, b);
        }

        calculator.result();
        calculator.clear();
    }

    private String prompt() {
        Scanner in = new Scanner(System.in);
        System.err.println("Continue?... (y/n)");
        return in.nextLine();
    }

    private String oGet() {
        Scanner in = new Scanner(System.in);
        String operator = in.next();
        List<String> operators = List.of("+", "-", "/", "*");
        try {
            for (int i = 0; true; i++) {
                if (operator.equals(operators.get(i))) {
                    return operator;
                }

            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new RuntimeException("Incorrect operator is entered");

        }

    }

    private double checkum() {
        Scanner in = new Scanner(System.in);
        double num = -1;

        try {
            num = in.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("Not number was enter. Please enter number");
            System.exit(0);
        }
        return num;
    }
}
