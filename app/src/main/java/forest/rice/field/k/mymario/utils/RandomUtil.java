package forest.rice.field.k.mymario.utils;

import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();

    public static int getRandom(int i) {
        return random.nextInt(i) + 1;
    }
}
