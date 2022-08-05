package example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame =new JFrame("Typing Practice");

        WordPanel panel= new WordPanel();
        frame.add(panel);
        Thread t=new Thread(panel);
        t.start();
        panel.addKeyListener(panel);
        panel.setFocusable(true);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
