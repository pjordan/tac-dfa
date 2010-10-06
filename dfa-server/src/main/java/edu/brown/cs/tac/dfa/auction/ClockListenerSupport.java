package edu.brown.cs.tac.dfa.auction;

import edu.brown.cs.tac.dfa.util.ListenerSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick R. Jordan
 */
public class ClockListenerSupport extends ListenerSupport<Clock, ClockListener> {
    public ClockListenerSupport(Clock clock) {
        super(clock);
    }

    public void fireTick(int tick) {
        for(ClockListener listener : this) {
            listener.tickOccured(getSource(), tick);
        }
    }
}
