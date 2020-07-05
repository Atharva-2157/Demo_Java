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

public class Main extends JPanel implements KeyListener, ActionListener{

    private int pos_x;
    private final int pos_y;
    private int change_in_x;
    private static final int screen_width;
    private static final int screen_height;

    static
    {
        screen_width = 500;
        screen_height = 500;
    }

    class Player
    {
        private int player_w;
        private int player_h;
        private int player_x;
        private int player_y;


    }

    public Main()
    {
        this.pos_x = 10;
        this.pos_y = 10;
        this.change_in_x = 0;
        Timer t = new Timer(5, this);
        t.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Spaced Invaders");
        Main game = new Main();

        frame.add(game);
        frame.addKeyListener(game);

        frame.setBounds(300, 50, screen_width, screen_height);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(this.pos_x, this.pos_y, 20, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.pos_x < 0)
        {
            this.change_in_x = 0;
            this.pos_x = 0;
        }

        if(this.pos_x > screen_width - 30)
        {
            this.change_in_x = 0;
            this.pos_x = screen_width - 30;
        }

        this.pos_x += this.change_in_x;

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

        final int change = 1;
        if(c == KeyEvent.VK_LEFT)
        {
            this.change_in_x = -change;
        }
        if(c == KeyEvent.VK_RIGHT)
        {
            this.change_in_x = change;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.change_in_x = 0;
    }
}
