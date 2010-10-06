package edu.brown.cs.tac.dfa.auction;

import edu.brown.cs.tac.dfa.util.ListenerSupport;

/**
 * @author Patrick R. Jordan
 */
public class AuctionListenerSupport extends ListenerSupport<ClockAuction, AuctionListener>

{
    public AuctionListenerSupport(ClockAuction auction) {
        super(auction);
    }

    public void fireAuctionStarted() {
        for (AuctionListener listener : this) {
            listener.auctionStarted(getSource());
        }
    }

    public void fireAuctionStopped() {
        for (AuctionListener listener : this) {
            listener.auctionStopped(getSource());
        }
    }

    public void firePurchaseEvent(int tick, int quantity) {
        for (AuctionListener listener : this) {
            listener.purchaseEvent(getSource(), tick, quantity);
        }
    }
}
