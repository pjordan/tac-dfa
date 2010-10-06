package edu.brown.cs.tac.dfa.auction;

import edu.brown.cs.tac.dfa.util.StreamSampler;

import java.util.List;

/**
 * @author Patrick R. Jordan
 */
class BidEventSelector {
    private StreamSampler<BidEvent> sampler;

    BidEventSelector() {
        this.sampler = new StreamSampler<BidEvent>();
    }

    public void bid(Bidder bidder, int quantity) {
        sampler.sample(new BidEventImpl(bidder, quantity));
    }

    public BidEvent select() {
        return sampler.getSelected();
    }

    public void clear() {
        sampler.reset();
    }

    class BidEventImpl implements BidEvent {
        private Bidder bidder;
        private int quantity;

        BidEventImpl(Bidder bidder, int quantity) {
            this.bidder = bidder;
            this.quantity = quantity;
        }

        public Bidder getBidder() {
            return bidder;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
