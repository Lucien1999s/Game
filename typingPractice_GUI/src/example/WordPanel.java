package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordPanel extends JPanel implements Runnable, KeyListener {
    int[] x = new int[10];
    int[] y = new int[10];
    char[] words = new char[10];
    int score = 0;
    Color[] colors=new Color[10];

    public WordPanel(){
        for (int i = 0; i < 10; i++) {
            x[i] = (int)(Math.random()*800);
            y[i] = -(int)(Math.random()*600);
            words[i] = (char)((Math.random()*26)+'A');
            colors[i] = randomColor();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font ft = new Font("", Font.BOLD, 28);
        g.setFont(ft);
        g.drawString("Score："+score+"", 50, 100);
        g.drawLine(0, 500, 800, 500);
        for (int i = 0; i < 10; i++) {

            g.setColor(colors[i]);
            g.drawString(words[i]+"", x[i], y[i]);

        }
    }
    @Override
    public void run() {
        while (true) {
            //
            for (int i = 0; i < 10; i++) {
                y[i]++;
                if (y[i]>600) {
                    y[i] = 0;
                    score--;
                }
            }
            try {
                int speed=15;
                if(score >= 100){
                    speed = 9;
                }
                if(score >= 200){
                    speed = 3;
                }
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            repaint();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            if (words[i] == e.getKeyCode()) {
                x[i] = (int)(Math.random()*800);
                y[i] = 0;
                words[i] = (char)((Math.random()*26)+'A');
                score+=10;
                break;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
    public  Color randomColor(){
        int R = (int)(Math.random()*255);
        int G = (int)(Math.random()*255);
        int B = (int)(Math.random()*255);
        Color color = new Color(R, G, B);
        return color;
    }
}
