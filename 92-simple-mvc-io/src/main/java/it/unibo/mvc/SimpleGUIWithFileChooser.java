package it.unibo.mvc;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private final int PROPORTION = 4;


    public SimpleGUIWithFileChooser(Controller ctr){

        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);

        JButton BrowseButton = new JButton("Browse...");
        final JTextField textField = new JTextField(ctr.getFPath());
        textField.setEditable(false);

        JPanel SecondPanel = new JPanel();
        SecondPanel.setLayout(new BorderLayout());

        canvas.add(SecondPanel, BorderLayout.NORTH);

        SecondPanel.add(BrowseButton, BorderLayout.EAST);
        SecondPanel.add(textField, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        BrowseButton.addActionListener(_ -> {
        

            JFileChooser fc = new JFileChooser("Choose where to save");
            fc.setSelectedFile(ctr.getCurrentF());
            final int r = fc.showSaveDialog(frame);
            switch(r) {

                case JFileChooser.APPROVE_OPTION:
                    final File dest = fc.getSelectedFile();
                    ctr.setCurrentF(dest);
                    textField.setText(dest.getPath());
                    break;
                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                JOptionPane.showMessageDialog(frame, r, "nigga", JOptionPane.ERROR_MESSAGE);

            }

    });

            JButton save = new JButton("Save");
            canvas.add(save, BorderLayout.SOUTH); 


            JTextArea texter = new JTextArea();
            canvas.add(texter, BorderLayout.CENTER);

            save.addActionListener(_ -> 
            {
                try {
                    ctr.writeF(texter.getText());
                    JOptionPane.showMessageDialog(frame, "File saved");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}



    public void display(){
        
        final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screensize.getWidth();
        final int sh = (int) screensize.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);


        frame.setLocationByPlatform(true);

        

        frame.setVisible(true);


    }

    public static void main(String[] args) {
        Controller ctr = new Controller();
        new SimpleGUIWithFileChooser(ctr).display();
    }

}
