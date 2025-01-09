package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    final int PROPORTION = 5;

    public SimpleGUI(Controller ctrl){

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        frame.setContentPane(canvas);

        JTextField textUp = new JTextField();
        JTextArea textCenter = new JTextArea();
        textCenter.setEditable(false);

        JButton Print = new JButton("Print");
        JButton History =  new JButton("Show History");


        JPanel textOrg = new JPanel();
        textOrg.setLayout(new BorderLayout());

        textOrg.add(Print, BorderLayout.WEST);
        textOrg.add(History, BorderLayout.EAST);

        canvas.add(textOrg, BorderLayout.SOUTH);
        canvas.add(textUp, BorderLayout.NORTH);
        canvas.add(textCenter, BorderLayout.CENTER);

        Print.addActionListener(_ -> {

            ctrl.setString(textUp.getText());

            System.out.println("The current string is: " + ctrl.getCurrentString());
            System.out.println("The next string is: " + ctrl.getNextString());

        });

        History.addActionListener(_ -> {

            final List<String> theStory = new ArrayList<>(ctrl.getHistory());
            for (String s : theStory) {

                textCenter.append(s);
                
            }

        });

    }

    public void display(){

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screen.getWidth();
        final int height = (int) screen.getHeight();

        frame.setSize(width/PROPORTION, height/PROPORTION);

        frame.setLocationByPlatform(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Controller ctrl = new SimpleController();
        new SimpleGUI(ctrl).display();
    }

}
