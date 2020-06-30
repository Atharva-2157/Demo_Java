package game;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

class Gameplay extends JPanel implements KeyListener, ActionListener
{
    private int pos_x;
    private int pos_y;
    private int change_in_x;
    private int change_in_y;


    public Gameplay()
    {
        this.pos_x = 10;
        this.pos_y = 20;
        this.change_in_x = 0;
        this.change_in_y = 0;
        Timer timer = new Timer(110, this);
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int change = 10;
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.change_in_x = change;
            this.change_in_y = 0;
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
            this.change_in_x = -change;
            this.change_in_y = 0;
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_UP){
            this.change_in_x = 0;
            this.change_in_y = -change;
        }
        else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
            this.change_in_x = 0;
            this.change_in_y = change;
        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void paint(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        graphics.drawRect(pos_x, pos_y, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.pos_x += this.change_in_x;
        this.pos_y += this.change_in_y;
        repaint();
    }
}

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gameplay game = new Gameplay();

        frame.add(game);
        frame.addKeyListener(game);

        frame.setBounds(300, 50, 500, 500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
