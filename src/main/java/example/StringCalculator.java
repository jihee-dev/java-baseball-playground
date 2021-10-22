package example;

import java.util.regex.Pattern;

public class StringCalculator {
    public double calculate(String formula) throws Exception {
        String[] elements = getElements(formula);

        if (!checkFormula(elements)) {
            throw new Exception("Input is Wrong");
        } else {
            calculateElementArr(elements);
        }

        return calculateElementArr(elements);
    }

    private String[] getElements(String value) {
        return value.split(" ");
    }

    private boolean checkFormula(String[] elements) {
        if (elements.length % 2 == 0) return false;

        for (int i = 0; i < elements.length; i = i + 2) {
            if (!isNum(elements[i])) return false;
        }

        for (int i = 0; i < elements.length - 1; i = i + 2) {
            if (!isOperator(elements[i + 1])) return false;
        }

        return true;
    }

    private boolean isNum(String str) {
        String numPattern = "^-?[0-9]*$";
        return Pattern.matches(numPattern, str);
    }

    private boolean isOperator(String str) {
        String operatorPattern = "^[-+*/]$";
        return Pattern.matches(operatorPattern, str);
    }

    private double calculateElementArr(String[] elements) {
        double x = Double.parseDouble(elements[0]);

        if (elements.length == 1) return x;

        for (int i = 2; i < elements.length; i = i + 2) {
            switch (elements[i - 1]) {
                case "+":
                    x = plus(x, Double.parseDouble(elements[i]));
                    break;
                case "-":
                    x = minus(x, Double.parseDouble(elements[i]));
                    break;
                case "*":
                    x = multiple(x, Double.parseDouble(elements[i]));
                    break;
                case "/":
                    x = divide(x, Double.parseDouble(elements[i]));
                    break;
            }
        }

        return x;
    }

    private double plus(double x, double y) {
        return x + y;
    }

    private double minus(double x, double y) {
        return x - y;
    }

    private double multiple(double x, double y) {
        return x * y;
    }

    private double divide(double x, double y) {
        return x / y;
    }
}
