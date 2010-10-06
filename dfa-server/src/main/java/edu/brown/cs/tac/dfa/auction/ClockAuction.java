package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface ClockAuction {
    Clock getClock();

    int getQuantityAvailable();

    int getMinBidQuantity();

    AuctionInfo getInfo();

    void bid(Bidder bidder, int quantity);
}
