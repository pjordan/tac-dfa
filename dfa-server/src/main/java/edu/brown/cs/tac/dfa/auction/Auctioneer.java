package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public class Auctioneer implements Runnable {
    private ClockAuctionImpl clockAuction;

    private AuctionStoppingPolicy auctionStoppingPolicy;

    public Auctioneer(ClockAuctionImpl clockAuction, AuctionStoppingPolicy auctionStoppingPolicy) {
        this.clockAuction = clockAuction;
        this.auctionStoppingPolicy = auctionStoppingPolicy;
    }

    public void run() {
        clockAuction.start();

        while(!auctionStoppingPolicy.terminal(clockAuction)) {
            if(clockAuction.processBids()) {
                //TODO: wait for backoff time
            }
            clockAuction.advanceClock();
        }
        clockAuction.stop();
    }
}
