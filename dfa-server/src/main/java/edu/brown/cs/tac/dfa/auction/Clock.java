package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface Clock {

    int getTickValue();

    void addClockListener(ClockListener listener);

    void removeClockListener(ClockListener listener);

    void removeAllClockListeners();
    
}
