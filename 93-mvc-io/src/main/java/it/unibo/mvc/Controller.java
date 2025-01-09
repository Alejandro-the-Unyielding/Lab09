package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * A methos that sets the next string to print. Null values are not acceptable.
     * 
     * @param next the string that is being set as next
     * @throws IllegalArgumentException if the input string is null
     */

    public void setString(String next) throws IllegalArgumentException;

    /**
     * A method for getting the next string to print
     * 
     * @return String that will be printed next
     * 
     */

    public String getNextString();

    /**
     * A method for getting the history of the printed strings
     * @return A Collection (List<String>) that contains all previous set Strings
     */

    public List<String> getHistory();

    /**
     * A method that prints the current string.
     * @return The String set as Current
     * @throws IllegalArgumentException if there is no current string set
     * 
     */

    public String getCurrentString() throws IllegalArgumentException;



}
