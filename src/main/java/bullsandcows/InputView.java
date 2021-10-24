package bullsandcows;

import java.util.Scanner;

import static bullsandcows.Core.NUMBER_COUNT;

public class InputView {
    public int[] getPredictionsFromUsers() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] userNumbers = new int[NUMBER_COUNT];

        for (int i = NUMBER_COUNT - 1; i >= 0; i--) {
            userNumbers[i - NUMBER_COUNT + 1] = (input % (int)Math.pow(10, i + 1)) / (int)Math.pow(10, i);
        }

        return new int[NUMBER_COUNT];
    }
}
