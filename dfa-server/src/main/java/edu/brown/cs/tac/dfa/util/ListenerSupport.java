package edu.brown.cs.tac.dfa.util;

import edu.brown.cs.tac.dfa.auction.Clock;
import edu.brown.cs.tac.dfa.auction.ClockListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Patrick R. Jordan
 */
public class ListenerSupport<S,T> implements Iterable<T> {
    private List<T> listeners;
    private S source;

    public ListenerSupport(S source) {
        this.source = source;

        listeners = new ArrayList<T>();
    }

    public void addListener(T listener) {
        listeners.add(listener);
    }

    public void removeListener(T listener) {
        listeners.remove(listener);
    }

    public void removeAllListeners() {
        listeners.clear();
    }

    public Iterator<T> iterator() {
        return listeners.iterator();
    }

    public S getSource() {
        return source;
    }
}
