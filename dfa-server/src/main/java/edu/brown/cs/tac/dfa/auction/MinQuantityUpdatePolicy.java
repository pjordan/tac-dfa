package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface MinQuantityUpdatePolicy {
    int updateMinQuantity(BidEvent bidEvent, Clock clock, Lot lot);
}
