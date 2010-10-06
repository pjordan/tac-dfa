package edu.brown.cs.tac.dfa.auction;

/**
 * @author Patrick R. Jordan
 */
class ClockImpl implements Clock {
    private int tick;

    private ClockListenerSupport support;

    ClockImpl() {
        support = new ClockListenerSupport(this);
    }

    public int getTickValue() {
        return tick;
    }

    public void addClockListener(ClockListener listener) {
        support.addListener(listener);
    }

    public void removeClockListener(ClockListener listener) {
        support.removeListener(listener);
    }

    public void removeAllClockListeners() {
        support.removeAllListeners();
    }

    void advanceTick() {
        tick--;

        support.fireTick(tick);
    }

    void resetTick(int tick) {
        if(this.tick != tick) {
            this.tick = tick;
            support.fireTick(tick);
        }
    }
}
