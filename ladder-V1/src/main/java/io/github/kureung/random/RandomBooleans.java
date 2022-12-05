package io.github.kureung.random;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public record RandomBooleans(int size) {

    public List<Boolean> randomBooleans() {
        final RandomGenerator randomGenerator = RandomGenerator.getDefault();
        final List<Boolean> booleans = new ArrayList<>(size);
        Boolean temp = false;
        for (int i = 0; i < size - 1; i++) {
            boolean value = randomGenerator.nextBoolean();
            if (temp && value) {
                booleans.add(false);
                temp = false;
                continue;
            }
            temp = value;
            booleans.add(value);
        }
        return booleans;
    }
}
