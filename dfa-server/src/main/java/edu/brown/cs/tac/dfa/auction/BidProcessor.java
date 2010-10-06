package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface BidProcessor {
    boolean process(BidEvent bidEvent, Clock clock, Lot lot);
}
