package MyTetris;

import javax.swing.*;
import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JPanel implements ActionListener{

    public static final int SCALE = 25;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;

    MyTetris.Point p = new MyTetris.Point();
    ZFigure z = new ZFigure();
    Timer t = new Timer(800, this);

    public Main() {
        t.start();
        addKeyListener(new Kyboard());
        setFocusable(true);
    }

    public void paint(Graphics g){

        //рисуем фон
        g.setColor(Color.cyan);
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
        g.setColor(Color.LIGHT_GRAY);

        //рисуем вертикальные линии
        for (int x = 0; x <= WIDTH*SCALE; x+=SCALE){
            g.drawLine(x, 0, x, HEIGHT*SCALE);
        }

        //рисуем горизонтальные линии
        for (int y = 0; y <= HEIGHT*SCALE; y+=SCALE){
            g.drawLine(0, y, WIDTH*SCALE, y);
        }

        //рисуем фигуру
        for (int d = 0; d < z.length; d++){
            g.setColor(Color.GREEN);
            g.fillRect(z.pointX[d]*SCALE+1, z.pointY[d]*SCALE+1, SCALE-1, SCALE-1);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+30);
        f.setLocationRelativeTo(null);
        f.add(new Main());
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        z.move();
        repaint();
    }

    private class Kyboard extends KeyAdapter {
        public void keyPressed(KeyEvent event){
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_RIGHT) z.direct = Direction.RIGHT;
            if (key == KeyEvent.VK_LEFT) z.direct = Direction.LEFT;
            if (key == KeyEvent.VK_SPACE) {
                if (z.orientation2 == Orientation.UPRIGHT)
                    z.orientation2 = Orientation.HORIZONTALY;
                else
                    z.orientation2 = Orientation.UPRIGHT;
            }
        }
    }
}
