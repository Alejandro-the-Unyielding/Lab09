package it.unibo.mvc;

import java.util.*;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private List<String> History;

    public SimpleController(){
        this.History = new ArrayList<>();
        History.add("");
    }

    @Override
    public void setString(String next) {
        History.add(next);
    }

    @Override
    public String getNextString() {
        return History.get(History.size());
    }

    @Override
    public List<String> getHistory() {
        return this.History;
    }

    @Override
    public String getCurrentString() throws IllegalArgumentException {

        String current = History.get(History.size()-1);
        return current;
        
    }

    






}
