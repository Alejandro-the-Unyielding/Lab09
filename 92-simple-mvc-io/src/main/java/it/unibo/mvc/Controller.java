package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {


    private static String  HOME = System.getProperty("user.home");
    private static String FS = System.getProperty("file.separator");

    private File dest = new File(HOME + FS + "output.txt");

    public Controller() {
    }
    
    public void setCurrentF(final File newFile){
        final File parent = newFile.getParentFile();
        if (parent.exists()) {
            dest = newFile;
        } else {
            throw new IllegalArgumentException("Cannot save in a non-existing folder.");
        }
    }

    public void setCurrentF(String newFile){
        setCurrentF(new File(newFile));
    }

    public File getCurrentF(){
        return dest;
    }

    public String getFPath(){
        return dest.getPath();
    }

    public void writeF(final String Input) throws IOException{

        try(PrintStream out = new PrintStream(dest, StandardCharsets.UTF_8)){

            out.print(Input);
        }
    }

    


}
