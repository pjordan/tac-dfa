package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface TickResetPolicy {
    int resetTickValue(BidEvent bidEvent, Clock clock, Lot lot);
}
