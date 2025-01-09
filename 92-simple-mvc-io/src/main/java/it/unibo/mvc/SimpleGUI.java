package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
@SuppressWarnings("unused")
public final class SimpleGUI {

    private final int PROPORTION = 5;
    private String TITLE = "Simple GUI";
    private final JFrame frame = new JFrame(TITLE);


    public SimpleGUI(final Controller controller) {

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);

        JButton save = new JButton("Save");
        JTextArea text = new JTextArea();
        canvas.add(save, BorderLayout.SOUTH);
        canvas.add(text, BorderLayout.CENTER);

        save.addActionListener(_ -> 
            {
                try {
                    controller.writeF(text.getText());
                    JOptionPane.showMessageDialog(frame, "File saved");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }




    public void display(){


        frame.setVisible(true);
        frame.pack();

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = screenSize.width / PROPORTION;
        final int height = screenSize.height / PROPORTION;

        frame.setSize(width, height);

        frame.setLocationByPlatform(true);
    }
    


    public static void main(final String... args) {
        Controller ctr = new Controller();
        new SimpleGUI(ctr).display();
     }

}
