package edu.brown.cs.tac.dfa.common;

import edu.umich.eecs.tac.props.AbstractTransportable;
import se.sics.isl.transport.TransportReader;
import se.sics.isl.transport.TransportWriter;

import java.text.ParseException;

/**
 * @author Patrick R. Jordan
 */
public class Bid extends AbstractTransportable {
    /**
     * The auction key.
     */
    private static final String AUCTION_KEY = "auction-key";
    /**
     * The max tick key.
     */
    private static final String MAX_TICK_KEY = "tick-max";
    /**
     * The max tick key.
     */
    private static final String DESIRED_QUANTITY_KEY = "desired-quantity";
        
    private String auction;

    private int maxTick;

    private int desiredQuantity;


    /**
     * Creates a generic Bid.
     */
    public Bid() {
    }

    public Bid(final String auction, final int maxTick, final int desiredQuantity) {
        this.auction = auction;
        this.maxTick = maxTick;
        this.desiredQuantity = desiredQuantity;
    }


    public String getAuction() {
        return auction;
    }

    public int getMaxTick() {
        return maxTick;
    }

    public int getDesiredQuantity() {
        return desiredQuantity;
    }

    public void setAuction(final String auction) throws IllegalStateException {
        lockCheck();
        this.auction = auction;
    }

    public void setMaxTick(final int maxTick) throws IllegalStateException {
        lockCheck();
        this.maxTick = maxTick;
    }

    public void setDesiredQuantity(final int desiredQuantity) throws IllegalStateException {
        lockCheck();
        this.desiredQuantity = desiredQuantity;
    }



    /**
     * Reads the product from the reader.
     * @param reader the reader to read data from.
     * @throws java.text.ParseException if there was an exception reading the product.
     */
    @Override
    protected final void readWithLock(final TransportReader reader) throws ParseException {
        this.setAuction(reader.getAttribute(AUCTION_KEY, null));
        this.setMaxTick(reader.getAttributeAsInt(MAX_TICK_KEY));
        this.setMaxTick(reader.getAttributeAsInt(DESIRED_QUANTITY_KEY));        
    }

    /**
     * Writes the product to the writer.
     * @param writer the writer to write data to.
     */
    @Override
    protected final void writeWithLock(final TransportWriter writer) {
        if (getAuction() != null) {
            writer.attr(AUCTION_KEY, getAuction());
        }

        writer.attr(MAX_TICK_KEY, getMaxTick());
        writer.attr(DESIRED_QUANTITY_KEY, getDesiredQuantity());

    }

    /**
     * Creates a string that displays whether the ad is generic and the product, if targeted.
     * @return a string that displays whether the ad is generic and the product, if targeted.
     */
    @Override
    public final String toString() {
        return String.format("(Bid auction:%s max-tick:%d desired-quantity:%d)", getAuction(), getMaxTick(), getDesiredQuantity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        return desiredQuantity == bid.desiredQuantity && maxTick == bid.maxTick && !(auction != null ? !auction.equals(bid.auction) : bid.auction != null);

    }

    @Override
    public int hashCode() {
        int result = auction != null ? auction.hashCode() : 0;
        result = 31 * result + maxTick;
        result = 31 * result + desiredQuantity;
        return result;
    }
}
