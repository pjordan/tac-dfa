package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface AuctionStoppingPolicy {
    boolean terminal(ClockAuction clockAuction);
}
