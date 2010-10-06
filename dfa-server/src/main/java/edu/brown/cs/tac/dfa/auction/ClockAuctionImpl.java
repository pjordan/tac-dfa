package edu.brown.cs.tac.dfa.auction;

import java.util.List;

/**
 * @author Patrick R. Jordan
 */
class ClockAuctionImpl implements ClockAuction {
    private final Object lock;

    private ClockImpl clock;

    private LotImpl lot;

    private int minBidQuantity;

    private AuctionInfo info;

    private BidProcessor bidProcessor;

    private TickResetPolicy tickResetPolicy;

    private MinQuantityUpdatePolicy minQuantityUpdatePolicy;

    private AuctionListenerSupport support;

    private BidEventSelector bidEventSelector;

    ClockAuctionImpl(AuctionInfo info, BidProcessor bidProcessor, TickResetPolicy tickResetPolicy, MinQuantityUpdatePolicy minQuantityUpdatePolicy) {
        this.info = info;
        this.bidProcessor = bidProcessor;
        this.tickResetPolicy = tickResetPolicy;
        this.minQuantityUpdatePolicy = minQuantityUpdatePolicy;

        bidEventSelector = new BidEventSelector();
        support = new AuctionListenerSupport(this);

        lock = new Object();
        //TODO: initialize clock
        // clock = something...
        //TODO: initialize lot
        // lot = something...
    }

    public Clock getClock() {
        return clock;
    }

    public int getQuantityAvailable() {
        return lot.getRemainingQuantity();
    }

    public AuctionInfo getInfo() {
        return info;
    }

    public int getMinBidQuantity() {
        return minBidQuantity;
    }

    public void bid(Bidder bidder, int quantity) {
        synchronized (lock) {
            bidEventSelector.bid(bidder, quantity);
        }
    }

    boolean processBids() {

        boolean purchase = false;

        synchronized (lock) {
            int tickValue = clock.getTickValue();

            BidEvent event = bidEventSelector.select();

            bidEventSelector.clear();

            if (event != null) {
                if (bidProcessor.process(event, clock, lot)) {
                    int updateQuantity = minQuantityUpdatePolicy.updateMinQuantity(event, clock, lot);
                    int updateTick = tickResetPolicy.resetTickValue(event, clock, lot);

                    minBidQuantity = updateQuantity;
                    lot.reduceQuantityBy(event.getQuantity());

                    support.firePurchaseEvent(tickValue, event.getQuantity());

                    clock.resetTick(updateTick);
                    purchase = true;
                }
            }
        }

        return purchase;
    }

    void stop() {
        support.fireAuctionStopped();
    }

    void start() {
        support.fireAuctionStarted();
    }

    void advanceClock() {
        clock.advanceTick();
    }

    public void addListener(AuctionListener listener) {
        support.addListener(listener);
    }

    public void removeListener(AuctionListener listener) {
        support.removeListener(listener);
    }

    public void removeAllListeners() {
        support.removeAllListeners();
    }
}
