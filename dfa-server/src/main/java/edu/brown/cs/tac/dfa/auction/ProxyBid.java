package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
public class ProxyBid {
    private int willingnessToPay;
    private int desiredQuantity;

    public ProxyBid(int willingnessToPay, int desiredQuantity) {
        this.willingnessToPay = willingnessToPay;
        this.desiredQuantity = desiredQuantity;
    }

    public int getWillingnessToPay() {
        return willingnessToPay;
    }

    public int getDesiredQuantity() {
        return desiredQuantity;
    }
}
