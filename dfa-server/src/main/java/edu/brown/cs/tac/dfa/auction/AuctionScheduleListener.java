package edu.brown.cs.tac.dfa.auction;

import java.util.Collection;

/**
 * @author Patrick R. Jordan
 */
public interface AuctionScheduleListener {
    void auctionsScheduled(Collection<? extends ClockAuction> auctions);
}
