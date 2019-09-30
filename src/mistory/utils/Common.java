package mistory.utils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Common {
    public static String randomString() {
        return randomString(7);
    }

    public static String randomString(int size) {
        byte[] array = new byte[size]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}
