package MyTetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;



public class Main extends JPanel implements ActionListener{

    private static final int SCALE = 25;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;

    public static boolean canCreate = true;   //разрешает создание нового объекта
    public static int index = 0;


    private ArrayList<Point> figures = new ArrayList<Point>();  //массив фигур
    private Point p = new Point();      //вспомогательный объект


    //private ZFigure zFig = new ZFigure();
    private Timer t = new Timer(500, this);

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
        for (int i = 0; i <= index; i++) {
            Point ris = new Point();
            ris = figures.get(i);
            for (int d = 0; d < p.getLength(); d++) {
                g.setColor(Color.GREEN);
                g.fillRect(ris.getPointX(d) * SCALE + 1, ris.getPointY(d) * SCALE + 1, SCALE - 1, SCALE - 1);
            }
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
        p.move();
        if (canCreate) {
            createFigure();
            p = figures.get(index);
            canCreate = false;
        }
        repaint();
    }

    //действия на нажатия клавиш
    private class Kyboard extends KeyAdapter {
        public void keyPressed(KeyEvent event){
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_RIGHT) p.setDirection(Direction.RIGHT);
            if (key == KeyEvent.VK_LEFT) p.setDirection(Direction.LEFT);
            if (key == KeyEvent.VK_SPACE) {
                if (p.getOrientation2() == Orientation.UPRIGHT)
                    p.setOrientation2(Orientation.HORIZONTALY);
                else
                    p.setOrientation2(Orientation.UPRIGHT);
            }
        }
    }

    //добавление нововй фигуры в массив фигур
    private void createFigure(){
        figures.add(new ZFigure());
    }
}
