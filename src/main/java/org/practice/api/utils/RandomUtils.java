package org.practice.api.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    public static String generateStringValue(int charactersCount) {
        return RandomStringUtils.random(charactersCount , true, false);
    }

    public static int generateIntValue(int charactersCount) {
        return Integer.parseInt(RandomStringUtils.random(charactersCount, false, true));
    }


}
