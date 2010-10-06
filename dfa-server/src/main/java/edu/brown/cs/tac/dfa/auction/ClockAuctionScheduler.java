package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public interface ClockAuctionScheduler {
    
    public void addListener(AuctionScheduleListener listener);

    public void removeListener(AuctionScheduleListener listener);

    public void removeAllListeners();
}
