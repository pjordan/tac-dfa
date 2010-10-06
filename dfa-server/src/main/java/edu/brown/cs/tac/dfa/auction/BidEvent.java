package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface BidEvent {
    Bidder getBidder();

    int getQuantity();
}
