package bullsandcows;

import java.util.Arrays;
import java.util.Random;

import static bullsandcows.Core.NUMBER_COUNT;

public class BullsAndCows {
    private int[] randomNumbers = {-1, -1, -1};

    private int[] chooseRandomNumbers() {
        for (int i = 0; i < NUMBER_COUNT; i++) {
            randomNumbers[i] = chooseNotDuplicatedNum();
        }
        return randomNumbers;
    }

    private int chooseNotDuplicatedNum() {
        Random random = new Random();
        int temp;
        do {
            temp = random.nextInt(10);
        } while (!Arrays.asList(randomNumbers).contains(temp));
        return temp;
    }
}
