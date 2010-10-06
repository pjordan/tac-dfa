package edu.brown.cs.tac.dfa.auction;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Patrick R. Jordan
 */
public class ProxyBidder {

    private Bidder bidder;

    private Map<AuctionInfo,ProxyBid> proxyBids;

    private ProxyAuctionListener auctionListener;

    private ProxyClockListener clockListener;

    private ProxyAuctionScheduleListener scheduleListener;

    public ProxyBidder(Bidder bidder, ClockAuctionScheduler scheduler) {

        this.bidder = bidder;

        proxyBids = new HashMap<AuctionInfo,ProxyBid>();

        auctionListener = new ProxyAuctionListener();

        clockListener = new ProxyClockListener();

        scheduleListener = new ProxyAuctionScheduleListener();

        scheduler.addListener( scheduleListener );
    }


    class ProxyAuctionListener implements AuctionListener {
        public void auctionStarted(ClockAuction auction) {

            auction.getClock().addClockListener( clockListener );

        }

        public void auctionStopped(ClockAuction auction) {

            proxyBids.remove(auction.getInfo());

            auction.removeListener(this);

            auction.getClock().removeClockListener( ProxyBidder.this.clockListener );

        }

        public void purchaseEvent(ClockAuction auction, int tick, BidEvent bidEvent) {
            //TODO: notify the wholesalers

            // Remove the proxy bid so that we do not continuously fire
            if(bidder==bidEvent.getBidder()) {

                proxyBids.remove(auction.getInfo());

            }

        }

    }

    class ProxyClockListener implements ClockListener {
        public void tickOccurred(Clock clock, int tick) {
            ProxyBid proxyBid = proxyBids.get(clock.getClockAuction().getInfo());

            if(tick <= proxyBid.getWillingnessToPay()) {
                int quantity = Math.min(proxyBid.getDesiredQuantity(),
                                        clock.getClockAuction().getQuantityAvailable());

                clock.getClockAuction().bid(bidder,quantity);
            }
        }
    }

    class ProxyAuctionScheduleListener implements AuctionScheduleListener {
        public void auctionsScheduled(Collection<? extends ClockAuction> auctions) {
            for(ClockAuction auction : auctions) {
                auction.addListener( auctionListener );                
            }
        }
    }
}
