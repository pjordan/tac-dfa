package edu.brown.cs.tac.dfa.sim;

import com.botbox.util.ArrayUtils;
import se.sics.isl.transport.Transportable;
import se.sics.isl.util.ConfigManager;
import se.sics.isl.util.IllegalConfigurationException;
import se.sics.tasim.aw.Message;
import se.sics.tasim.is.common.Competition;
import se.sics.tasim.sim.Simulation;
import se.sics.tasim.sim.SimulationAgent;
import static edu.brown.cs.tac.dfa.common.TACDFAConstants.*;

/**
 * @author Patrick R. Jordan
 */
public class DFASimulation extends Simulation {
    private Competition competition;

    public DFASimulation(ConfigManager config, Competition competition) {
        super(config);
        this.competition = competition;
    }

    public DFASimulation(ConfigManager config) {
        super(config);
    }

    @Override
    protected void setupSimulation() throws IllegalConfigurationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void startSimulation() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void prepareStopSimulation() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void completeStopSimulation() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected int getAgentRecoverMode(SimulationAgent simulationAgent) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void recoverAgent(SimulationAgent simulationAgent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean validateMessage(SimulationAgent simulationAgent, Message message) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean validateMessageToRole(SimulationAgent simulationAgent, int i, Transportable transportable) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean validateMessageToRole(int i, Transportable transportable) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void messageReceived(Message message) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static String getSimulationRoleName(int simRole) {
        return simRole >= 0 && simRole < ROLE_NAME.length ? ROLE_NAME[simRole]
                : null;
    }

    public static int getSimulationRole(String role) {
        return ArrayUtils.indexOf(ROLE_NAME, role);
    }

}
