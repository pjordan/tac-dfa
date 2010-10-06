package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface AuctionListener {

    void auctionStarted(ClockAuction auction);

    void auctionStopped(ClockAuction auction);

    void purchaseEvent(ClockAuction auction, int tick, int quantity);
}
