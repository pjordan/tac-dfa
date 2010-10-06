package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface ClockListener {
    void tickOccured(Clock source, int tick);
}
