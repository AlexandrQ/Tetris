package MyTetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Main extends JPanel implements ActionListener{

    private static final int SCALE = 25;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;

    public static boolean canCreate = true;   //разрешает создание нового объекта

    private Point p = new Point();      //вспомогательный объект

    private GameField game = new GameField();

    private Random rand = new Random(System.currentTimeMillis());
    private Timer t = new Timer(250, this); //задержка таймера влияет на "скорость" падения фигур

    public Main() {
        //вводное диалоговое окно
        JOptionPane.showMessageDialog(null, "Добро пожаловать в игру: 'Тетрис'!\n\n" +
                "Управление:\n\tСтрелка влево - передвинуть фигуру на одну позицию влево\n\t" +
                "Стрелка вправо - передвинуть фигуру на одну позицию вправо\n\t" +
                "Пробел - изменить ориентацию фигуры\n\n" +
                "За каждую заполненную строку Вам начисляется 10 очков\n\n" +
                "Удачи!"
        );
        t.start();
        addKeyListener(new Kyboard());
        setFocusable(true);
    }

    public void paint(Graphics g){

        //рисуем фон
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
        g.setColor(Color.lightGray);

        //рисуем вертикальные линии
        for (int x = 0; x <= WIDTH*SCALE; x+=SCALE){
            g.drawLine(x, 0, x, HEIGHT*SCALE);
        }

        //рисуем горизонтальные линии
        for (int y = 0; y <= HEIGHT*SCALE; y+=SCALE){
            g.drawLine(0, y, WIDTH*SCALE, y);
        }

        //рисуем фигуру
        for (int d = 0; d < p.getLength(); d++) {
            g.setColor(Color.GREEN);
            g.fillRect(p.getPointX(d) * SCALE + 1, p.getPointY(d) * SCALE + 1, SCALE - 1, SCALE - 1);
        }

        //рисуем поле с "недвижимыми" объектами
        for (int j = 0; j < game.gameFieldX.size(); j++){
            g.setColor(Color.GREEN);
            g.fillRect(game.gameFieldX.get(j) * SCALE + 1, game.gameFieldY.get(j) * SCALE + 1, SCALE - 1, SCALE - 1);
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
            GameField.findFullLine();
            p = createFigure();
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
                if (p.getOrientation() == Orientation.UPRIGHT)
                    p.setOrientation(Orientation.HORIZONTALY);
                else if (p.getOrientation() == Orientation.HORIZONTALY)
                    p.setOrientation(Orientation.SPECULARUPRIGHT);
                else if (p.getOrientation() == Orientation.SPECULARUPRIGHT)
                    p.setOrientation(Orientation.SPECULARHORIZONTALY);
                else if (p.getOrientation() == Orientation.SPECULARHORIZONTALY)
                    p.setOrientation(Orientation.UPRIGHT);
            }
        }
    }

    //создание новой фигуры
    private Point createFigure(){
        Point obj;
        int choice = rand.nextInt(7)+1; //из семи фигур выбираем одну
        switch (choice){
            case 1:
                obj = new SFigure();
                break;
            case 2:
                obj = new ZFigure();
                break;
            case 3:
                obj = new Line();
                break;
            case 4:
                obj = new TFigure();
                break;
            case 5:
                obj = new LFigure();
                break;
            case 6:
                obj = new JFigure();
                break;
            default:
                obj = new Square();
                break;
        }

        //проверяем может ли созданный объект двигаться вниз
        obj.canIMove();
        //если не может, то конец игры
        if (obj.getCanMoveDown() == false){
            //выводится диалоговое окно с итоговым счетом
            //и запросом на новую игру
            int answer = JOptionPane.showConfirmDialog(null,
                    "Игра окончена! \n" + "Ваш счет: " + GameField.getScore() + "\nНачать новую игру? " ,
                    "Игра окончена",
                    JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.OK_OPTION){
                GameField.clearGameField();
                GameField.setScore(0);
            }
            else { System.exit(0);}
        }
        return obj;
    }
}
