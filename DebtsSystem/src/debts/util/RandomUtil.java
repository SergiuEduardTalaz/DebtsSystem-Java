package ro.fortech.academy.debts.util;

import java.util.Random;

public class RandomUtil {
    public static String getRandomString(int maxSize) {
        Random random = new Random();
        return random.ints(97, 123)
                .limit(maxSize)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int getRandomInteger() {
        Random random = new Random();
        return Math.abs(random.nextInt());
    }
}
