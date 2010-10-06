package edu.brown.cs.tac.dfa.util;

import java.util.Random;

/**
 * @author Patrick R. Jordan
 */
public class StreamSampler<T> {
    int n;
    Random random;
    T selected;

    public StreamSampler(Random random) {
        this.random = random;
    }

    public StreamSampler() {
        this(new Random());
    }

    public T getSelected() {
        return selected;
    }

    public void sample(T sample) {
        if(random.nextInt(++n) == 0) {
            selected = sample;
        }
    }


    public void reset() {
        selected = null;
        n = 0;
    }
}
