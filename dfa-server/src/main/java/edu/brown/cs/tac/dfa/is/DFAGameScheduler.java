package edu.brown.cs.tac.dfa.is;

import org.mortbay.http.HttpException;
import org.mortbay.http.HttpRequest;
import org.mortbay.http.HttpResponse;
import se.sics.tasim.is.common.HttpPage;
import se.sics.tasim.is.common.InfoServer;
import se.sics.tasim.is.common.SimServer;

import java.io.IOException;

/**
 * @author Patrick R. Jordan
 */
public class DFAGameScheduler extends HttpPage {
    public DFAGameScheduler(InfoServer infoServer, SimServer simServer, String header) {
    }

    @Override
    public void handle(String s, String s1, HttpRequest httpRequest, HttpResponse httpResponse) throws HttpException, IOException {
        
    }
}
