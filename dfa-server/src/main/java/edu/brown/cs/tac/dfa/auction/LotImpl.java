package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
class LotImpl implements Lot {
    private int remainingQuantity;

    LotImpl(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    void reduceQuantityBy(int quantity) {
        remainingQuantity -= quantity;
    }
}
