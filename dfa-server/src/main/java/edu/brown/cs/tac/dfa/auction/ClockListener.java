package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface ClockListener {
    void tickOccurred(Clock source, int tick);
}
