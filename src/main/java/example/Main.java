package example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        try {
            System.out.println(stringCalculator.calculate(value));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
