package edu.brown.cs.tac.dfa.common;

/**
 * @author Patrick R. Jordan
 */
public class TACDFAConstants {
    /**
     * Sole constructor (should not be invoked).
     */
    private TACDFAConstants() {
    }

    /**
     * The simulation supported types.
     */
    public static final String[] SUPPORTED_TYPES = {"tac10dfa"};
    /**
     * Human readable message.
     */
    public static final int TYPE_NONE = 0;
    /**
     * Human readable message.
     */
    public static final int TYPE_MESSAGE = 1;
    /**
     * Human readable warning.
     */
    public static final int TYPE_WARNING = 2;
    /**
     * The average network response time for a specific agent (int).
     */
    public static final int DU_NETWORK_AVG_RESPONSE = 64;
    /**
     * The last network response time for a specific agent (int).
     */
    public static final int DU_NETWORK_LAST_RESPONSE = 65;
    /**
     * The bank account status for a specific agent (int or long or double).
     */
    public static final int DU_BANK_ACCOUNT = 100;


    /**
     * The TAC DFA Auctioneer role.
     */
    public static final int AUCTIONEER = 0;
    /**
     * The TAC DFA Wholesaler role.
     */
    public static final int WHOLESALER = 1;
    /**
     * The TAC DFA Retailer role.
     */
    public static final int RETAILER = 2;
    /**
     * The TAC DFA participant roles as human readable names.
     */
    public static final String[] ROLE_NAME = {"Auctioneer", "Wholesaler", "Retailer"};
}
